package org.study.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ScheduleDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(ScheduleVO scheduleVO) throws Exception  {
		sqlSession.insert("org.study.schedule.insert", scheduleVO);
		
	}
	
	public MovieVO selectByCode(int movie_code) throws Exception  {
		List<MovieVO> results = sqlSession.selectList("org.study.schedule.selectByCode", movie_code);
		return results.isEmpty() ? null : results.get(0);
	}
	
	
	public List<CinemaVO> selectAll()  throws Exception {
		List<CinemaVO> results = sqlSession.selectList("org.study.schedule.selectCinema"); 
		return results;
	}
	
	public List<CinemaRoomVO> selectRoom(int cinema_code)  throws Exception {
		List<CinemaRoomVO> results = sqlSession.selectList("org.study.schedule.selectRoom",cinema_code); 
		return results;
	}
	
	public List<ScheduleVO> selectScedule(int movie_code)  throws Exception {
		List<ScheduleVO> results = sqlSession.selectList("org.study.schedule.selectScedule",movie_code); 
		return results;
	}
	
	public void delete(int schedule_code) throws Exception  {
		sqlSession.delete("org.study.schedule.deleteSchedule", schedule_code);
	
	}
	
}
