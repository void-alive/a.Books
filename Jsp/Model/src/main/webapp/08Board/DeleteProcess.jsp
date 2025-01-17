<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="asdf.BoardDAO" %>
<%@ page import="asdf.BoardDTO" %>
<%@ include file="../08Member/IsLoggedIn.jsp" %>
<%
  String num = request.getParameter("num");
  BoardDTO dto = new BoardDTO();
  BoardDAO dao = new BoardDAO(application);

  dao.dbOpen();
  dto = dao.selectView(num);

  String sessionId = session.getAttribute("UserId").toString();

  int delResult = 0;

  if (sessionId.equals(dto.getId())) {
    dto.setNum(num);
    delResult = dao.deletePost(dto);
    dao.close();

    if (delResult == 1) {
      JSFunction.alertLocation("삭제함", "List.jsp", out);
    } else {
      JSFunction.alertBack("삭제 실패", out);
    }
  } else {
    JSFunction.alertBack("본인만 삭제 가능", out);
    return;
  }

  dao.close();
%>