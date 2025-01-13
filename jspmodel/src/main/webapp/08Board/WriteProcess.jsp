<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="asdf.BoardDAO" %>
<%@ page import="asdf.BoardDTO" %>
<%@ include file="../08Member/IsLoggedIn.jsp" %>
<%
  String title = request.getParameter("title");
  String content = request.getParameter("content");

  BoardDTO dto = new BoardDTO();
  dto.setTitle(title);
  dto.setContent(content);
  dto.setId(session.getAttribute("UserId").toString());

  BoardDAO dao = new BoardDAO(application);
  dao.dbOpen();
  int iResult = dao.insertWrite(dto);
  dao.close();

  if (iResult == 1) {
    response.sendRedirect("List.jsp");
  } else {
    JSFunction.alertBack("글쓰기에 실패", out);
  }
%>