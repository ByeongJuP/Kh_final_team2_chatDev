<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />



<input type="text" id="nickname" class="form-inline" placeholder="${id }" readonly>
<button class = "btn btn-primary" id = "name">확인</button>
<label for="roomId" class="label label-default">방 번호</label>
<input type="text"  id="roomId" class="form-inline" placeholder="${room.roomId }" readonly/>
<br>
<label for="roomName" class="label label-default">방 이름</label>
<input type="text" id="roomName" class="form-inline" placeholder="${room.name }" readonly />
<div id = "chatroom" style = "width:400px; height: 600px; border:1px solid; background-color : gray">
</div>

<input type="text" id = "message" style = "height : 30px; width : 340px" placeholder="내용을 입력하세요" autofocus>

<button class="btn btn-primary" onclick="send();">전송 </button>

<script type="text/javascript">
var webSocket;

//웹소켓 객체 생성 코드
var webSocket
if (webSocket !== undefined && webSocket.readyState != WebSocket.CLOSED){
	
} else {
	webSocket = new WebSocket("ws://localhost:8088/chatws/${room.roomId}");
}
webSocket.onopen = onOpen();
webSocket.onmessage = onMessage;

var id = "${id}";
var roomId = "${room.roomId}";

console.log("id:"+id);
console.log("roomId:"+roomId);
$(document).ready(function(){
    //webSocket.onclose = onClose;
})
function send(){
	var msg = document.getElementById("message").value;
	var sendMsg = "{chatRoomId:${room.roomId}, type:CHAT, writer:${id}, message:"+msg+" }"
    console.log("msg : "+msg);
    console.log("msg : "+sendMsg);
    webSocket.send(sendMsg);
	msg ="";
}

function disconnect(){
	var sendMsg = "{chatRoomId:${room.roomId}, type=LEAVE, writer:${id}}"
    webSocket.send(sendMsg);
    webSocket.close();
}

function onOpen(){
	var sendMsg = "{chatRoomId:${room.roomId}, type=ENTER, writer:${id}}"
    webSocket.send(sendMsg);
}

function onMessage(e){
    data = e.data;
    chatroom = document.getElementById("chatroom");
    chatroom.innerHTML = chatroom.innerHTML + "<br>" + data;
}

function onClose(){
    disconnect();
}

</script>

<c:import url="/WEB-INF/views/layout/footer.jsp" />