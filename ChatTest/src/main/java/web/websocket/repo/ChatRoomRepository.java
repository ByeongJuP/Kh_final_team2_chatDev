package web.websocket.repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;
import org.springframework.web.socket.WebSocketSession;

import web.websocket.domain.ChatRoom;

@Repository
public class ChatRoomRepository {

	private Map<String, ChatRoom> chatRoomMap;

	@PostConstruct
	private void init() {
		chatRoomMap = new LinkedHashMap<>();
	}
	
	public List<ChatRoom> findAllRoom(){
		List<ChatRoom> chatRooms = new ArrayList<>(chatRoomMap.values());
		Collections.reverse(chatRooms);
		return chatRooms;
	}
	
	public ChatRoom findRoomById(String id) {
		return chatRoomMap.get(id);
	}
	
	public ChatRoom createChatRoom(String title) {
		System.out.println(" + + + createChatRoom메소드 + + + ");
		ChatRoom chatRoom = ChatRoom.create(title);
		
		System.out.println("chatRoom : "+chatRoom);
		System.out.println("roomId : "+chatRoom.getRoomId());
		try {
			chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
		} catch (Exception e) {}
		System.out.println("chatRoomMap : "+chatRoomMap);
		System.out.println(" + + + createChatRoom 메소드 완료 + + + ");
		return chatRoom;
	}

	@Override
	public String toString() {
		return "ChatRoomRepository [chatRoomMap=" + chatRoomMap + "]";
	}
	
	
}
