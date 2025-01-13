<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="asdf.MemberDAO" %>
<%@ page import="asdf.MemberDTO" %>

<%
  String UserId = request.getParameter("user_id");
  String UserPwd = request.getParameter("user_pw");

  String driver = application.getInitParameter("MySqlDriver");
  String url = application.getInitParameter("MySqlUrl");
  String id = application.getInitParameter("MySqlUser");
  String pwd = application.getInitParameter("MySqlPass");

  MemberDAO dao = new MemberDAO(driver, url, id, pwd);
  dao.dbOpen();
  MemberDTO memberDTO = dao.getMemberDTO(UserId, UserPwd);
  dao.close();

  if (memberDTO.getId() != null) {
    session.setAttribute("UserId", memberDTO.getId());
    session.setAttribute("UserName", memberDTO.getName());
    response.sendRedirect("LoginForm.jsp");
  } else {
    request.setAttribute("LoginErrMsg", "로그인 오류");
    request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
  }
%>