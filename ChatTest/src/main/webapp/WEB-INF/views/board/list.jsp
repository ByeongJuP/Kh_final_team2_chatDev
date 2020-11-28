<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp"/>

</script>
<style type="text/css">
table {
	/* fixed면 테이블 고정사이즈 유지*/
	table-layout: fixed;
}

table, th {
	text-align: center;
}

td:nth-child(2) {
	text-align: left;
	
	/* white-space : 한줄로표시*/
	/* text-overflow : ellipsis  텍스트가 공간 벗어났을시 ...으로 표시*/
	/* overflow : 크기보다 벗어날경우 보이지 않기*/
	white-space:nowrap;	
	text-overflow: ellipsis;
	overflow: hidden;
}
</style>

<table class="table table-striped table-hover table-condensed">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일시</th>
	</tr>
	<c:forEach items="${list }" var="list">
	<tr>
		<td>${list.boardNo }</td>
		<td><a href="/board/view?boardNo=${list.boardNo}">${list.title }</a></td>
		<td>${list.writerNick }</td>
		<td><fmt:formatDate value="${list.writeDate }" pattern= "yy-MM-dd HH:mm:ss" /></td>
	</tr>
	</c:forEach>

</table>

<c:import url="/WEB-INF/views/common/paging.jsp" />

<c:import url="/WEB-INF/views/layout/footer.jsp"/>
