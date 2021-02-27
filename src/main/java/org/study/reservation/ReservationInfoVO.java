package org.study.reservation;

import java.time.LocalTime;
import java.util.Date;

public class ReservationInfoVO {
	private int movie_code;
	private String movie_sub;
	private int cinema_code;
	private String cinema_name; //영화관지점명
	private String cinema_room; //영화관명
	private int schedule_code;
	//	private String day;
	private Date day;
	private LocalTime start_time;
	private LocalTime end_time;
	private int totalSeat;
	private int extraSeat;
	private int seat_num; //좌석
	private String id;
	private String birth; //회원 나이
	
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
	public String getMovie_sub() {
		return movie_sub;
	}
	public void setMovie_sub(String movie_sub) {
		this.movie_sub = movie_sub;
	}
	public int getCinema_code() {
		return cinema_code;
	}
	public void setCinema_code(int cinema_code) {
		this.cinema_code = cinema_code;
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
	public int getSchedule_code() {
		return schedule_code;
	}
	public void setSchedule_code(int schedule_code) {
		this.schedule_code = schedule_code;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
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
	public int getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	public int getExtraSeat() {
		return extraSeat;
	}
	public void setExtraSeat(int extraSeat) {
		this.extraSeat = extraSeat;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getMovie_age() {
		return movie_age;
	}
	public void setMovie_age(String movie_age) {
		this.movie_age = movie_age;
	}
	private String movie_age; //관람가능나이
}
