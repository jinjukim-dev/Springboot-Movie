package org.study.reservation.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.study.reservation.ReservationService;

@RestController
public class RestSeatController {
	Logger log = LoggerFactory.getLogger(RestSeatController.class);
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("reservePage02")
	public Map<String, String> seatDup(
			@RequestParam("seatArr") String seatArr, 
			@RequestParam("schedule_code") String schedule_code
			){
		
		Map<String , String> map = new HashMap<String, String>();
		
		log.info("RestSeatController중복확인"+seatArr + "/" + schedule_code);
		
		try {
			
			if(reservationService.selectDup(seatArr, schedule_code) == null) {
				System.out.println("null");
			}
			
				if(!reservationService.selectDup(seatArr, schedule_code).isEmpty()) {
					//값이 있으면 중복
					System.out.println("중복!!");
					map.put("code", "dup");
				}else {
					map.put("code", "noDup");
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
	}
}
