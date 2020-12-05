package com.mycom.websocket.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycom.websocket.chat.ChatMessage;
import com.mycom.websocket.chat.ChatRoom;
import com.mycom.websocket.chat.ChatRoomRepository;

public class ChatHandler extends TextWebSocketHandler{
	private static final Logger logger = LoggerFactory.getLogger(ChatHandler.class);
	private final ObjectMapper objectMapper;
	private final ChatRoomRepository repository;
	
	@Autowired
	public ChatHandler(ObjectMapper objectMapper, ChatRoomRepository chatRoomRepository) {
		this.objectMapper = objectMapper;
		this.repository = chatRoomRepository;
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		String payload = message.getPayload();
		logger.info("payload : "+payload);
		
		ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
		ChatRoom chatRoom = repository.getChatRoom(chatMessage.getChatRoomId());
		chatRoom.handleMessage(session, chatMessage, objectMapper);
		super.handleTextMessage(session, message);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		repository.remove(session);
	}
}
