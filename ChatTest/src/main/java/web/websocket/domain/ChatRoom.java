package web.websocket.domain;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketExtension;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ChatRoom {

	private String roomId;
	private String name;
	private Set<WebSocketSession> sessions = new HashSet<>();
	
	public static ChatRoom create(String title) {
		System.out.println(" + + + create 메소드 + + + ");
		ChatRoom chatRoom = new ChatRoom();
		chatRoom.roomId = UUID.randomUUID().toString();
		chatRoom.name = title;
		
		System.out.println("chatRoom : "+chatRoom);
		System.out.println(" + + + create 메소드 완료");
		return chatRoom;
	}
	
	public void handleMessage(WebSocketSession session
			, ChatMessage chatMessage, ObjectMapper objectMapper) throws IOException{
		
		if(chatMessage.getType() == MessageType.ENTER) {
			sessions.add(session);
			chatMessage.setMessage(chatMessage.getWriter() + "님이 입장하셨습니다.");
		} else if ( chatMessage.getType() == MessageType.LEAVE) {
			sessions.remove(session);
			chatMessage.setMessage(chatMessage.getWriter()+"님이 퇴장하셨습니다.");
		} else {
			chatMessage.setMessage(chatMessage.getWriter()+" : "+chatMessage.getMessage());
		}
		
		send(chatMessage, objectMapper);
	}
	
	private void send(ChatMessage chatMessage, ObjectMapper objectMapper) throws IOException{
		TextMessage textMessage = new TextMessage(objectMapper.writeValueAsBytes(chatMessage.getMessage()));
		for(WebSocketSession sess : sessions) {
			sess.sendMessage(textMessage);
		}
	}
	
	@Override
	public String toString() {
		return "ChatRoom [roomId=" + roomId + ", name=" + name + ", sessions=" + sessions + "]";
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<WebSocketSession> getSessions() {
		return sessions;
	}
	public void setSessions(Set<WebSocketSession> sessions) {
		this.sessions = sessions;
	}
	
	
}
