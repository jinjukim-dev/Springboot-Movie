package org.study.schedule;

import java.util.List;

import org.study.admin.ScheduleVO;

public interface ScheduleService {
	public List<ScheduleVO> reserveSelectDay() throws Exception;
	public List<ScheduleVO> reserveSelectTime(String movie_code, String cinema_code, String day) throws Exception;
	public ScheduleVO reserveSelectSchedule(String schedule_code) throws Exception;
	public List<ScheduleVO> selectSchedule_date() throws Exception;
}

