package org.study.reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservationInfoVO {
	private String movie_sub;
	private String movie_age;
	private String cinema_name;
	private String cinema_room;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate schedule_date; 
	@DateTimeFormat(pattern="HH:mm:ss")
	private LocalTime start_time;
	@DateTimeFormat(pattern="HH:mm:ss")
	private LocalTime end_time;
	private int cinema_code;
	private int movie_code;
	private int schedule_code;
	private int cinemaroom_code;
	
	public String getMovie_sub() {
		return movie_sub;
	}
	public void setMovie_sub(String movie_sub) {
		this.movie_sub = movie_sub;
	}
	public String getMovie_age() {
		return movie_age;
	}
	public void setMovie_age(String movie_age) {
		this.movie_age = movie_age;
	}
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
	public int getCinema_code() {
		return cinema_code;
	}
	public void setCinema_code(int cinema_code) {
		this.cinema_code = cinema_code;
	}
	public int getMovie_code() {
		return movie_code;
	}
	public void setMovie_code(int movie_code) {
		this.movie_code = movie_code;
	}
	public int getSchedule_code() {
		return schedule_code;
	}
	public void setSchedule_code(int schedule_code) {
		this.schedule_code = schedule_code;
	}
	public int getCinemaroom_code() {
		return cinemaroom_code;
	}
	public void setCinemaroom_code(int cinemaroom_code) {
		this.cinemaroom_code = cinemaroom_code;
	}
	
}
