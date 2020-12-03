package web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.WebSocketSession;

import web.websocket.domain.ChatRoom;
import web.websocket.repo.ChatRoomRepository;

@Controller
@RequestMapping(value="/chat")
public class ChatController {

	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	private final ChatRoomRepository chatRoomRepository = new ChatRoomRepository();
	
	@RequestMapping(value="/list")
	public void chatList(HttpSession session, Model model) {
		logger.info("채팅리스트 ");
		//session.getAttribute("id");
		List<ChatRoom> list;
		try {
			list = chatRoomRepository.findAllRoom();
		} catch (Exception e) {
			list = null;
		}
		System.out.println(list);
		
		model.addAttribute("rooms", list);
		//logger.info("view페이지로 이동");
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createChatRoom() {
		
		return "chat/creatChatRoom";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createChatRoomProc(String title) {
		logger.info(title);
		chatRoomRepository.createChatRoom(title);
		
		return "redirect:/chat/list";
	}
	
	@RequestMapping(value="/chat/{id}", method=RequestMethod.GET)
	public String room(String id, Model model) {
		ChatRoom room = chatRoomRepository.findRoomById(id);
		logger.info("room : "+room);
		model.addAttribute("room", room);
		return "room";
	}
}
