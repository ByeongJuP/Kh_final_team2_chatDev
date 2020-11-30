<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp"/>

<form action="/member/login" method="post">
<table>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id" /></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pw"/> </td>
	</tr>
	<tr>
		<td><input type="button" value="회원가입" onclick="location.href='/member/join'"></td>
		<td><button>로그인</button></td>
	</tr>
</table>
</form>
<c:import url="/WEB-INF/views/layout/footer.jsp"/>