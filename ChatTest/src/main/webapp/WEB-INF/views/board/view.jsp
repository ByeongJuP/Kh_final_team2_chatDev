<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/header.jsp" />

제목 : ${board.title }<br>
작성자 : ${board.writerNick }<br>
조회수 : ${board.hit }<br>
작성일 : <fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss" /><br>
<hr>
${board.content }<br>

<c:import url="/WEB-INF/views/layout/footer.jsp" />