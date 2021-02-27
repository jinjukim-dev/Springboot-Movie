package org.study.cinemaRoom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.reservation.ReservationInfoVO;

@Service
public class CinemaRoomServiceImpl implements CinemaRoomService{

	@Autowired
	private CinemaRoomDAO2 cinemaRoomDAO;

	@Override
	public CinemaRoomVO2 selectCinemaRoomInfo(String cinema_code, String cinema_room) throws Exception {
		// TODO Auto-generated method stub
		return cinemaRoomDAO.selectCinemaRoomInfo(cinema_code, cinema_room);
	}

}
