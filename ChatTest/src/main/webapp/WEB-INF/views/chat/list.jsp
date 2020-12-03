<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:import url="/WEB-INF/views/layout/header.jsp"/>

<div class = "container">
    <table class = "table table-striped">
        <thead>
        <tr>
            <th>번호</th>
            <th>방 이름</th>
            <th>입장버튼</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${rooms ne null }">
        <c:forEach items="${rooms }" var="rooms">
        <tr>
            <td>${rooms.roomId}</td>
            <td >${rooms.name}</td>
            <td>
                <a class = "btn btn-primary" href = "/chat/room?roomId=${rooms.roomId}">채팅참여</a>
            </td>
        </tr>
        </c:forEach>
        </c:if>
        </tbody>
    </table>
    <a class = "btn btn-primary pull-right" href = "/chat/create">새로 만들기</a>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp"/>