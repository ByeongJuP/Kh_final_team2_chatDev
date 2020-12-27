package websocket.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;


public class WebSocketHandler extends TextWebSocketHandler{

	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
	//private ChatRoomRepository chatRoomRepository;
	private ObjectMapper objectMapper = new ObjectMapper();
	
	//세션을 저장할 리스트 생성
	private List<WebSocketSession> sessionList = new ArrayList<>();
	//세션을 저장할 map생성
//	private List<Map<String, String>> sessionList;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("+ + + webSocekt 연결 + + +");
		logger.info(""+session);
		sessionList.add(session);
//		Map<String, String> sessMap = new HashMap<>();
//		sessMap.put(session.getId(), session.getUri().toString());
//		sessionList.add(sessMap);
		
		logger.info(""+sessionList);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("handleTexstMessage접속");
		
		//현재 웹소켓에 접속한 세션
		logger.info("접속중인 session : "+session);
		
		//전송된 메세지 조회
		TextMessage msg = new TextMessage(message.getPayload());
		logger.info("msg : "+msg);
		
		//웹소켓 Uri와 내가 접속한 Uri가 같을때 msg를 뿌려준다.
		for(WebSocketSession sess : sessionList) {
//		for(Map<String, String> sess : sessionList) {
//			sess.sendMessage(msg);
			if(session.getUri().toString().equals(sess.getUri().toString())) {
				logger.info("접속중인 websocket의 uri가 같습니다");
				logger.info("sess    : "+sess.getUri());
				logger.info("session : "+session.getUri());
				sess.sendMessage(msg);
				logger.info("--------------------------------");
				continue;
			} else {
				logger.info("접속중인 websocket의 uri가 다릅니다");
				logger.info("sess    : "+sess.getUri());
				logger.info("session : "+session.getUri());
				logger.info("--------------------------------");
				continue;
			}
		}
		
//		String[] array = msg.split(", ");
//		ChatMessage chatMessage = new ChatMessage();
//		if (array.length == 3) {
//			chatMessage.setChatRoomId(array[0]);
//			chatMessage.setType( (MessageType)array[1] );
//			chatMessage.setWriter(array[2]);
//			chatMessage.setMessage(array[3]);
//		}
//		for(int i=0; i<array.length;i++) {
//			logger.info(""+array[i]);
//		}
//		
//		ChatMessage chatMessage = objectMapper.readValue(msg, ChatMessage.class);
//		logger.info("chatMessage : "+chatMessage);
//		ChatRoom chatRoom = chatRoomRepository.findRoomById(chatMessage.getChatRoomId());
//		logger.info("chatRoom : "+chatRoom);
//		chatRoom.handleMessage(session, chatMessage, objectMapper);
//		logger.info(" + +");
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
	}
	

}
