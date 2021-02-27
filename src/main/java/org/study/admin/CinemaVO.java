package org.study.admin;

public class CinemaVO {
	private int cinema_code;
	private String cinema_location;
	private String cinema_name;
	private String cinema_info;
	
	public String getCinema_info() {
		return cinema_info;
	}
	public void setCinema_info(String cinema_info) {
		this.cinema_info = cinema_info;
	}
	public int getCinema_code() {
		return cinema_code;
	}
	public void setCinema_code(int cinema_code) {
		this.cinema_code = cinema_code;
	}
	public String getCinema_location() {
		return cinema_location;
	}
	public void setCinema_location(String cinema_location) {
		this.cinema_location = cinema_location;
	}
	public String getCinema_name() {
		return cinema_name;
	}
	public void setCinema_name(String cinema_name) {
		this.cinema_name = cinema_name;
	}

}
