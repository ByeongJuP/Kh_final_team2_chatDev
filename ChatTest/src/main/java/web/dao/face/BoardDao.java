package web.dao.face;

import java.util.List;

import web.common.Paging;
import web.dto.Board;

public interface BoardDao {

	public List<Board> selectBoardList(Paging paging);

	public int selectCntAll();

	public Board selectBoardByBoardNo(int boardNo);

	public void addBoard(Board write);

}
