package org.study.reservation;

public class ReservationVO {
	private int reservation_code;
	private String id;
	private int cinema_code;
	private int movie_code;
	private int schedule_code;
	private int cinemaroom_code;
	public int getReservation_code() {
		return reservation_code;
	}
	public void setReservation_code(int reservation_code) {
		this.reservation_code = reservation_code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
