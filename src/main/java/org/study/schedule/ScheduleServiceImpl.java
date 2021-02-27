package org.study.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	private ScheduleDAO2 scheduleDAO;
	
	@Override
	public List<ScheduleVO2> reserveSelectDay() throws Exception {
		return scheduleDAO.reserveSelectDay();
	}

	@Override
	public List<ScheduleVO2> reserveSelectTime(String movie_code, String cinema_code, String day) throws Exception {
		// TODO Auto-generated method stub
		return scheduleDAO.reserveSelectTime(movie_code, cinema_code, day);
	}

	@Override
	public ScheduleVO2 reserveSelectSchedule(String schedule_code) throws Exception {
		// TODO Auto-generated method stub
		return scheduleDAO.reserveSelectSchedule(schedule_code);
	}

	@Override
	public List<ScheduleVO2> selectSchedule_date() throws Exception {
		// TODO Auto-generated method stub
		return scheduleDAO.selectSchedule_date();
	}
}
