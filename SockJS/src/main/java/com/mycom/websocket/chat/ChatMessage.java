package com.mycom.websocket.chat;


public class ChatMessage {

	private String chatRoomId;
	private String writer;
	private String message;
	private MessageType type;
	@Override
	public String toString() {
		return "ChatMessage [chatRoomId=" + chatRoomId + ", writer=" + writer + ", message=" + message + "]";
	}
	public String getChatRoomId() {
		return chatRoomId;
	}
	public void setChatRoomId(String chatRoomId) {
		this.chatRoomId = chatRoomId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
}
