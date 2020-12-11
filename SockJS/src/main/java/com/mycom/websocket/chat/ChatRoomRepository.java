package com.mycom.websocket.chat;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.socket.WebSocketSession;

@Repository
public class ChatRoomRepository {

	private final Map<String, ChatRoom> chatRoomMap = new HashMap<>();
	
	
	private final Collection<ChatRoom> chatRooms;

	public Collection<ChatRoom> getChatRooms() {
		return chatRooms;
	}

	public ChatRoomRepository() {
		this.chatRooms = null;
		ChatRoom room1 = new ChatRoom();
		room1.create("1번방");
		chatRoomMap.put(room1.getName(), room1);
		
		ChatRoom room2 = new ChatRoom();
		room2.create("2번방");
		chatRoomMap.put(room2.getName(), room2);
		
		ChatRoom room3 = new ChatRoom();
		room3.create("3번방");
		chatRoomMap.put(room3.getName(), room3);
	}
	
	public ChatRoom getChatRoom(String id) {
		return chatRoomMap.get(id);
	}
	
	public Collection<ChatRoom> getChatRooM(){
		return chatRoomMap.values();
	}
	
    public void remove(WebSocketSession session) {
        this.chatRooms.parallelStream().forEach(chatRoom -> chatRoom.remove(session));
    }
}
