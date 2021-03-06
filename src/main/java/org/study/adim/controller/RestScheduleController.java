package org.study.adim.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.study.admin.CinemaRoomDAO;
import org.study.admin.CinemaRoomVO;
import org.study.admin.ScheduleDAO;

@RestController
public class RestScheduleController {

	Logger log = LoggerFactory.getLogger(RestScheduleController.class);
	
	@Autowired
	CinemaRoomDAO cinemaroomDAO;
	
	/* admin - 스케줄 등록 시 지점에 따라 상영관 정보 받아오기 */
	@PostMapping("getRoomInfo/{cinema_code}")
	public Map getRoom(@PathVariable("cinema_code") int cinema_code) throws Exception {
		List<CinemaRoomVO> cinemaRoom = cinemaroomDAO.selectCode(cinema_code);
		System.out.println("getRoomInfo() cinema_code :"+cinema_code);
		
		List<Integer> optionList = new ArrayList();
		for(int i=0; i<cinemaRoom.size(); i++) {
			optionList.add(cinemaRoom.get(i).getCinemaroom_code());
		}
		
		Map<Integer , String> map = new HashMap<>();
		for(int i=0; i<cinemaRoom.size(); i++) {
			map.put(cinemaRoom.get(i).getCinemaroom_code(), cinemaRoom.get(i).getCinema_room());
		}
		
		System.out.println("---- Map 출력 ------");
		for(Integer key : map.keySet()) {
			String value = (String) map.get(key);
			System.out.println(key + " : " + value);
		}
		
		return map;
	}
	
}