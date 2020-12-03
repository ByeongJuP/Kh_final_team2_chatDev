package web.websocket.config;

import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import web.websocket.handler.WebSocketHandler;

@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

	private final WebSocketHandler webSocketHandler = new WebSocketHandler();
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(webSocketHandler, "/chat/{id}");
	}
}
