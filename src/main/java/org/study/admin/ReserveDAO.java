package org.study.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.study.reservation.ReservationVO;

@Repository
public class ReserveDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<ReserveVO> selectAll() throws Exception{
		List<ReserveVO> results = sqlSession.selectList("org.study.reservation.selectAllReserve");
		return results;
	}
	
}
