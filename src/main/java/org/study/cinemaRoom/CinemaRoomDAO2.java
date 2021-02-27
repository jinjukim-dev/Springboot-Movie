package org.study.cinemaRoom;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.study.reservation.ReservationInfoVO;

@Repository
public class CinemaRoomDAO2 {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insertRoom(CinemaRoomVO2 cinema) throws Exception  {
		sqlSession.insert("org.study.cinema.insertRoom", cinema);
		
	}
	
	public CinemaRoomVO2 selectCinemaRoomInfo(String cinema_code, String cinema_room) throws Exception{
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("cinema_code", cinema_code);
		paramMap.put("cinema_room", cinema_room);
		
		CinemaRoomVO2  cinemaRoomInfo = sqlSession.selectOne("org.study.cinema.selectCinemaRoomInfo", paramMap);
		
		return cinemaRoomInfo;
	}


}
