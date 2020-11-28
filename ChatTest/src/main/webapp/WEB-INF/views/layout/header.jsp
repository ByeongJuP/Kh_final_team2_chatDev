<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jQuery 2.2.4.min -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
/* 모든 페이지에 적용되는 스타일 CSS */

.wrap {
	margin: 0 auto;
	min-width: 1100px;
}

.header {
	text-align: center;
}

.footer {
	text-align: center;
}
#loginBox {
	position: absolute;
	right: 20px;
	top: 20px;
}
</style>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnLogin").click(function() {
		$(location).attr("href", "/member/login");
	});

	$("#btnLogout").click(function() {
		$(location).attr("href", "/member/logout");
	});
})
</script>

</head>
<body>

<div class="wrap">

<div class="header">

	<h1><a href="/">LACUNA SPRING BOARD</a></h1>
	<c:if test='<%=!"member".equals(request.getRequestURI().split("/")[3]) %>'>
	<div id="loginBox">
	<c:choose>
		<c:when test="${empty login }">
			<button id="btnLogin" class="btn">로그인</button>
		</c:when>
		<c:otherwise>
			<div class="pull-right">
				<c:out value="${nick }" />님 환영합니다
				<button id="btnLogout" class="btn btn-warning">로그아웃</button>
			</div>
		</c:otherwise>
	</c:choose>
	</div>
	</c:if>
</div>
