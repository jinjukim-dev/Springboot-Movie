package org.study.admin;

public class CinemaRoomVO {
	private int cinemaroom_code;
	private int cinema_code;
	private String cinema_room;
	private int seat_qnt;
	
	public int getCinemaroom_code() {
		return cinemaroom_code;
	}
	public void setCinemaroom_code(int cinemaroom_code) {
		this.cinemaroom_code = cinemaroom_code;
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
	public int getSeat_qnt() {
		return seat_qnt;
	}
	public void setSeat_qnt(int seat_qnt) {
		this.seat_qnt = seat_qnt;
	}
	
}
