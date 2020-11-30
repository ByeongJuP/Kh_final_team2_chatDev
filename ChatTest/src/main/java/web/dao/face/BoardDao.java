package web.dao.face;

import java.util.List;

import web.common.Paging;
import web.dto.Board;

public interface BoardDao {

	public List<Board> selectBoardList(Paging paging);

	public int selectCntAll();

	public Board selectBoardByBoardNo(int boardNo);

	public void addBoard(Board write);

	public int searchBoardByBoardNo(int boardNo);

	public void deleteBoard(int boardNo);

	public Board getBoardByBoardNo(int boardNo);

	public void updateHit(int boardNo);

}
