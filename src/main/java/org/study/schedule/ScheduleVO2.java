package org.study.schedule;

import java.time.LocalTime;
import java.util.Date;

public class ScheduleVO2 {
	private int schedule_code;
	private int cinema_code;
	private String cinema_room;
	private LocalTime start_time;
	private LocalTime end_time;
	private int seat_qnt;
	private Date schedule_date;
	
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
	public String getCinema_room() {
		return cinema_room;
	}
	public void setCinema_room(String cinema_room) {
		this.cinema_room = cinema_room;
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
	public int getSeat_qnt() {
		return seat_qnt;
	}
	public void setSeat_qnt(int seat_qnt) {
		this.seat_qnt = seat_qnt;
	}
	public Date getSchedule_date() {
		return schedule_date;
	}
	public void setSchedule_date(Date schedule_date) {
		this.schedule_date = schedule_date;
	}
	
	
}
