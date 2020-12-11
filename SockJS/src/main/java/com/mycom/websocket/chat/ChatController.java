package com.mycom.websocket.chat;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/chat")
public class ChatController {

	private final static Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	@Autowired private ChatRoomRepository respository;
	private final AtomicInteger seq = new AtomicInteger(0);
	
	@Autowired
	public ChatController(ChatRoomRepository repository) {
		this.respository = repository;
	}
	
	@RequestMapping(value="/list")
	public String rooms(Model model) {
		model.addAttribute("rooms", respository.getChatRooM());
		return "/chat/room-list";
	}
}
