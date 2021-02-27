package org.study.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDAO reservationDao;

	@Override
	public void insert(ReservationInfoVO reserveInfo) throws Exception {
		reservationDao.insert(reserveInfo);

	}

	// 전체 예약 내역 가져오기
	@Override
	public List<ReservationVO> selectAll() throws Exception {

		return reservationDao.selectAll();
	}

	// 예약된 영화 count
	/*
	 * @Override public List<Object> selectCount() throws Exception { return
	 * reservationDao.selectCount(); }
	 */
	
	// 예약된 영화 count
	@Override
	public List<Object> selectCount() throws Exception {
		return reservationDao.selectCount();
	}

	//중복
	@Override
	public List<ReservationVO> selectDup(String seat, String schedule_code) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(seat + "/" + schedule_code);
		return reservationDao.selectDup(seat, schedule_code);
	}

	@Override
	public void updateSeat_num(int schedule_code) throws Exception {
		// TODO Auto-generated method stub
		reservationDao.updateSeat_num(schedule_code);
	}

}