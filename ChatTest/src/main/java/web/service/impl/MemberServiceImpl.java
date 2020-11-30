package web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.MemberDao;
import web.dto.Member;
import web.service.face.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired MemberDao memberDao;
	
	@Override
	public Member checkMember(Member mem) {
		return memberDao.searchByMem(mem);
	}
	
	@Override
	public boolean joinUser(Member mem) {
		//회원가입된 아이디 있는지 조회
		if(memberDao.selectByUserid(mem)>0)
			return false;
		//가입 안되었으면 회원가입 진행
		memberDao.join(mem);
		
		//회원가입이 잘 되었는지 조회
		if(memberDao.selectByUserid(mem)>0)
			return true;
		else return false;
	}
	
}
