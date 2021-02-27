package org.study.schedule;

import java.util.List;

public interface ScheduleService {
	public List<ScheduleVO2> reserveSelectDay() throws Exception;
	public List<ScheduleVO2> reserveSelectTime(String movie_code, String cinema_code, String day) throws Exception;
	public ScheduleVO2 reserveSelectSchedule(String schedule_code) throws Exception;
	public List<ScheduleVO2> selectSchedule_date() throws Exception;
}

