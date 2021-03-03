package org.study.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.admin.ScheduleDAO;
import org.study.admin.ScheduleVO;

@Service
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	private ScheduleDAO scheduleDAO;
	
	@Override
	public List<ScheduleVO> reserveSelectDay() throws Exception {
		return scheduleDAO.reserveSelectDay();
	}

	@Override
	public List<ScheduleVO> reserveSelectTime(String movie_code, String cinema_code, String day) throws Exception {
		return scheduleDAO.reserveSelectTime(movie_code, cinema_code, day);
	}

	@Override
	public ScheduleVO reserveSelectSchedule(String schedule_code) throws Exception {
		return scheduleDAO.reserveSelectSchedule(schedule_code);
	}

	@Override
	public List<ScheduleVO> selectSchedule_date() throws Exception {
		return scheduleDAO.selectSchedule_date();
	}
}
