package org.study.member;

import org.study.member.Exception.DuplicateMemberException;

public interface MemberService {
	// 이메일
	public MemberVO selectByEmail(String email) throws Exception;
	
	// 아이디 
	public MemberVO selectById(String id) throws Exception;
	
	public MemberVO selectByIdDup(String id) throws Exception;
	
	// 회원정보 insert service method 
	public void insert(MemberVO memberVO) throws DuplicateMemberException, Exception;
	
	// 회원가입
	public void regist(MemberVO memberVO) throws Exception;
	
	// 회원정보 수정 업데이트
	public void update(MemberVO memberVO) throws Exception;

}
