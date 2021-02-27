package org.study.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.member.Exception.WrongIdPasswordException;

@Service
public class AuthService {
	
	@Autowired
	private MemberDAO memberDao;

	public AuthInfo authenticate(String id, String password) throws Exception {
		MemberVO memberVO = memberDao.selectById(id);
		
		if(memberVO == null) {
			throw new WrongIdPasswordException();
		}
		
		return new AuthInfo(
				memberVO.getId(), memberVO.getName());
	}
	
}
