<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="asdf.BoardDAO" %>
<%@ page import="asdf.BoardDTO" %>
<%@ include file="../08Member/IsLoggedIn.jsp" %>
<%
  String num = request.getParameter("num");
  String title = request.getParameter("title");
  String content = request.getParameter("content");

  BoardDTO dto = new BoardDTO();
  dto.setNum(num);
  dto.setTitle(title);
  dto.setContent(content);

  BoardDAO dao = new BoardDAO(application);
  dao.dbOpen();
  int affected = dao.updateEdit(dto);
  dao.close();

  if (affected == 1) {
    response.sendRedirect("View.jsp?num=" + dto.getNum());
  } else {
    JSFunction.alertBack("수정에 실패함", out);
  }
%>
