package asdf;

public class MemberDAO extends JDBConnect{
  public MemberDAO(String driver, String url, String id, String pwd){
    super(driver, url, id, pwd);
  }

  public MemberDTO getMemberDTO(String uid, String upass){
    MemberDTO dto = new MemberDTO();
    String query = "SELECT * FROM jspmember2 WHERE id = ? AND pass=? ";
    try{
      pstmt = con.prepareStatement(query);
      pstmt.setString(1, uid);
      pstmt.setString(2, upass);
      rs = pstmt.executeQuery();
      if(rs.next()){
        dto.setId(rs.getString("id"));
        dto.setPass(rs.getString("pass"));
        dto.setName(rs.getString("name"));
        dto.setRegidate(rs.getString("regidate"));
      }
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
    return dto;
  }
}
