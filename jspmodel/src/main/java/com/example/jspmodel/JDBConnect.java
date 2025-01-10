package com.example.jspmodel;

import jakarta.servlet.ServletContext;

import java.sql.*;

public class JDBConnect {
  private String dbDriver;
  private String dbUrl;
  private String dbUser;
  private String dbPass;

  public Connection con;
  public Statement stmt;
  public PreparedStatement pstmt;
  public ResultSet rs;

  public JDBConnect() {
    this(
            "com.mysql.cj.jdbc.Driver",
            "jdbc:mysql://localhost:3306/testfull503db?characterEncoding=UTF-8&serverTimezone=UTC",
            "test1",
            "full503"
    );
  }

  public JDBConnect(ServletContext app) {
    this(app.getInitParameter("MySqlDriver"),
            app.getInitParameter("MySqlUrl"),
            app.getInitParameter("MySqlUser"),
            app.getInitParameter("MySqlPass")
    );
  }

  public JDBConnect(String dbDriver, String dbUrl, String dbUser, String dbPass) {
    this.dbDriver = dbDriver;
    this.dbUrl = dbUrl;
    this.dbUser = dbUser;
    this.dbPass = dbPass;
  }

  public void dbOpen() {
    try {
//      JDBC 드라이버를 메모리에 동적 로딩
//      Class.forName("클래스이름.패키지이름");
      Class.forName(dbDriver);
//      DB 서버와 연결 (DriverManager 클래스의 getConnection() 사용)
//      getConnection(String url, String user, String password);
//      연결 성공 시 DB와 연결된 상태를 Connection 객체로 표현해서 반환
      con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
      System.out.println("Connected to database");
    } catch (Exception e) {
      System.out.println("데이터베이스 연결 실패");
      e.printStackTrace();
    }
  }

  public void close() {
    try{
      if(rs != null) rs.close();
      if(stmt != null) stmt.close();
      if(pstmt != null) pstmt.close();
      if(con != null) con.close();
      System.out.println("Disconnected from database");
    }
    catch(Exception e) {
      System.out.println("데이터베이스 연결 및 리소스 해제 중 오류 발생");
    }
  }
}
