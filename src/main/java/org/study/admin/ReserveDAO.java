package org.study.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.study.reservation.ReservationInfoVO;

@Repository
public class ReserveDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<ReserveVO> selectAll() throws Exception{
		List<ReserveVO> results = sqlSession.selectList("org.study.reservation.selectAllReserve");
		return results;
	}
	
	public List<ReservationInfoVO> selectScheduleAll() throws Exception{
		List<ReservationInfoVO> results = sqlSession.selectList("org.study.reservation.selectScheduleAll");
		return results;
	}
	
	public void insert(ReserveVO reserve) throws Exception {
		sqlSession.insert("org.study.reservation.insert", reserve);
	}
	
	//좌석수 update
	public void updateSeat_num(int schedule_code) throws Exception{
		sqlSession.update("org.study.reservation.updateSeat_num", schedule_code);
	}
	
	public List<Object> selectCount()  throws Exception{
		List<Object> result = (List<Object>)sqlSession.selectList("org.study.reservation.selectCount");
		return result;
	}

	// 중복체크
	public List<ReserveVO> selectDup(String seat, String schedule_code) throws Exception {
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("seat", seat);
		mapParam.put("schedule_code", schedule_code);
		System.out.println("dao : "+ seat + "/" + schedule_code);
		List<ReserveVO> results = sqlSession.selectList("org.study.reservation.selectDup", mapParam);

		return results;
	}
	
}
