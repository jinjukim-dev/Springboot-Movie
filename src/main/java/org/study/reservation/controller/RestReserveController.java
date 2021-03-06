package org.study.reservation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.CipherInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.study.admin.CinemaDAO;
import org.study.admin.CinemaVO;
import org.study.admin.MovieScheduleDAO;
import org.study.admin.MovieScheduleVO;
import org.study.admin.ScheduleDAO;
import org.study.admin.ScheduleVO;
import org.study.reservation.ReservationInfoVO;
import org.study.reservation.ReservationService;

@RestController
public class RestReserveController {
	Logger log = LoggerFactory.getLogger(RestReserveController.class);
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private MovieScheduleDAO movieScheduleDAO;
	
	@Autowired
	private CinemaDAO cinemaDAO;
	
	/* 예매 page-1에서 스케줄에서 해당 영화 지점 정보 가져오기 */
	@PostMapping("getCinemaInfo/{movie_code}")
	public Map getCinema(@PathVariable("movie_code") int movie_code) throws Exception{
		
		List<MovieScheduleVO> list = movieScheduleDAO.selectMovieSchedule2(movie_code);
		
		// cinema_code, cinema_name Map으로해서 보내기
		Map<Integer, String> map = new HashMap<>();		
		for(int i=0; i<list.size(); i++) {	
			String cinema_name = list.get(i).getCinema_name();
			CinemaVO cinema = cinemaDAO.selectByName(cinema_name);
			
			map.put(cinema.getCinema_code(), cinema_name);
	
		}
		
		System.out.println("---- cinema_code, cinema_name Map 출력 ------");
		for(Integer key : map.keySet()) {
			String value = (String) map.get(key);
			System.out.println(key + " : " + value);
		}
		
		return map;
	}
	
	/* 예매 page-1에서 스케줄에서 해당 지점 상영관 정보 가져오기   수정중!!!!*/
	@PostMapping("getCinemaRoom/{movie_code}/{cinema_code}")
	public Map getCinemaRoom(@PathVariable int movie_code, int cinema_code)  throws Exception{
		
//		List<ReservationInfoVO> scheduleList =  reservationService.selectScheduleAll();
//		
//		Map<Integer, String> map = new HashMap<>();
//		for(int i=0; i<scheduleList.size(); i++) {
//			if(scheduleList.get(i).getMovie_code() == movie_code) {			
//				if(scheduleList.get(i).getCinema_code() == cinema_code) {
//					// cinemaroom_code, cinema_room Map으로해서 보내기
//					map.put(scheduleList.get(i).getCinemaroom_code(), scheduleList.get(i).getCinema_room());
//				}
//			}
//		}
//		
//		System.out.println("---- cinemaroom_code, cinema_room Map 출력 ------");
//		for(Integer key : map.keySet()) {
//			String value = (String) map.get(key);
//			System.out.println(key + " : " + value);
//		}
//		
//		return map;
		return null;
	}
	
	@GetMapping("reservePage02")
	public Map<String, String> seatDup(
			@RequestParam("seatArr") String seatArr, 
			@RequestParam("schedule_code") String schedule_code
			){
		
		Map<String , String> map = new HashMap<String, String>();
		
		log.info("RestSeatController중복확인"+seatArr + "/" + schedule_code);
		
		/*
		 * try {
		 * 
		 * if(reservationService.selectDup(seatArr, schedule_code) == null) {
		 * System.out.println("null"); }
		 * 
		 * if(!reservationService.selectDup(seatArr, schedule_code).isEmpty()) { //값이
		 * 있으면 중복 System.out.println("중복!!"); map.put("code", "dup"); }else {
		 * map.put("code", "noDup"); } } catch (Exception e) { // TODO: handle exception
		 * }
		 */
		return map;
	}
}
