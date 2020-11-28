package web.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.common.Paging;
import web.dto.Board;
import web.service.face.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired private BoardService boardService;
	
	@RequestMapping(value="/list")
	public String list(Paging curPage, Model model) {
		
		//페이징 계싼
		Paging paging = boardService.getPaging(curPage);
		model.addAttribute("paging", paging);
		
		List<Board> list = boardService.getBoardList(paging);
		
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(int boardNo, Model model) {
		
		Board board = boardService.getBoardByBoardNo(boardNo);
		model.addAttribute("board", board);
		
		return "board/view";
	}
}
