package web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.common.Paging;
import web.dao.face.BoardDao;
import web.dto.Board;
import web.service.face.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	@Autowired private BoardDao boardDao;
	
	@Override
	public Paging getPaging(Paging curPage) {
		
		//전체 게시글 수 조회
		int totalCount = boardDao.selectCntAll();
		
		//페이징객체 생성
		Paging paging = new Paging(totalCount, curPage.getCurPage());
		
		return paging;
	}
	
	@Override
	public List<Board> getBoardList(Paging paging) {
		return boardDao.selectBoardList(paging);
	}
	
	@Override
	public Board getBoardByBoardNo(int boardNo) {
		return boardDao.selectBoardByBoardNo(boardNo);
	}
	
	@Override
	public void boardWrite(Board write) {
		boardDao.addBoard(write);
	}
}
