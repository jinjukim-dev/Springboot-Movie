package org.study.adim.controller;

import java.util.List;

import javax.activation.CommandInfo;
import javax.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.study.admin.CinemaDAO;
import org.study.admin.CinemaRoomDAO;
import org.study.admin.CinemaRoomVO;
import org.study.admin.CinemaVO;
import org.study.admin.MovieDAO;
import org.study.admin.MovieScheduleDAO;
import org.study.admin.MovieScheduleVO;
import org.study.admin.MovieVO;
import org.study.admin.ScheduleDAO;
import org.study.admin.ScheduleVO;
import org.study.member.MemberVO;


@Controller
@RequestMapping("movie")
public class movieController {

	Logger log = LoggerFactory.getLogger(movieController.class);
	
	@Autowired
	MovieDAO movieDAO;
	
	@Autowired
	ScheduleDAO scheduleDAO;
	
	@Autowired
	CinemaDAO cinemaDAO;
	
	@Autowired
	CinemaRoomDAO cinemaRoomDAO; 
	
	@Autowired
	MovieScheduleDAO movieScheduleDAO;
	
	/* top 메뉴부분 영화 */
	@GetMapping("movieInfo")
	public String movieInfo(Model model, HttpServletRequest request) throws Exception {
		
		// 모든 영화 정보 list에 담기
		List<MovieVO> movieList = movieDAO.selectAll();
		
		model.addAttribute("movieList", movieList);		
		model.addAttribute("center", "movie/movieInfo");
		return "home";
	}

	/* admin - 영화 등록 */
	@GetMapping("movieRegist")
	public String movieReg(Model model) {
		model.addAttribute("movieVO", new MovieVO());
		model.addAttribute("a_center", "movie/movieRegist");
		return "a_home";
	}
	
	/* admin - 영화 리스트 */
	@GetMapping("movieList")
	public String movieList(Model model) throws Exception {
		List<MovieVO> movieList = movieDAO.selectAll();
		model.addAttribute("movieList", movieList);
		model.addAttribute("a_center", "movie/movieList");
		return "a_home";
	}
	
	
	/* admin - 해당 영화스케줄 목록 */
	@PostMapping("scheduleList")
	public String scheduleList(MovieVO movieVO, Model model,HttpServletRequest request) throws Exception {
		int movie_code = movieVO.getMovie_code();	
		MovieVO movie = movieDAO.selectMovieInfo(movie_code);
		model.addAttribute("movie_sub", movie.getMovie_sub()); //영화제목 보내기
		
		List<ScheduleVO>  scheduleList = movieScheduleDAO.selectMovieSchedule(movie_code);
		model.addAttribute("scheduleList", scheduleList);
	
		model.addAttribute("a_center", "movie/scheduleList");
		return "a_home";
	}
	
	/* admin - 영화 스케줄 등록화면으로 가기 */
	@PostMapping("scheduleRegist")
	public String scheduleRegist(MovieVO movieVO, Model model, HttpServletRequest request) throws Exception {
		int movie_code = movieVO.getMovie_code();
		
		MovieVO movie = movieDAO.selectMovieInfo(movie_code);
		model.addAttribute("movie_sub", movie.getMovie_sub()); //영화제목 보내기
		
		List<CinemaVO> cinemaList = cinemaDAO.selectAll(); // 지점 정보 보내기
		model.addAttribute("cinemaList", cinemaList);
		
		model.addAttribute("movie_code", movie_code); // 영화코드 보내기
		
		model.addAttribute("MovieScheduleVO", new MovieScheduleVO()); // 빈객체
		model.addAttribute("a_center", "movie/movieScheduleRegist");
		return "a_home";
	}
	
	/* admin - 영화 스케줄 등록 */
	@PostMapping("MoviescheduleRegist")
	public String moviescheduleRegist(MovieScheduleVO movieScheduleVO, Model model) throws Exception {
		
		System.out.println("영화 스케줄 등록 부분");
		
		// cinema_code
		String c_code = movieScheduleVO.getCinema_name();
		int cinema_code = Integer.parseInt(c_code);
		// start_time
		LocalTime start_time = movieScheduleVO.getStart_time();
		// end_time
		LocalTime end_time = movieScheduleVO.getEnd_time();
		// schedule_date
		LocalDate schedule_date = movieScheduleVO.getSchedule_date();
		// movie_code
		int movie_code = movieScheduleVO.getMovie_code();
		// cinemaroom_code
		String r_code = movieScheduleVO.getCinema_room();
		int cinemaroom_code = Integer.parseInt(r_code.trim());
		System.out.println("cinemaroom_code : "+cinemaroom_code);
		
		ScheduleVO scheduleVO = new ScheduleVO(); // 새 객체
		// movieSheduleVO로 받아온 데이터 sheduleVO에 담기
		scheduleVO.setCinema_code(cinema_code);
		scheduleVO.setStart_time(start_time);
		scheduleVO.setEnd_time(end_time);
		scheduleVO.setSchedule_date(schedule_date);
		scheduleVO.setMovie_code(movie_code);
		scheduleVO.setCinemaroom_code(cinemaroom_code);
			
		// 스케줄 데이터 insert
		scheduleDAO.insert(scheduleVO);
		
//		model.addAttribute("a_center", "movie/scheduleList");
//		return "a_home";
		return "redirect:movieList";
	}
	
	/* admin - 스케줄 삭제 */
	@PostMapping("deleteSchedule")
	public String cinemaRoomDelete(ScheduleVO scheduleVO, Model model, HttpServletRequest request) throws Exception {
		int schedule_code = scheduleVO.getSchedule_code();
		System.out.println("deleteSchedule.schedule_code : "+schedule_code);
		
		ScheduleVO schedule = new ScheduleVO();
		scheduleDAO.delete(schedule_code);
		model.addAttribute("shedule", schedule);
		return "redirect:movieList";
	}
	
	/* admin - 영화삭제 */
	@PostMapping("deleteMovie")
	public String cinemaInfoDelete(Model model, HttpServletRequest request) throws Exception {
		String code=request.getParameter("movie_code");
		int movie_code=Integer.parseInt(code);
		
		MovieVO movieVO = new MovieVO();
		movieDAO.delete(movie_code);
	    model.addAttribute("movieVO", movieVO);	
		return "redirect:movieList";
	}

}
