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
<h1>List</h1>
<hr>

<table>
<tr>
	<td>방이름</td>
</tr>
<c:forEach items="${rooms }" var="${rooms }">
<tr>
	<td><a href="/chat/room/${rooms.id }">${rooms.name }</a></td>
</tr>
</c:forEach>
</table>


</body>
</html>