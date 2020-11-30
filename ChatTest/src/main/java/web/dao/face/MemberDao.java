package web.dao.face;

import web.dto.Member;

public interface MemberDao {

	public Member searchByMem(Member mem);

	public int selectByUserid(Member mem);

	public void join(Member mem);

}
