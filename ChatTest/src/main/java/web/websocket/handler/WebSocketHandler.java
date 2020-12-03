package web.websocket.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.websocket.domain.ChatMessage;
import web.websocket.domain.MessageType;
import web.websocket.repo.ChatRoomRepository;


public class WebSocketHandler extends TextWebSocketHandler{

	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
	private ChatRoomRepository chatRoomRepository;
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("+ + + webSocekt 연결 + + +");
		logger.info(""+session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("handleTexstMessage접속");
		
//		//전송된 메세지 조회
//		logger.info("메세지 전송 = {} : {}", session, message.getPayload());
//		String msg = message.getPayload();
//		logger.info("msg : "+msg);
//		
//		String[] array = msg.split(", ");
//		ChatMessage chatMessage = new ChatMessage();
//		if (array.length == 3) {
//			chatMessage.setChatRoomId(array[0]);
////			chatMessage.setType( (MessageType)array[1] );
//			chatMessage.setWriter(array[2]);
//			chatMessage.setMessage(array[3]);
//		}
//		for(int i=0; i<array.length;i++) {
//			logger.info(""+array[i]);
//		}
		
//		ChatMessage chatMessage = objectMapper.readValue(msg, ChatMessage.class);
//		logger.info("chatMessage : "+chatMessage);
//		ChatRoom chatRoom = chatRoomRepository.findRoomById(chatMessage.getChatRoomId());
//		logger.info("chatRoom : "+chatRoom);
//		chatRoom.handleMessage(session, chatMessage, objectMapper);
//		logger.info(" + +");
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	}
	

}
