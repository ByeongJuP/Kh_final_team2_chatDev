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
        <c:if test="${room ne null }">
        <tr th:each="room : ${rooms }">
            <td th:text="${room.roomId}"></td>
            <td th:text="${room.name}"></td>
            <td>
                <a class = "btn btn-primary" th:href = "@{/rooms/{id} (id = ${room.roomId})}"></a>
            </td>
        </tr>
        </c:if>
        </tbody>
    </table>
    <a class = "btn btn-primary pull-right" href = "/chat/create">새로 만들기</a>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp"/>