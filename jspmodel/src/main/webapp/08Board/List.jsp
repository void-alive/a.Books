<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.example.jspmodel.BoardDAO" %>
<%@ page import="com.example.jspmodel.BoardDTO" %>
<%
  BoardDAO dao = new BoardDAO(application);

  Map<String, Object> param = new HashMap<String, Object>();
  String searchField = request.getParameter("searchField");
  String searchWord = request.getParameter("searchWord");
  if (searchWord != null) {
    param.put("searchField", searchField);
    param.put("searchWord", searchWord);
  }

  int totalCount = dao.selectCount(param);
  List<BoardDTO> boardLists = dao.selectList(param);
  dao.close();
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>List</title>
</head>
<body>
<jsp:include page="List.jsp"></jsp:include>
<h2>목록 보기(List)</h2>
<%--검색용--%>
<form method="get">
  <table style="border :1px; width : 90%;">
    <tr>
      <td style="text-align : center;">
        <select name="searchField">
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>
        <input type="text" name="searchWord">
        <input type="submit" value="검색하기">
      </td>
    </tr>
  </table>
</form>
<%--게시물 목록 테이블(표)--%>
<table style="border: 1px; width: 90%;">
  <%--  각 컬럼의 이름--%>
  <tr>
    <th style="width:10%;">번호</th>
    <th style="width:50%;">제목</th>
    <th style="width:15%;">작성자</th>
    <th style="width:10%;">조회수</th>
    <th style="width:15%;">작성일</th>
  </tr>
  <%--  목록의 내용 --%>
  <%
    if (boardLists.isEmpty()) {
//      게시물이 하나도 없을 때
  %>
  <tr>
    <td style="column-span: 5; text-align: center;">
      등록된 게시물이 없습니다
    </td>
  </tr>
  <%
  } else {
    int virtualNum = 0;
    for (BoardDTO dto : boardLists) {
      virtualNum = totalCount--;
  %>
  <tr style="text-align: center;">
    <td><%=virtualNum%></td>
    <td style="text-align: left">
      <a href="View.jsp?num=<%=dto.getNum()%>"><%=dto.getTitle()%></a>
    </td>
    <td style="text-align: center;"><%=dto.getId()%> </td>
    <td style="text-align: center;"><%=dto.getVisitcount()%> </td>
    <td style="text-align: center;"><%=dto.getPostdate()%> </td>
  </tr>
  <%
      }
    }
  %>
</table>
<%--목록 하단의 글쓰기 버튼--%>
</body>
</html>
