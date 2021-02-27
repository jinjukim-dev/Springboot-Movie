package org.study.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.member.Exception.DuplicateMemberException;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public MemberVO selectByEmail(String email) throws Exception {
		MemberVO memberVo = memberDao.selectByEmail(email);
		return memberVo;
	}
	
	@Override
	public MemberVO selectById(String id) throws Exception {
		MemberVO memberVo = memberDao.selectById(id);
		
		String password = memberVo.getPassword();
		return memberVo;
	}
	
	@Override
	public MemberVO selectByIdDup(String id) throws Exception {
		MemberVO memberVo = memberDao.selectByIdDup(id);
		return memberVo;
	}

	//아이디 중복 체크 하고, insert
	@Override
	public void insert(MemberVO memberVO) throws DuplicateMemberException, Exception {	
		MemberVO member = memberDao.selectByIdDup(memberVO.getId());
		
		if(member != null) {
			throw new DuplicateMemberException("중복된 아이디 : " + memberVO.getId());
		}
		
		memberDao.insert(memberVO);
	}
	
	@Override
	public void regist(MemberVO memberVO) throws Exception {
		
		
	}

	// 회원정보 업데이트
	@Override
	public void update(MemberVO memberVO) throws Exception {
		memberDao.update(memberVO);		
	}
	
}