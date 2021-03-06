package org.study.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieScheduleDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public List<ScheduleVO> selectSchedule(int movie_code)  throws Exception {
		List<ScheduleVO> results = sqlSession.selectList("org.study.schedule.selectSchedule", movie_code); 
		return results;
	}

	/* 영화 스케줄 목록보기 */
	public List<ScheduleVO> selectMovieSchedule(int movie_code)  throws Exception {
		List<ScheduleVO> results = sqlSession.selectList("org.study.schedule.selectMovieSchedule", movie_code); 
		return results;
	}
	
	/* RestReserveController */
	public List<MovieScheduleVO> selectMovieSchedule2(int movie_code)  throws Exception {
		List<MovieScheduleVO> results = sqlSession.selectList("org.study.schedule.selectMovieSchedule", movie_code); 
		return results;
	}
	
}
