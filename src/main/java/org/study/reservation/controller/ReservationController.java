package org.study.reservation.controller;

import java.text.SimpleDateFormat;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.study.admin.DataDAO;
import org.study.admin.DataVO;

import org.study.admin.MovieDAO;

import org.study.admin.MovieVO;
import org.study.admin.ReserveDAO;
import org.study.admin.ReserveVO;
import org.springframework.web.bind.annotation.RequestParam;

import org.study.member.AuthInfo;
import org.study.member.AuthService;
import org.study.member.MemberDAO;
import org.study.member.MemberVO;
import org.study.member.controller.LoginCommand;
import org.study.reservation.ReservationDAO;
import org.study.reservation.ReservationInfoVO;
import org.study.reservation.ReservationService;
import org.study.reservation.ReservationVO;
import org.study.schedule.ScheduleService;
import org.study.admin.ScheduleVO;

@Controller
@RequestMapping("reservation")
public class ReservationController {
	Logger log = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	ScheduleService scheduleService;
	
	@Autowired
	ReservationService reservationService;
	@Autowired
	ReservationDAO reservationDao;
	@Autowired
	ReserveDAO reserveDAO;
	@Autowired
	MemberDAO memberDAO;
	@Autowired
	DataDAO dataDAO;

	@Autowired
	MovieDAO movieDao;

	@Autowired
	private AuthService authService;

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	@GetMapping("reservePage01")
	public String getReserveMoviePage(Model model) throws Exception {
		
		log.info("reserveList");
		//List<MovieVO> movieList = movieService.reserveSelectMovie();
		//List<CinemaVO2> cinemaList = cinemaService.reserveSelectCinema();
		List<ScheduleVO> scheduleList = scheduleService.reserveSelectDay(); // 날짜 리스트
		List<ScheduleVO> schedule_dateList = scheduleService.selectSchedule_date();//스케줄 날짜 리스트
		//////////////////////////////////////////////////////////////////
		// List<ScheduleVO> timeList = scheduleService.reserveSelectTime(thisDay);
		//model.addAttribute("movieList", movieList);
		//model.addAttribute("cinemaList", cinemaList);
		model.addAttribute("scheduleList", scheduleList);
		model.addAttribute("schedule_dateList", schedule_dateList);

		model.addAttribute("center", "reservation/reservePage01");
		return "home";
	}

	@PostMapping("reservePage01")
	public String postReserveMoviePage(Model model, HttpServletRequest request) throws Exception {
		log.info("reserveTime");
		String movie_code = request.getParameter("movie");
		String cinema_code = request.getParameter("cinema");
		String day = request.getParameter("day");

		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date reserveDay = fm.parse(day);

		//List<MovieVO> movieList = movieService.reserveSelectMovie();
		//List<CinemaVO2> cinemaList = cinemaService.reserveSelectCinema();
		List<ScheduleVO> scheduleList = scheduleService.reserveSelectDay(); // 스케줄 리스트 전부
		List<ScheduleVO> schedule_dateList = scheduleService.selectSchedule_date();//스케줄 날짜 리스트

		//model.addAttribute("movieList", movieList);
		//model.addAttribute("cinemaList", cinemaList);
		model.addAttribute("scheduleList", scheduleList);
		model.addAttribute("schedule_dateList", schedule_dateList);

		System.out.println("영화정보 : " + movie_code + ", " + cinema_code + ", " + reserveDay);

		List<ScheduleVO> timeList = scheduleService.reserveSelectTime(movie_code, cinema_code, day);

		/* 영화정보 */
		//MovieVO movieInfo = movieService.selectMovieInfo(movie_code);// 선택된movie
		//CinemaVO2 cinemaInfo = cinemaService.selectCinemaInfo(cinema_code);// 선택된cinema

		// reserveInfoVO에 넣기
		ReservationInfoVO reserveInfo = new ReservationInfoVO();
		//reserveInfo.setMovie_code(movieInfo.getMovie_code());
		//reserveInfo.setMovie_sub(movieInfo.getMovie_sub());
		//reserveInfo.setCinema_code(cinemaInfo.getCinema_code());
		//reserveInfo.setCinema_name(cinemaInfo.getCinema_name());
		reserveInfo.setDay(reserveDay);

		System.out.println("Page01 : reserveDay : " + reserveInfo.getDay());
//		reserveInfo.setCinema_room();
//		reserveInfo.setStart_time();
//		reserveInfo.setEnd_time();
//		reserveInfo.setTotalSeat();
//		reserveInfo.setExtraSeat();
//		reserveInfo.setId();
//		reserveInfo.setBirth();

//		List<MovieVO2> movie_list = movieService.selectMovieSub(movie_code);

		// 선택된 영화 정보//
		// model.addAttribute("movie_code", movie_code);
		model.addAttribute("reserveInfo", reserveInfo);
		////////////////
		// 시간 목록//
		model.addAttribute("timeList", timeList);
		////////////////
		model.addAttribute("center", "reservation/reservePage01");
		return "home";
	}

