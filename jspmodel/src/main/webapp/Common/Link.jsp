<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<table style="border: 1px solid black; width: 90%;">
  <tr>
    <td style="text-align: center">
      <%
        if(session.getAttribute("UserId")==null){
      %>
      <a href="../08Member/LoginForm.jsp">로그인</a>
      <%
        } else {
      %>
      <a href="../08Member/Logout.jsp">로그아웃</a>
      <%
        }
      %>
      &nbsp;&nbsp;&nbsp;
      <a href="../08Board/List.jsp">게시판(페이징 x)</a>
      &nbsp;&nbsp;&nbsp;
    </td>
  </tr>
</table>