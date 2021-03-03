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
		sqlSession.insert("org.study.cinemaroom.insertCinemaroom", cinema);		
	}
	
	public List<CinemaRoomVO> selectAllRoom() throws Exception{
		List<CinemaRoomVO> results = sqlSession.selectList("org.study.cinemaroom.selectAll");
		return results;
	}
	
	public List<CinemaRoomVO> selectCodeRoom(String cinema_code, String cinema_room) throws Exception  {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("cinema_code", cinema_code);
		paramMap.put("cinema_room", cinema_room);
		List<CinemaRoomVO> results = sqlSession.selectList("org.study.cinemaroom.selectCodeRoom", paramMap);
		return results;
	}
	
	public List<CinemaRoomVO> selectCode(int cinema_code) throws Exception  {
		List<CinemaRoomVO> results = sqlSession.selectList("org.study.cinemaroom.selectCode", cinema_code);
		return results;
	}
	
	public void deleCode(int cinemaroom_code) throws Exception{
		sqlSession.delete("org.study.cinemaroom.deleCode", cinemaroom_code);
	}
	
	public void deleCineCode(int cinema_code) throws Exception{
		sqlSession.delete("org.study.cinemaroom.deleCineCode", cinema_code);
	}

}
