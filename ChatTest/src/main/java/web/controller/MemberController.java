package web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Member;
import web.service.face.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired private MemberService memberService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		
		return "member/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginProc(Member mem, HttpSession session) {
		logger.info("입력된 id : "+mem.getId());
		logger.info("입력된 pw : " +mem.getPw());
		Member member = memberService.checkMember(mem);
		
		if( member != null) {
			session.setAttribute("login", true);
			session.setAttribute("member", member);
			
			return "redirect:/board/list";
		}
		
		return "redirect:/member/login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest req) {
		logger.info("로그아웃 요청");
		session.invalidate();
		
		
		return "redirect:/member/login";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "member/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinProc(Member mem) {
		logger.info(mem.toString());
		
		boolean joinResult = memberService.joinUser(mem);
		
		if(joinResult) {
			return "redirect:/member/login";
		} else {
			return "redirect:/member/join";
		}
	}
	
	@RequestMapping(value="/main")
	public void main() {
		
	} 

}
