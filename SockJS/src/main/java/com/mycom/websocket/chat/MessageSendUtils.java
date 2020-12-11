package com.mycom.websocket.chat;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;


public class MessageSendUtils {

	private static final Logger logger = LoggerFactory.getLogger(MessageSendUtils.class);
	
	public void sendMessage(WebSocketSession session, TextMessage message) {
        try {
            session.sendMessage(message);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
