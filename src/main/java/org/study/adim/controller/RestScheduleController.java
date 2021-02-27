package org.study.adim.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	ScheduleDAO scheduleDAO;
	@Autowired
	CinemaRoomDAO cinemaroomDAO;

	@PostMapping("getRoomInfo")
	public List<CinemaRoomVO> getRoom(@RequestParam("cinema_code") int cinema_code) throws Exception {
		log.info("code:"+cinema_code);
		//cinema_code = Integer.parseInt(cinema_code);
		List<CinemaRoomVO> cinemaRoom = scheduleDAO.selectRoom(cinema_code);
		return cinemaRoom;
	}
	
	

}