	/////////////////////////////////////////////////////////////
//	@GetMapping("reservePage02")
//	public String getReserveSeat(ReservationInfoVO reserveInfo, Model model, HttpServletRequest request)
//			throws Exception {
//		log.info("reserveSeat");
//
//		String schedule_code = request.getParameter("strTime");
//		String strDay = request.getParameter("strDay");
//
//		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
//		Date reserveDay = fm.parse(strDay);
//
//		// schedule정보 //
//		ScheduleVO2 scheduleInfo = scheduleService.reserveSelectSchedule(schedule_code);
//
//		System.out.println("cinema_room : " + scheduleInfo.getCinema_room());
//		System.out.println("Page02 : reserveDay : " + strDay);
//
//		reserveInfo.setDay(reserveDay);
//		reserveInfo.setCinema_room(scheduleInfo.getCinema_room());
//		reserveInfo.setStart_time(scheduleInfo.getStart_time());
//		reserveInfo.setEnd_time(scheduleInfo.getEnd_time());
//		reserveInfo.setExtraSeat(scheduleInfo.getSeat_qnt());
//		reserveInfo.setSchedule_code(scheduleInfo.getSchedule_code());
//
//		String cinema_code = Integer.toString(reserveInfo.getCinema_code());
//
//		System.out.println("cinema_room검색 : " + cinema_code + reserveInfo.getCinema_name());
//		// cinemaRoom으로 전체좌석수
//		CinemaRoomVO2 cinemaRoomInfo = cinemaRoomService.selectCinemaRoomInfo(cinema_code,
//				reserveInfo.getCinema_room());
//
//		System.out.println("cinema_room전체좌석 : " + cinemaRoomInfo.getCinema_seat());
//
//		reserveInfo.setTotalSeat(cinemaRoomInfo.getCinema_seat());
////		reserveInfo.setId();
////		reserveInfo.setBirth();
//
//		model.addAttribute("reserveInfo", reserveInfo);
//		model.addAttribute("center", "reservation/reservePage02");
//		return "home";
//	}

	@PostMapping("reservePage02")
	public String postReserveSeat(ReservationInfoVO reserveInfo, Model model, HttpServletRequest request)
			throws Exception {
		log.info("reserveSeat");

		String strDay = request.getParameter("strDay");
		String strStart_time = request.getParameter("strStart_time");
		String strEnd_time = request.getParameter("strEnd_time");

		String seatArr[] = request.getParameterValues("seat");

		int seat;
		
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date day = fm.parse(strDay);

		// String ->LocalTime
		LocalTime start_time = LocalTime.parse(strStart_time);
		LocalTime end_time = LocalTime.parse(strEnd_time);

		reserveInfo.setDay(day);
		reserveInfo.setStart_time(start_time);
		reserveInfo.setEnd_time(end_time);
		
		System.out.println("좌석 : ");
		for (int i = 0; i < seatArr.length; i++) {
			System.out.println(seatArr[i]);
			
			seat = Integer.parseInt(seatArr[i]);
			reserveInfo.setSeat_num(seat);;
			
			System.out.println("예약정보 : " + reserveInfo.getId() + "/"
					 + reserveInfo.getCinema_code() + "/"
					 + reserveInfo.getCinema_room() + "/"
					 + reserveInfo.getMovie_code() + "/"
					 + reserveInfo.getSchedule_code() + "/"
					 + reserveInfo.getSeat_num() + "/"
					 );
			
			reservationService.insert(reserveInfo); //예약
			//좌석수 update
			reservationService.updateSeat_num(reserveInfo.getSchedule_code());
		}

		model.addAttribute("reserveInfo", reserveInfo);
		model.addAttribute("center", "reservation/reserveCompletePage");
		return "home";
	}

	/* admin - 예매 관리 */
	@GetMapping("reserveList")
	public String getReserveList(Model model, HttpServletRequest request) throws Exception {

		List<DataVO> data = dataDAO.selectAll();
		model.addAttribute("data", data);
		model.addAttribute("a_center", "reservation/reserveList");
		return "a_home";
	}
	
	/* 나의 예매 내역 확인 */
	@GetMapping("myReserveList")
	public String memreserveList(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		
		List<DataVO> reserveList = dataDAO.selectIdReserve(authInfo.getId());
		model.addAttribute("reserveList", reserveList);
		model.addAttribute("center", "reservation/myReserveList");
		return "home";
	}
}
