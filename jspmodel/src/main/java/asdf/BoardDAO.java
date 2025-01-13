package asdf;

import jakarta.servlet.*;

import java.util.*;

public class BoardDAO extends JDBConnect {
  public BoardDAO(ServletContext application) {
    super(application);
  }

  //  검색 조건에 맞는 게시물 개수 반환
  public int selectCount(Map<String, Object> map) {
    int totalCount = 0;

    String query = "SELECT COUNT(*) FROM jspboard2 ";
    if (map.get("searchWord") != null) {
      query += "WHERE " + map.get("searchField") + " ";
      query += "LIKE '%" + map.get("searchWord").toString() + "%' ";
    }
    try {
      stmt = con.createStatement();
      rs = stmt.executeQuery(query);
      rs.next();
      totalCount = rs.getInt(1);
    } catch (Exception e) {
      System.out.println("게시물 수를 구하는 중 예외 발생");
      System.out.println(e.getMessage());
    }
    return totalCount;
  }

  //  검색 조건에 맞는 게시물 목록 반환
  public List<BoardDTO> selectList(Map<String, Object> map) {
    List<BoardDTO> bbs = new Vector<BoardDTO>();

    String query = "SELECT * FROM jspboard2 ";
    if (map.get("searchWord") != null) {
      query += "WHERE " + map.get("searchField") + " ";
      query += "LIKE '%" + map.get("searchWord").toString() + "%' ";
    }
    query += "ORDER BY num DESC ";

    try {
      stmt = con.createStatement();
      rs = stmt.executeQuery(query);

      while (rs.next()) {
        BoardDTO dto = new BoardDTO();
        dto.setNum(rs.getString("num"));
        dto.setTitle(rs.getString("title"));
        dto.setContent(rs.getString("content"));
        dto.setPostdate(rs.getDate("postdate"));
        dto.setId(rs.getString("id"));
        dto.setVisitcount(rs.getString("visitcount"));

        bbs.add(dto);
      }
    } catch (Exception e) {
      System.out.println("게시물 조회 중 예외 발생");
      System.out.println(e.getMessage());
    }
    return bbs;
  }

  //  게시글 데이터를 받아 db에 추가
  public int insertWrite(BoardDTO dto) {
    int result = 0;
    try {
      String query = "INSERT INTO jspboard2 ( ";
      query += "title, content, id, visitcount) values ( ";
      query += "?,?,?,0) ";

      pstmt = con.prepareStatement(query);
      pstmt.setString(1, dto.getTitle());
      pstmt.setString(2, dto.getContent());
      pstmt.setString(3, dto.getId());

      result = pstmt.executeUpdate();
    } catch (Exception e) {
      System.out.println("게시물 입력 중 오류 발생");
      System.out.println(e.getMessage());
    }
    return result;
  }

  //  게시물 내용 반환
  public BoardDTO selectView(String num) {
    BoardDTO dto = new BoardDTO();
    String query = "SELECT member.name, board.* ";
    query +="FROM jspmember2 as member join jspboard2 as board ";
    query +="ON member.id = board.id WHERE num=? ";

    try{
      pstmt = con.prepareStatement(query);
      pstmt.setString(1, num);
      rs = pstmt.executeQuery();

      if(rs.next()){
        dto.setNum(rs.getString("num"));
        dto.setTitle(rs.getString("title"));
        dto.setContent(rs.getString("content"));
        dto.setPostdate(rs.getDate("postdate"));
        dto.setId(rs.getString("id"));
        dto.setVisitcount(rs.getString("visitcount"));
        dto.setName(rs.getString("name"));
      }
    }
    catch(Exception e){
      System.out.println("게시물 상세보기 중 오류 발생");
      System.out.println(e.getMessage());
    }
    return dto;
  }

//  조회수 증가
  public void updateVisitCount(String num){
    String query = "UPDATE jspboard2 SET ";
    query += "visitcount = visitcount+1 ";
    query += "WHERE num = ? ";

    try{
      pstmt = con.prepareStatement(query);
      pstmt.setString(1, num);
      pstmt.executeUpdate();
    }
    catch(Exception e){
      System.out.println("조회수 증가 중 오류 발생");
      System.out.println(e.getMessage());
    }
  }

//  지정한 게시물 수정
  public int updateEdit(BoardDTO dto){
    int result=0;
    try{
      String query = "UPDATE jspboard2 SET ";
      query+="title =?, content=? ";
      query+="WHERE num=? ";

      pstmt=con.prepareStatement(query);
      pstmt.setString(1,dto.getTitle());
      pstmt.setString(2,dto.getContent());
      pstmt.setString(3,dto.getNum());

      result=pstmt.executeUpdate();
    }
    catch(Exception e){
      System.out.println("게시물 수정 중 오류 발생");
      System.out.println(e.getMessage());
    }
    return result;
  }

//  지정한 게시물 삭제
  public int deletePost(BoardDTO dto){
    int result=0;
    try{
      String query = "DELETE FROM jspboard2 WHERE num=? ";
      pstmt = con.prepareStatement(query);
      pstmt.setString(1,dto.getNum());
      result = pstmt.executeUpdate();
    }
    catch(Exception e){
      System.out.println("게시물 삭제 중 오류 발생");
      System.out.println(e.getMessage());
    }
    return result;
  }
}
