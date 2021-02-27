package org.study.adim.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.study.admin.CinemaDAO;
import org.study.admin.CinemaRoomVO;
import org.study.admin.CinemaVO;
import org.study.admin.MovieDAO;
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

	/* 영화 등록 */
	@GetMapping("movieRegist")
	public String movieReg(Model model) {
		model.addAttribute("movieVO", new MovieVO());
		model.addAttribute("a_center", "movie/movieRegist");
		return "a_home";
	}

	@PostMapping("movieRegist")
	public String movieRegDone(MovieVO movieVO, Model model) throws Exception {
		movieDAO.insert(movieVO);
		return "redirect:http://localhost:8080/springteam04/movie/movieList";
	}
	
	/* 영화 리스트 */
	@GetMapping("movieList")
	public String movieList(Model model) throws Exception {
		List<MovieVO> movieList = movieDAO.selectAll();
		model.addAttribute("movieList", movieList);
		model.addAttribute("a_center", "movie/movieList");
		return "a_home";
	}
	
	@PostMapping("deleteMovie")
	public String cinemaInfoDelete( Model model, HttpServletRequest request) throws Exception {
		String code=request.getParameter("code");
		int movie_code=Integer.parseInt(code);
		/* log.info("memberVo:"+memberVO.getEmail()); */
		MovieVO movieVO = new MovieVO();
		movieDAO.delete(movie_code);
	    model.addAttribute("movieVO", movieVO);
	
		return "redirect:movieList";
	}
	
	@PostMapping("scheduleList")
	public String scheduleList(MovieVO movieVO, Model model,HttpServletRequest request) throws Exception {
		String code=request.getParameter("code");
		int movie_code=Integer.parseInt(code);
		log.info("movie_code:"+movie_code);
		List<ScheduleVO>  scheduleList = scheduleDAO.selectScedule(movie_code);
		
		model.addAttribute("scheduleList", scheduleList);
		return "movie/scheduleList";
	}
	
	/* top 메뉴부분 영화 */
	@GetMapping("movieInfo")
	public String movieInfo(Model model, HttpServletRequest request) throws Exception {
		
		// 모든 영화 정보 list에 담기
		List<MovieVO> movieList = movieDAO.selectAll();
		
		model.addAttribute("movieList", movieList);		
		model.addAttribute("center", "movie/movieInfo");
		return "home";
	}

}
