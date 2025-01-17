package fileupload;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MyFileDAO extends JDBConnect {
  public MyFileDAO() {
    super();
  }

  public int insertFile(MyFileDTO dto) {
    int applyResult = 0;
    try {
      String query = "INSERT INTO jspboardfile (title,cate,ofile,sfile,postdate) ";
      query += "VALUES (?,?,?,?,now())";

      pstmt = con.prepareStatement(query);
      pstmt.setString(1, dto.getTitle());
      pstmt.setString(2, dto.getCate());
      pstmt.setString(3, dto.getOfile());
      pstmt.setString(4, dto.getSfile());
      applyResult = pstmt.executeUpdate();
    } catch (Exception e) {
      System.out.println("insert 중 예외 발생");
      System.out.println(e.getMessage());
    }
    return applyResult;
  }

  public List<MyFileDTO> myFileList() {
    List<MyFileDTO> fileList = new ArrayList<MyFileDTO>();

    String query = "SELECT * FROM jspboardfile ORDER BY idx DESC";
    try{
      stmt = con.createStatement();
      rs = stmt.executeQuery(query);

      while(rs.next()){
        MyFileDTO dto = new MyFileDTO();
        dto.setIdx(rs.getString("idx"));
        dto.setTitle(rs.getString("title"));
        dto.setCate(rs.getString("cate"));
        dto.setOfile(rs.getString("ofile"));
        dto.setSfile(rs.getString("sfile"));
        dto.setPostdate(rs.getString("postdate"));
        fileList.add(dto);
      }
    }
    catch(Exception e){
      System.out.println("select 시 예외 발생");
      System.out.println(e.getMessage());
    }
    return fileList;
  }
}
