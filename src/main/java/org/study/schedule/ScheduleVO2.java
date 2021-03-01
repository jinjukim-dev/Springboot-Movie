package org.study.schedule;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class ScheduleVO2 {
	private int schedule_code;
	private int cinema_code;
	@DateTimeFormat(pattern="HH:mm:ss")
	private LocalTime start_time;
	@DateTimeFormat(pattern="HH:mm:ss")
	private LocalTime end_time;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate schedule_date;
	private int movie_code;
	private int cinemaroom_code;
	public int getSchedule_code() {
		return schedule_code;
	}
	public void setSchedule_code(int schedule_code) {
		this.schedule_code = schedule_code;
	}
	public int getCinema_code() {
		return cinema_code;
	}
	public void setCinema_code(int cinema_code) {
		this.cinema_code = cinema_code;
	}
	public LocalTime getStart_time() {
		return start_time;
	}
	public void setStart_time(LocalTime start_time) {
		this.start_time = start_time;
	}
	public LocalTime getEnd_time() {
		return end_time;
	}
	public void setEnd_time(LocalTime end_time) {
		this.end_time = end_time;
	}
	public LocalDate getSchedule_date() {
		return schedule_date;
	}
	public void setSchedule_date(LocalDate schedule_date) {
		this.schedule_date = schedule_date;
	}
	public int getMovie_code() {
		return movie_code;
	}
	public void setMovie_code(int movie_code) {
		this.movie_code = movie_code;
	}
	public int getCinemaroom_code() {
		return cinemaroom_code;
	}
	public void setCinemaroom_code(int cinemaroom_code) {
		this.cinemaroom_code = cinemaroom_code;
	}
	
}
