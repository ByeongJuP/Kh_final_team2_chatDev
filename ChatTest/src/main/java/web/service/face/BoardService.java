package web.service.face;

import java.util.List;

import web.common.Paging;
import web.dto.Board;

public interface BoardService {

	public List<Board> getBoardList(Paging paging);

	public Paging getPaging(Paging curPage);

	public Board getBoardByBoardNo(int boardNo);

	public void boardWrite(Board write);

}
