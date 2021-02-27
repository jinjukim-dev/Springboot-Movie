package org.study.admin;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.study.member.MemberVO;

@Repository
public class MovieDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	//예매된 영화리스트 출력
		public List<MovieVO> reserveSelectMovie() throws Exception{
			List<MovieVO> listMovie = sqlSession.selectList("org.study.movie.reserveSelectMovie");
			return listMovie;
		}
		
		//무비 코드로 영화 정보 가져오기
		public MovieVO selectMovieInfo(String movie_code) {
			MovieVO movieInfo = sqlSession.selectOne("org.study.movie.selectMovieInfo", movie_code);
			return movieInfo;
		}

	public MemberVO selectByEmail(String email) throws Exception  {
		List<MemberVO> results = sqlSession.selectList("org.study.member.selectByEmail", email);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public MemberVO selectById(Long id) throws Exception  {
		MemberVO result = sqlSession.selectOne("org.study.member.selectById", id);
		return result;
	}

	public List<MemberVO> selectByRegdate(Map<String, LocalDateTime> dateData) throws Exception  {
		List<MemberVO> results = sqlSession.selectList("org.study.member.selectByRegdate", dateData);
		return results;
	}
	
	public List<MovieVO> selectAll()  throws Exception {
		List<MovieVO> results = sqlSession.selectList("org.study.movie.selectMovie"); 
		return results;
	}
	
	public void insert(MovieVO movie) throws Exception  {
		sqlSession.insert("org.study.movie.insert", movie);
		
	}
	
	public void delete(int movie_code) throws Exception  {
		sqlSession.delete("org.study.movie.deleteMovie", movie_code);
	
	}

//	public void update(MemberVO member) throws Exception  {
//		sqlSession.update("org.study.member.update", member);
//	}
//
//	public List<MemberVO> selectAll()  throws Exception {
//		List<MemberVO> results = sqlSession.selectList("org.study.member.selectAll"); 
//		return results;
//	}
//
//	public int count() throws Exception  {
//		Integer count = sqlSession.selectOne("org.study.member.count", Integer.class);
//		return count;
//	}

}
