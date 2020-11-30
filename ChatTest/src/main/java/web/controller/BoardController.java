package web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
		model.addAttribute("view", board);
		
		return "board/view";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		
		
		return "board/write";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String writeProc(Board write, HttpSession session) {
		
		logger.info(write.toString());
		//logger.info((String) session.getAttribute("id"));
		write.setWriterId( (String)session.getAttribute("id") );
		
		//logger.info(write.toString());
		boardService.boardWrite(write);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String boardDelete(int boardNo) {
		
		int res = boardService.deleBoard(boardNo);
		
		if (res == 0) {
			return "redirect:/board/list";
		} else {
			return "redirect:/board/view?boardNo="+boardNo;
		}
	}
	
	@RequestMapping(value="/update", method= RequestMethod.GET)
	public String boardUpdate(int boardNo, Model model) {
		
		Board board = boardService.getBoard(boardNo);
		logger.info(board.toString());
		
		model.addAttribute("board", board);
		
		return "board/update";
	}
}
