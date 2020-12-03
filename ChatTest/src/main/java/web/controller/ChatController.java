package web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.socket.WebSocketSession;

import web.websocket.domain.ChatRoom;
import web.websocket.handler.WebSocketHandler;
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
//		List<ChatRoom> list;
//		try {
//			list = chatRoomRepository.findAllRoom();
//		} catch (Exception e) {
//			list = null;
//		}
//		System.out.println(list);
		System.out.println("조회된 채팅방 : "+chatRoomRepository.findAllRoom() );
		
		model.addAttribute("rooms", chatRoomRepository.findAllRoom());
		//logger.info("view페이지로 이동");
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createChatRoom(Model model) {
		ChatRoomForm form = new ChatRoomForm();
		logger.info("{}",form);
		model.addAttribute("form", form);
		return "chat/creatChatRoom";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createChatRoomProc(ChatRoomForm form) {
		logger.info(""+form);
		chatRoomRepository.createChatRoom(form.getName());
		
		return "redirect:/chat/list";
	}
	
	
	@RequestMapping(value="/room", method=RequestMethod.GET)
	public String room(String roomId, Model model) {
		logger.info("채팅방 입장 ");
		logger.info("id : "+roomId);
		ChatRoom room = chatRoomRepository.findRoomById(roomId);
		logger.info("room : "+room);
		model.addAttribute("room", room);
		return "chat/room";
	}
}
