package websocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	@RequestMapping(value="/chat")
	public String doChat() {
		logger.info("/chat 접속");
		
		
		return "chat";
	}
}
