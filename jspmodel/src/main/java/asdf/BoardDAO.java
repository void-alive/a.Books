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
      query += "LIKE '%'" + map.get("searchWord").toString() + "%' ";
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
      query += "LIKE '%'" + map.get("searchWord").toString() + "%' ";
      query += "ORDER BY num DESC ";

      try{
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);

        while(rs.next()){
          BoardDTO dto = new BoardDTO();
          dto.setNum(rs.getString("num"));
          dto.setTitle(rs.getString("title"));
          dto.setContent(rs.getString("content"));
          dto.setPostdate(rs.getDate("postdate"));
          dto.setId(rs.getString("id"));
          dto.setVisitcount(rs.getString("visitcount"));

          bbs.add(dto);
        }
      }
      catch(Exception e){
        System.out.println("게시물 조회 중 예외 발생");
        System.out.println(e.getMessage());
      }
    }
    return bbs;
  }
}
