package com.example.jspboardmodel1;

import jakarta.servlet.*;
import com.example.jspboardmodel1.JDBConnect;

import java.util.*;

public class BoardDAO extends JDBConnect {
  public BoardDAO(ServletContext application) {
    super(application);
  }

  //  검색 조건에 맞는 게시물 개수 반환
  public int selectCount(Map<String, Object> map) {
    int totalCount = 0;
    String query = "SELECT COUNT(*) FROM jspboard2 ";
    if (map.get("searchWord") != null){
      query+="WHERE " + map.get("searchField") + " ";

    }
  }
}
