package org.study.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CinemaRoomDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insertRoom(CinemaRoomVO cinema) throws Exception  {
		sqlSession.insert("org.study.cinema.insertRoom", cinema);
		
	}
	
	public List<CinemaRoomVO> selectCode(int cinema_code) throws Exception  {
		List<CinemaRoomVO> results = sqlSession.selectList("org.study.cinema.selectCinemaCode", cinema_code);
		return results;
	}
	
	public void delete(String cinema_code,String cinema_room) throws Exception  {
		Map<String, String> param =new HashMap<String, String>();
		param.put("cinema_code",cinema_code);
		param.put("cinema_room",cinema_room);
		sqlSession.delete("org.study.cinema.deleteCinemaRoom", param);
	
	}

}
