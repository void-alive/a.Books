package com.example.jspboardmodel1;

import java.sql.*;
// application 내장 객체 타입인 Servlet Context를 사용할 수 있도록 import
import jakarta.servlet.*;

public class JDBConnect {
  //  connection : db와 연결
  public Connection con;
  //  statement : 인파라미터(?) 가 없는 정적 쿼리
  public Statement st;
  //  preparedStatement : 인파라미터(?) 가 있는 동적 쿼리
  public PreparedStatement pst;
  //  resultSet : select의 값 저장
  public ResultSet rs;

  //  기본 생성자
  public JDBConnect() {
    try {
      String driver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://localhost:3306/testfull503db";
      String user = "test1";
      String pass = "full503";

      Class.forName(driver);
      con = DriverManager.getConnection(url, user, pass);
      System.out.println("성공");
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("실패");
      System.out.println(e.getMessage());
    }
  }

  //  web.xml에 context-param
  public JDBConnect(String driver, String url, String id, String pwd) {
    //  컨텍스트 초기화 매개변수로 필요할 때마다 application 내장 객체를 통해 정보를 얻어옴 (간접)
//  하드코딩했던 값을 모두 외부에서 전달받도록 (web.xml)
//  전달받은 값으로 드라이버 로드, db 연결
    try {
      Class.forName(driver);
      con = DriverManager.getConnection(url, id, pwd);
      System.out.println("연결 성공");
    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("연결 실패");
      System.out.println(e.getMessage());
    }
  }

//  컨텍스트 초기화 매개변수를 생성자에서 직접 가져오기
  public JDBConnect(ServletContext application){
//    매개변수로 application 내장 객체 가져오기
//    application을 이용해 web.xml 에서 접속 정보 직접 가져옴
    try{
      String driver = application.getInitParameter("mysqlDriver");
      Class.forName(driver);

      String url = application.getInitParameter("mysqlUrl");
      String user = application.getInitParameter("mysqlUser");
      String pass = application.getInitParameter("mysqlPass");
      con = DriverManager.getConnection(url, user, pass);

      System.out.println("db 연결 성공(servlet)");
    }
    catch(SQLException | ClassNotFoundException e){
      System.out.println(e.getMessage());
    }
  }

  //  기본 연결 종료
  public void close() {
    try {
      if (rs != null) rs.close();
      if (pst != null) pst.close();
      if (st != null) st.close();
      if (con != null) con.close();
      System.out.println("연결 종료");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
