package org.study.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.study.member.MemberVO;

@Repository
public class ScheduleDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
		public List<ScheduleVO> selectSchedule(int movie_code)  throws Exception {
			List<ScheduleVO> results = sqlSession.selectList("org.study.schedule.selectSchedule", movie_code); 
			return results;
		}
	
		//예약가능 날짜
		public List<ScheduleVO> selectSchedule_date() throws Exception {
			List<ScheduleVO> listSchedule_date = sqlSession.selectList("org.study.schedule.selectSchedule_date");
			return listSchedule_date;
		}
		
		//예약가능스케줄 출력
		public List<ScheduleVO> reserveSelectDay() throws Exception {
			List<ScheduleVO> listSchedule = sqlSession.selectList("org.study.schedule.reserveSelectDay");
			return listSchedule;
		}
		
		public List<ScheduleVO> reserveSelectTime(String movie_code, String cinema_code, String day) throws Exception{
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("movie_code", movie_code);
			paramMap.put("cinema_code", cinema_code);
			paramMap.put("day", day);
			List<ScheduleVO> listSchedule = sqlSession.selectList("org.study.schedule.reserveSelectTime", paramMap);
			return listSchedule;
		}
		
		public ScheduleVO reserveSelectSchedule(String schedule_code) throws Exception{
			ScheduleVO scheduleInfo = sqlSession.selectOne("org.study.schedule.reserveSelectSchedule", schedule_code);
			return scheduleInfo;
		}
	
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
	
	public void delete(int schedule_code) throws Exception  {
		sqlSession.delete("org.study.schedule.deleteSchedule", schedule_code);
	
	}
	
}
