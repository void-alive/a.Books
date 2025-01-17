<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="asdf.JSFunction" %>
<%
  if (session.getAttribute("UserId") == null) {
    JSFunction.alertLocation("로그인 후 이용해주세요", "../08Member/LoginForm.jsp", out);
    return;
  }
%>