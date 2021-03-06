package org.study.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.admin.ReserveDAO;
import org.study.admin.ReserveVO;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReserveDAO reserveDAO;

	@Override
	public void insert(ReserveVO reserve) throws Exception {
		reserveDAO.insert(reserve);

	}
	
	// 예약된 영화 count
	@Override
	public List<Object> selectCount() throws Exception {
		return reserveDAO.selectCount();
	}

	//중복
	@Override
	public List<ReserveVO> selectDup(String seat, String schedule_code) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(seat + "/" + schedule_code);
		return reserveDAO.selectDup(seat, schedule_code);
	}

	@Override
	public void updateSeat_num(int schedule_code) throws Exception {
		// TODO Auto-generated method stub
		reserveDAO.updateSeat_num(schedule_code);
	}

	@Override
	public List<ReserveVO> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* 예매 page-1 정보 */
	@Override
	public List<ReservationInfoVO> selectScheduleAll() throws Exception {
		return reserveDAO.selectScheduleAll();
	}

}