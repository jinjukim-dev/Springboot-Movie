package org.study.adim.controller;

import java.util.List;


import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.study.admin.CinemaDAO;
import org.study.admin.CinemaRoomDAO;
import org.study.admin.CinemaRoomVO;
import org.study.admin.CinemaVO;

@Controller
@RequestMapping("cinema")
public class cinemaController {
	
	Logger log = LoggerFactory.getLogger(cinemaController.class);
	
	@Autowired
	CinemaDAO cinemaDAO;
	@Autowired
	CinemaRoomDAO cinemaRoomDAO;
	
	/* admin - 지점등록, 상영관 등록 */
	
	/* 지점등록 메뉴*/
	@GetMapping("cinemaRegist")
	public String cinemaRegist(Model model) {
		model.addAttribute("cinemaVO", new CinemaVO());
		model.addAttribute("a_center", "cinema/cinemaRegist");
		return "a_home";
	}
	
	@PostMapping("cinemaRegist")
	public String movieRegDone(CinemaVO cinemaVO, Model model) throws Exception {
		cinemaDAO.insert(cinemaVO);
		
		return "redirect:http://localhost:8080/springteam04/cinema/cinemaList";
	}
	/////////////////////////
	/* 상영관 등록 메뉴*/
	/* 지점 리스트 보여주기 */
	@GetMapping("cinemaList")
	public String cinemaList(Model model) throws Exception {
		List<CinemaVO> cinemaList = cinemaDAO.selectAll();
		model.addAttribute("cinemaList", cinemaList);
		model.addAttribute("a_center", "cinema/cinemaList");	
		return "a_home";
	}
	
	/* 상영관 등록 */
	@PostMapping("cinemaInfoRegist")
	public String cinemaInfoRegist(CinemaRoomVO cinemaRoomVO, Model model, HttpServletRequest request) throws Exception {
		String code=request.getParameter("cinema_code");
		int cinema_code=Integer.parseInt(code);
		log.info("cinema_code : "+cinema_code);
		
		CinemaVO list =cinemaDAO.selectByCode(cinema_code);
	    model.addAttribute("cinemaVO", list);
	    model.addAttribute("a_center", "cinema/cinemaInfoRegist");
		return "a_home";
	}
	
	@PostMapping("cinemaRoomRegist")
	public String cinemaRoomRegist(CinemaRoomVO cinemaRoomVO, Model model,HttpServletRequest request) throws Exception {
		/* log.info("memberVo:"+memberVO.getEmail()); */
		String code=request.getParameter("cinema_code");
		int cinema_code=Integer.parseInt(code);
		cinemaRoomVO.setCinema_code(cinema_code);
		System.out.println("cinema_code"+cinema_code);
		
		
		cinemaRoomDAO.insertRoom(cinemaRoomVO);
		model.addAttribute("cinemaRoomVO", cinemaRoomVO);
		
		List<CinemaVO> cinemaList = cinemaDAO.selectAll();
		model.addAttribute("cinemaList", cinemaList);
	
		return "movie/cinemaList";
	}
	
	/* 상영관 삭제*/
	@PostMapping("cinemaInfoDelete")
	public String cinemaInfoDelete(CinemaRoomVO cinemaRoomVO, Model model, HttpServletRequest request) throws Exception {
		String code=request.getParameter("code");
		int cinema_code=Integer.parseInt(code);
		/* log.info("memberVo:"+memberVO.getEmail()); */
		CinemaVO cinemaVO = new CinemaVO();
	    cinemaDAO.delete(cinema_code);
	    model.addAttribute("cinemaVO", cinemaVO);
	    
	    List<CinemaVO> cinemaList = cinemaDAO.selectAll();
		model.addAttribute("cinemaList", cinemaList);
	
		return "movie/cinemaList";
	}
	
	/* 지점에 상영관 리스트보기 */
	@PostMapping("cinemaInfoList")
	public String cinemaInfoList(Model model,HttpServletRequest request) throws Exception {
		String code=request.getParameter("cinema_code");
		int cinema_code=Integer.parseInt(code);
		
//		List<CinemaRoomVO>  cinemaList = cinemaRoomDAO.selectCode(cinema_code);
//		model.addAttribute("cinemaList", cinemaList);
		model.addAttribute("a_center", "cinema/cinemaInfoList");
		return "a_home";
	}
	
	/* 지점 삭제 */
	
	////////////////////////////////////////////////////
	
	
	@PostMapping("cinemaInfoRoomDelete")
	public String cinemaInfoRoomDelete(CinemaRoomVO cinemaRoomVO, Model model, HttpServletRequest request) throws Exception {
		String cinema_room=request.getParameter("cinema_room");
		String cinema_code=request.getParameter("cinema_code");
		/* log.info("memberVo:"+memberVO.getEmail()); */
		CinemaRoomVO cinemaVO = new CinemaRoomVO();
	    cinemaRoomDAO.delete(cinema_code,cinema_room);
	    model.addAttribute("cinemaVO", cinemaVO);
	    
	    
		int cinema_code2=Integer.parseInt(cinema_code);
		List<CinemaRoomVO>  cinemaList = cinemaRoomDAO.selectCode(cinema_code2);
		model.addAttribute("cinemaList", cinemaList);
	
		return "movie/cinemaInfoList";
	}
}
