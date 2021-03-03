package org.study.admin;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class MovieScheduleVO {
	private String cinema_name;
	private String cinema_room;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate schedule_date;
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime start_time;
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime end_time;
	private int seat_num;
	private int movie_code;
	public String getCinema_name() {
		return cinema_name;
	}
	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
	}
	public String getCinema_room() {
		return cinema_room;
	}
	public void setCinema_room(String cinema_room) {
		this.cinema_room = cinema_room;
	}
	public LocalDate getSchedule_date() {
		return schedule_date;
	}
	public void setSchedule_date(LocalDate schedule_date) {
		this.schedule_date = schedule_date;
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
	public int getSeat_num() {
		return seat_num;
	}
	public void setSeat_num(int seat_num) {
		this.seat_num = seat_num;
	}
	public int getMovie_code() {
		return movie_code;
	}
	public void setMovie_code(int movie_code) {
		this.movie_code = movie_code;
	}
	
}
