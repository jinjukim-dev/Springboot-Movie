package org.study.schedule;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScheduleDAO2 {
	@Autowired
	private SqlSession sqlSession;
	
	//예약가능 날짜
	public List<ScheduleVO2> selectSchedule_date() throws Exception {
		List<ScheduleVO2> listSchedule_date = sqlSession.selectList("org.study.schedule.selectSchedule_date");
		return listSchedule_date;
	}
	
	//예약가능스케줄 출력
	public List<ScheduleVO2> reserveSelectDay() throws Exception {
		List<ScheduleVO2> listSchedule = sqlSession.selectList("org.study.schedule.reserveSelectDay");
		return listSchedule;
	}
	
	public List<ScheduleVO2> reserveSelectTime(String movie_code, String cinema_code, String day) throws Exception{
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("movie_code", movie_code);
		paramMap.put("cinema_code", cinema_code);
		paramMap.put("day", day);
		List<ScheduleVO2> listSchedule = sqlSession.selectList("org.study.schedule.reserveSelectTime", paramMap);
		return listSchedule;
	}
	
	public ScheduleVO2 reserveSelectSchedule(String schedule_code) throws Exception{
		// TODO Auto-generated method stub
		ScheduleVO2 scheduleInfo = sqlSession.selectOne("org.study.schedule.reserveSelectSchedule", schedule_code);
//		System.out.println("dao : "+scheduleInfo.getSchedule_code());
//		System.out.println("dao : "+scheduleInfo.getSeat_qnt());
//		System.out.println("dao : "+scheduleInfo.getStart_time());
//		System.out.println("dao : "+scheduleInfo.getCinema_code());
//		System.out.println("dao : "+scheduleInfo.getEnd_time());
//		System.out.println("dao : "+scheduleInfo.getSchedule_date());
//		
//		System.out.println("dao : "+scheduleInfo.getCinema_room());
		return scheduleInfo;
	}
	
	
//	public MemberVO selectByEmail(String email) throws Exception  {
//		List<MemberVO> results = sqlSession.selectList("org.study.member.selectByEmail", email);
//		return results.isEmpty() ? null : results.get(0);
//	}
//	
//	public MemberVO selectById(Long id) throws Exception  {
//		MemberVO result = sqlSession.selectOne("org.study.member.selectById", id);
//		return result;
//	}
//
//	public List<MemberVO> selectByRegdate(Map<String, LocalDateTime> dateData) throws Exception  {
//		List<MemberVO> results = sqlSession.selectList("org.study.member.selectByRegdate", dateData);
//		return results;
//	}
//	
//	public void insert(CinemaVO cinema) throws Exception  {
//		sqlSession.insert("org.study.cinema.insert", cinema);
//		
//	}
//
//	public void update(MemberVO member) throws Exception  {
//		sqlSession.update("org.study.member.update", member);
//	}
//
//	public List<MemberVO> selectAll()  throws Exception {
//		List<MemberVO> results = sqlSession.selectList("org.study.member.selectAll"); 
//		return results;
//	}
//
//	public int count() throws Exception  {
//		Integer count = sqlSession.selectOne("org.study.member.count", Integer.class);
//		return count;
//	}
}
