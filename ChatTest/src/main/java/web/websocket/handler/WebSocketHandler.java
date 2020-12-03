package web.websocket.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.websocket.domain.ChatMessage;
import web.websocket.domain.ChatRoom;
import web.websocket.repo.ChatRoomRepository;


public class WebSocketHandler extends TextWebSocketHandler{

	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
	@Autowired private ChatRoomRepository chatRoomRepository;
	private ObjectMapper objectMapper;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("WebSocketHandler 접속");
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		logger.info("메세지 전송 = {} : {}", session, message.getPayload());
		String msg = message.getPayload();
		ChatMessage chatMessage = objectMapper.readValue(msg, ChatMessage.class);
		ChatRoom chatRoom = chatRoomRepository.findRoomById(chatMessage.getChatRoomId());
		chatRoom.handleMessage(session, chatMessage, objectMapper);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
	}

}
