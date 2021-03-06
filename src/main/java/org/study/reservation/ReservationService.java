package org.study.reservation;

import java.util.List;

import org.study.admin.ReserveVO;

public interface ReservationService {
	
	//예약
	public void insert(ReserveVO reserveInfo) throws Exception;
	
	//좌석수 update
	public void updateSeat_num(int schedule_code) throws Exception;
	
	//예약 정보
	public List<ReserveVO> selectAll() throws Exception;
	
	//예매 page-1 정보 
	public List<ReservationInfoVO> selectScheduleAll() throws Exception;
	
	//예약된 영화 count
	public List<Object> selectCount() throws Exception;

	//자리 중복체크 
	public List<ReserveVO> selectDup(String seat, String schedule_code) throws Exception;

}