package web.service.face;

import web.dto.Member;

public interface MemberService {

	public Member checkMember(Member mem);

	public boolean joinUser(Member mem);

}
