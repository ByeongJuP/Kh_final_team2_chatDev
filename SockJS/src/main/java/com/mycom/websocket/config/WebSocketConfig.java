//package com.mycom.websocket.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//import com.mycom.websocket.handler.ChatHandler;
//
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer{
//	
//	@Autowired ChatHandler chatHandler;
//	
//	@Override
//	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//		// TODO Auto-generated method stub
//		//Endpoint로 handshake가 이루어진다
//		registry.addHandler(chatHandler, "/ws/chat").setAllowOrigins("*").withSockJs();
//		
//	}
//
//}
