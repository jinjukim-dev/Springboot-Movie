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
	
	/* 지점등록 */
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
	
	/* 상영관 등록화면으로 가기 */
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
	
	/* 상영관 등록 */
	@PostMapping("cinemaRoomRegist")
	public String cinemaRoomRegist(CinemaRoomVO cinemaRoomVO, Model model,HttpServletRequest request) throws Exception {
		/* log.info("memberVo:"+memberVO.getEmail()); */
		String code=request.getParameter("cinema_code");
		int cinema_code=Integer.parseInt(code);
		
		cinemaRoomDAO.insertRoom(cinemaRoomVO);	
		return "redirect:http://localhost:8080/springteam04/cinema/cinemaList";
	}
	
	/* 상영관 삭제 */
	@PostMapping("cinemaInfoRoomDelete")
	public String cinemaInfoRoomDelete(CinemaRoomVO cinemaRoomVO, Model model, HttpServletRequest request) throws Exception {
		int cinemaroom_code = Integer.parseInt(request.getParameter("cinemaroom_code"));
		CinemaRoomVO cinemaRoom = new CinemaRoomVO();
		cinemaRoomDAO.deleCode(cinemaroom_code);
		model.addAttribute("cinemaRoom", cinemaRoom);
		return "redirect:cinemaList";
	}
	
	/* 지점에 상영관 리스트보기 */
	@PostMapping("cinemaInfoList")
	public String cinemaInfoList(Model model,HttpServletRequest request) throws Exception {
		String code=request.getParameter("cinema_code");
		int cinema_code=Integer.parseInt(code);
		
		List<CinemaRoomVO> roomList = cinemaRoomDAO.selectCode(cinema_code);
		model.addAttribute("roomList", roomList);
		model.addAttribute("a_center", "cinema/cinemaInfoList");
		return "a_home";
	}
	
	/*지점 삭제   구현해야함*/
	@PostMapping("cinemaInfoDelete")
	public String cinemaInfoDelete(CinemaRoomVO cinemaRoomVO, Model model, HttpServletRequest request) throws Exception {
		String code=request.getParameter("code");
		int cinema_code=Integer.parseInt(code);
	
		CinemaVO cinemaVO = new CinemaVO();
	    cinemaDAO.delete(cinema_code);
	    model.addAttribute("cinemaVO", cinemaVO);
	    
	    List<CinemaVO> cinemaList = cinemaDAO.selectAll();
		model.addAttribute("cinemaList", cinemaList);
	
		return "movie/cinemaList";
	}

}
