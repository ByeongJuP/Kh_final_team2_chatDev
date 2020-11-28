<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 목록</h1>
<hr>

<table border="1">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일시</th>
	</tr>
	<c:forEach items="${list }" var="list">
	<tr>
		<td>${list.boardNo }</td>
		<td>${list.title }</td>
		<td>${list.writerNick }</td>
		<td>${list.writeDate }</td>
	</tr>
	</c:forEach>

</table>

</body>
</html>