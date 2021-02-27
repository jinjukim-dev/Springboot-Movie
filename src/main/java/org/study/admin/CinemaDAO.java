package org.study.admin;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.study.member.MemberVO;
import org.study.admin.CinemaVO;

@Repository
public class CinemaDAO {
	@Autowired
	private SqlSession sqlSession;

	public CinemaVO selectByCode(int cinema_code) throws Exception  {
		List<CinemaVO> results = sqlSession.selectList("org.study.cinema.selectByCode", cinema_code);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public CinemaVO selectByCode1(int cinema_code) throws Exception  {
		CinemaVO result = sqlSession.selectOne("org.study.cinema.selectByCode", cinema_code);
		return result;
	}

	public List<MemberVO> selectByRegdate(Map<String, LocalDateTime> dateData) throws Exception  {
		List<MemberVO> results = sqlSession.selectList("org.study.member.selectByRegdate", dateData);
		return results;
	}
	
	public void insert(CinemaVO cinema) throws Exception  {
		sqlSession.insert("org.study.cinema.insertCinema", cinema);
		
	}

	public void delete(int cinema_code) throws Exception  {
		sqlSession.delete("org.study.cinema.deleteCinema", cinema_code);
	
	}
	
	public void update(MemberVO member) throws Exception  {
		sqlSession.update("org.study.member.update", member);
	}

	public List<CinemaVO> selectAll()  throws Exception {
		List<CinemaVO> results = sqlSession.selectList("org.study.cinema.SelectCinema"); 
		return results;
	}

	public int count() throws Exception  {
		Integer count = sqlSession.selectOne("org.study.member.count", Integer.class);
		return count;
		
		
	}
	
	public CinemaRoomVO selectCode(int cinema_code) throws Exception  {
		List<CinemaRoomVO> results = sqlSession.selectList("org.study.cinema.selectCinemaRoomInfo", cinema_code);
		return results.isEmpty() ? null : results.get(0);
	}
}
