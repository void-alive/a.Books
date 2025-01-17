package fileupload;

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
}
