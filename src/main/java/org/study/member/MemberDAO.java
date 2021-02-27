package org.study.member;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;

	public MemberVO selectByEmail(String email) throws Exception  {
		List<MemberVO> results = sqlSession.selectList("org.study.member.selectByEmail", email);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public MemberVO selectById(String id) throws Exception  {
		MemberVO result = sqlSession.selectOne("org.study.member.selectById", id);		
		return result;	
	}
	
	public MemberVO selectByIdDup(String id) throws Exception {
		List<MemberVO> results = sqlSession.selectList("org.study.member.selectById", id);
		return results.isEmpty() ? null : results.get(0);
	}

	public List<MemberVO> selectByRegdate(Map<String, LocalDateTime> dateData) throws Exception  {
		List<MemberVO> results = sqlSession.selectList("org.study.member.selectByRegdate", dateData);
		return results;
	}
	
	public void insert(MemberVO member) throws Exception  {
		sqlSession.insert("org.study.member.insert", member);	
	}
	

	public void update(MemberVO member) throws Exception  {
		sqlSession.update("org.study.member.update", member);
	}

	public List<MemberVO> selectAll()  throws Exception {
		List<MemberVO> results = sqlSession.selectList("org.study.member.selectAll"); 
		return results;
	}

	public int count() throws Exception  {
		Integer count = sqlSession.selectOne("org.study.member.count", Integer.class);
		return count;
	}
	
	public void delete(String id) throws Exception  {
		sqlSession.delete("org.study.member.deleteMember", id);
	
	}
	public List<MemberVO> selectId(String id) throws Exception {
		List<MemberVO> results = sqlSession.selectList("org.study.member.selectName", id);
		return results;
	}

}
