<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="asdf.BoardDAO" %>
<%@ page import="asdf.BoardDTO" %>
<%@ include file="../08Member/IsLoggedIn.jsp" %>
<%
  String num = request.getParameter("num");
  BoardDAO dao = new BoardDAO(application);
  dao.dbOpen();
  BoardDTO dto = dao.selectView(num);
  String sessionId = session.getAttribute("UserId").toString();
  if(!sessionId.equals(dto.getId())){
    JSFunction.alertBack("작성자 본인만 수정할 수 있습니다",out);
    return;
  }
  dao.close();
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <script type="text/javascript">
      function validateForm(form) {
          if (form.title.value == "") {
              alert("제목 입력");
              form.title.focus();
              return false;
          }
          if (form.content.value == "") {
              alert("내용 입력");
              form.content.focus();
              return false;
          }
      }
  </script>
</head>
<body>
<jsp:include page="../Common/Link.jsp"></jsp:include>

<h2>회원제 게시판 수정하기</h2>
<form name="writeFrm" method="post" action="EditProcess.jsp">
  <input type="hidden" name="num" value="<%=dto.getNum()%>">
  <table style="border:1px solid black; width: 90%;">
    <tr>
      <td>제목</td>
      <td>
        <input type="text" name="title" style="width:90%;" value="<%=dto.getTitle()%>">
      </td>
    </tr>
    <tr>
      <td>내용</td>
      <td>
        <textarea name="content" style="width: 90%; height: 100px;" value="<%=dto.getContent()%>">
        </textarea>
      </td>
    </tr>
    <tr>
      <td style="column-span: 2; text-align: center;">
        <button type="submit">작성 완료</button>
        <button type="reset">다시 작성</button>
        <button type="button" onclick="location.href='List.jsp'">목록 보기</button>
      </td>
    </tr>
  </table>
</form>
</body>
</html>

