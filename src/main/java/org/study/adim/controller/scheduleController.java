package org.study.adim.controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.study.admin.CinemaDAO;
import org.study.admin.CinemaRoomDAO;
import org.study.admin.CinemaRoomVO;
import org.study.admin.CinemaVO;
import org.study.admin.MovieDAO;
import org.study.admin.MovieVO;
import org.study.admin.ScheduleDAO;
import org.study.admin.ScheduleVO;

@Controller
@RequestMapping("schedule")
public class scheduleController {
	Logger log = LoggerFactory.getLogger(scheduleController.class);
	@Autowired
	ScheduleDAO scheduleDAO;
	@Autowired
	CinemaDAO cinemaDAO;
	@Autowired
	MovieDAO movieDAO;

	@GetMapping("scheduleRegist")
	public String scheduleRegist(ScheduleVO scheuleVO, Model model, HttpServletRequest request) throws Exception {
		String code = request.getParameter("code");
		int movie_code = Integer.parseInt(code);
		MovieVO movieList = new MovieVO();
		movieList = scheduleDAO.selectByCode(movie_code);
		model.addAttribute("movieList", movieList);

		List<CinemaVO> cinemaList = cinemaDAO.selectAll();
		model.addAttribute("cinemaList", cinemaList);
		
		

		/*
		 * List<CinemaRoomVO> cinemaRoom = scheduleDAO.selectRoom();
		 * model.addAttribute("cinemaRoom", cinemaRoom);
		 */

		return "movie/movieScheduleRegist";
	}

	@PostMapping("scheduleRegist")
	public String scheduleRegist2(ScheduleVO scheuleVO, Errors errors, Model model,HttpServletRequest request) throws Exception {
		/* log.info("memberVo:"+memberVO.getEmail()); */
		
		new ScheduleRegisterValidator().validate(scheuleVO, errors);
		List<ObjectError> errorObjList=   errors.getAllErrors();
		log.info("errorObjList:"+errorObjList);
		log.info("errorObjList.size():"+errorObjList.size());
		if(errors.hasErrors()) {
			String code = request.getParameter("code");
			int movie_code = Integer.parseInt(code);
			MovieVO movieList = new MovieVO();
			movieList = scheduleDAO.selectByCode(movie_code);
			model.addAttribute("movieList", movieList);

			List<CinemaVO> cinemaList = cinemaDAO.selectAll();
			model.addAttribute("cinemaList", cinemaList);
			log.info("회원가입 에러 qnt :" + scheuleVO.getSeat_qnt());
			log.info("end_time:"+scheuleVO.getEnd_time()
			 + " start_time:" + scheuleVO.getStart_time());
			return "movie/movieScheduleRegist";
		}
		
		try {
			
		scheduleDAO.insert(scheuleVO);		
		List<MovieVO> movieList = movieDAO.selectAll();
		model.addAttribute("movieList", movieList);
	
	
		return "movie/movieList";
		
		
		}catch (Exception e) {
			log.info("exception ===================");
			// TODO: handle exception
			String code = request.getParameter("code");
			int movie_code = Integer.parseInt(code);
			MovieVO movieList = new MovieVO();
			movieList = scheduleDAO.selectByCode(movie_code);
			model.addAttribute("movieList", movieList);

			List<CinemaVO> cinemaList = cinemaDAO.selectAll();
			model.addAttribute("cinemaList", cinemaList);
			//return "redirect:./schedule/scheduleRegist?code="+movie_code;
			return "movie/movieScheduleRegist";
		}
		
	}
	
	@PostMapping("deleteSchedule")
	public String deleteSchedule( Model model, HttpServletRequest request) throws Exception {
		String code=request.getParameter("code");
		int schedule_code=Integer.parseInt(code);
		/* log.info("memberVo:"+memberVO.getEmail()); */
		ScheduleVO scheduleVO = new ScheduleVO();
		scheduleDAO.delete(schedule_code);
	    model.addAttribute("scheduleVO", scheduleVO);
	    
		List<MovieVO> movieList = movieDAO.selectAll();
		model.addAttribute("movieList", movieList);

		return "movie/movieList";
	}
}
