package org.study.reservation;

import java.util.List;

public interface ReservationService {
	
	//예약
	public void insert(ReservationInfoVO reserveInfo) throws Exception;
	
	//좌석수 update
	public void updateSeat_num(int schedule_code) throws Exception;
	
	//예약 정보
	public List<ReservationVO> selectAll() throws Exception;
	
	/*
	 * //예약된 영화 count public List<Object> selectCount() throws Exception;
	 */
	
	//예약된 영화 count
	public List<Object> selectCount() throws Exception;

	//자리 중복체크 
	public List<ReservationVO> selectDup(String seat, String schedule_code) throws Exception;

}