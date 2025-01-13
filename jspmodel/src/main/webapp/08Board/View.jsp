<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="asdf.BoardDAO" %>
<%@ page import="asdf.BoardDTO" %>
<%
  String num = request.getParameter("num");

  BoardDTO dto = new BoardDTO();
  BoardDAO dao = new BoardDAO(application);
  dao.dbOpen();
  dto = dao.selectView(num);
  dao.updateVisitCount(num);
  dao.close();
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
          crossorigin="anonymous"></script>
  <script>
      function deletePost() {
          let confirmed = confirm("정말로 삭제하겠습니까?");
          if (confirmed) {
              let form = document.writeFrm;
              form.method = "post";
              form.action = "DeleteProcess.jsp";
              form.submit();
          }
      }
  </script>
</head>
<body>
<jsp:include page="../Common/Link.jsp"></jsp:include>
<h2>회원제 게시판 - 상세보기</h2>
<form name="writeFrm">
  <input type="hidden" name="num" value="<%=num%>">
  <table style="border: 1px solid black; width: 90%;">
    <tr>
      <td>번호</td>
      <td><%=dto.getNum()%>
      </td>
      <td>작성자</td>
      <td><%=dto.getName()%>
      </td>
    </tr>
    <tr>
      <td>작성일</td>
      <td><%=dto.getPostdate()%>
      </td>
      <td>조회수</td>
      <td><%=dto.getVisitcount()%>
      </td>
    </tr>
    <tr>
      <td>제목</td>
      <td style="column-span: 3"><%=dto.getTitle()%>
      </td>
    </tr>
    <tr>
      <td>내용</td>
      <td style="column-span: 3; height: 100px;">
        <%=dto.getContent().replace("\r\n", "<br>") %>
      </td>
    </tr>
    <tr>
      <td style="column-span: 4; text-align: center">
        <%
          if (session.getAttribute("UserId") != null
                  && session.getAttribute("UserId").toString().equals(dto.getId())) {
        %>
        <button type="button" onclick="location.href = 'Edit.jsp?num=<%=dto.getNum()%>';">
          수정하기
        </button>
        <button type="button" onclick="deletePost();">삭제하기</button>
        <%
          }
        %>
        <button type="button" onclick="location.href = 'List.jsp';">목록 보기</button>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
