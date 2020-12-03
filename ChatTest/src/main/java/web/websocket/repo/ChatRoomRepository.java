package web.websocket.repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import web.websocket.domain.ChatRoom;

@Repository
public class ChatRoomRepository {

	private static final Logger logger = LoggerFactory.getLogger(ChatRoomRepository.class);
	private Map<String, ChatRoom> chatRoomMap = new LinkedHashMap<>();

//	@PostConstruct
//	private void init() {
//		chatRoomMap = new LinkedHashMap<>();
//	}
//	
	public List<ChatRoom> findAllRoom(){
		List<ChatRoom> chatRooms = new ArrayList<>(chatRoomMap.values());
		Collections.reverse(chatRooms);
		return chatRooms;
	}
	
	//채팅방 조회하기
	public ChatRoom findRoomById(String roomId) {
		logger.info("+ + + 채팅방 조회 + + +");
		logger.info("id : "+roomId);
		logger.info("id로 조회된 방 : "+chatRoomMap.get(roomId));
		return chatRoomMap.get(roomId);
	}
	
	public ChatRoom createChatRoom(String name) {
		logger.info(" + + + createChatRoom메소드 + + + ");
		ChatRoom chatRoom = ChatRoom.create(name);
		
		logger.info("chatRoom : "+chatRoom);
		logger.info("roomId : "+chatRoom.getRoomId());
		
		//오류 발생해서 예외처리 등록
		try {
			chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
		} catch (Exception e) {
			logger.info(" + + + 오류 발생 + + +");
			logger.info(" + + + 오류 원인 :"+e.getMessage()+" + + +");
		}
		logger.info("chatRoomMap : "+chatRoomMap);
		logger.info(" + + + createChatRoom 메소드 완료 + + + ");
		return chatRoom;
	}

	@Override
	public String toString() {
		return "ChatRoomRepository [chatRoomMap=" + chatRoomMap + "]";
	}
	
	
}
