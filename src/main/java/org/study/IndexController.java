package org.study;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.study.admin.MovieDAO;
import org.study.admin.MovieVO;
import org.study.reservation.ReservationService;
import org.study.reservation.controller.ReservationController;

@Controller
public class IndexController {
	
	Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private MovieDAO movieDAO;
	
	@Autowired
	private ReservationService reservationService;

	@GetMapping("/")
	public String index(Model model, HttpServletRequest request) throws Exception {
		
		/* movie Rank 부분 */
		List<Object> countList = reservationService.selectCount(); // 영화코드, 예약된 영화 count 값 	
		List<MovieVO> movieList = movieDAO.selectAll(); // 모든 영화 정보 가져오기
		
		for(int i=0; i<countList.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) countList.get(i);
			
			log.info("예매 수 "+(i+1)+"위 영화 : "+map.get("movie_code")+", 예매수 : "+map.get("cnt"));
		}
		
		model.addAttribute("movieList", movieList);
		model.addAttribute("countList", countList);	
		model.addAttribute("center", "center");
		
		return "home";
	}
	
	@GetMapping("/admin")
	public String index2(Model model) {
		model.addAttribute("a_center", "a_center");
		return "a_home";
	}
}
