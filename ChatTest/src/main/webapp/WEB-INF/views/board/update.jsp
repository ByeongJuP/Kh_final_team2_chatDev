<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<!-- 스마트 에디터2 라이브러리 로드 -->
<script type="text/javascript" 
	src="/resources/se2/js/service/HuskyEZCreator.js"
	charset="utf-8">
</script>

<script type="text/javascript">
$(document).ready(function(){
	$("#btnUpdate").click(function(){
		//스마트데이터의 내용을 <textarea>에 적용하기
		submitContents( $("btnUpdate"));
		
		//form submit 수행하기
		$("form").submit();
	})
	
	$("#cancel").click(function(){
		history.go(-1);
	})
})
</script>

<div class="container">

<h1>글쓰기 페이지</h1>
<hr>
<form action="/board/write" method="post">
	<div class="form-group">
		<label for="writer">작성자</label>
		<input type="text" id="writer" value="${board.writerId }" readonly="readonly" class="form-control"/>
	</div>
	
	<div class="form-group">
		<label for="title">제목</label>
		<input type="text" id="title" value="${board.title}" name="title" class="form-control" />
	</div>
	
	<div class="form-group">
		<label for="content">본문</label>
		<textarea rows="10" style="width:100%" id="content" name="content">${board.content }</textarea>
	</div>
	
	<div class="text-center">
		<button class="btn btn-primary" id="btnUpdate">수정</button>
		<input type="reset" id="cancel" class="btn btn-danger" value="취소"/>
	</div>
</form>

</div>

<!-- 스마트에디터 초기화코드 -->
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	    oAppRef: oEditors,
	    elPlaceHolder: "content",
	    sSkinURI: "/resources/se2/SmartEditor2Skin.html",
	    fCreator: "createSEditor2"
});

function submitContents(elClickedObj) {
    // 에디터의 내용이 textarea에 적용된다.
    oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

    try {
        elClickedObj.form.submit();
    } catch(e) {}
}
</script>

<c:import url="/WEB-INF/views/layout/footer.jsp" />