<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />
<script type="text/javascript">
$(document).ready(function(){
	$("#createBtn").click(function(){
		var title = $("#title").val();
		console.log(title);
		if( title == "" ){
			console.log("내용이 없습니다.");
			alert("방이름을 입력하세요!");
			return false;
		}
	})
})
</script>


<div class="container">

    <form class="form-signing" action="/chat/create" method= "post">
        <h2 class="form-signing-heading">새로운 채팅방 생성</h2>
        <label for="title" class="sr-only">채팅방 이름</label>
        <input type="text" id="title" name="title" class="form-control" placeholder="채팅방 이름을 입력해주세요" required autofocus>
        <br>
        <button class="btn btn-primary" type="submit" id="createBtn">생성하기</button>
        <button class="btn btn-danger" onclick = "location.href='/'">돌아가기</button>
    </form>

</div> <!-- /container -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />