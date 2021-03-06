package org.study.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<DataVO> selectAll() throws Exception{
		List<DataVO> results = sqlSession.selectList("org.study.schedule.selectData");
		return results;
	}
	
	public List<DataVO> selectIdReserve(String id) throws Exception{
		List<DataVO> results = sqlSession.selectList("org.study.reservation.selectIdReserve", id);
		return results;
	}
	
}
