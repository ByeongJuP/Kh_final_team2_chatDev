package webSocket.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginProc(String id, HttpSession session) {
		logger.info("id : "+id);
		session.setAttribute("id", id);
		
		return "redirect:/chat";
	}
	
	@RequestMapping(value="/chat")
	public String chat() {
		return "chat";
	}
}
