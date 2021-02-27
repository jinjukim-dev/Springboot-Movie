package org.study.cinema;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.study.member.MemberVO;

@Repository
public class CinemaDAO2 {
	@Autowired
	private SqlSession sqlSession;
	
	//예매 극장리스트출력
	public List<CinemaVO2> reserveSelectCinema() throws Exception{
		List<CinemaVO2> listCinema = sqlSession.selectList("org.study.cinema.reserveSelectCinema");
		return listCinema;
	}
	
	public CinemaVO2 selectCinemaInfo(String cinema_code) throws Exception {
		CinemaVO2 cinemaInfo = sqlSession.selectOne("org.study.cinema.selectCinemaInfo", cinema_code);
		return cinemaInfo;
	}
	
	public void insert(CinemaVO2 cinema) throws Exception  {
		sqlSession.insert("org.study.cinema.insert", cinema);
		
	}

}
