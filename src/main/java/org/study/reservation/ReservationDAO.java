package org.study.reservation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDAO {

	@Autowired
	private SqlSession sqlSession;

	public void insert(ReservationInfoVO reserveInfo) throws Exception {
		sqlSession.insert("org.study.reservation.insert", reserveInfo);
	}
	
	//좌석수 update
	public void updateSeat_num(int schedule_code) throws Exception{
		sqlSession.update("org.study.reservation.updateSeat_num", schedule_code);
	}

	public List<ReservationVO> selectAll() throws Exception {
		List<ReservationVO> results = sqlSession.selectList("org.study.reservation.selectAll");
		return results;
	}

	/*
	 * public List<Object> selectCount() throws Exception { 
	 * List<Object> results = (List<Object>) sqlSession.selectList("org.study.reservation.selectCount");
	 * return results; }
	 */
	
	public List<Object> selectCount()  throws Exception{
		List<Object> result = (List<Object>)sqlSession.selectList("org.study.reservation.selectCount");
		return result;
	}

	// 중복체크
	public List<ReservationVO> selectDup(String seat, String schedule_code) throws Exception {
		Map<String, String> mapParam = new HashMap<String, String>();
		mapParam.put("seat", seat);
		mapParam.put("schedule_code", schedule_code);
		System.out.println("dao : "+ seat + "/" + schedule_code);
		List<ReservationVO> results = sqlSession.selectList("org.study.reservation.selectDup", mapParam);

		return results;
	}

}