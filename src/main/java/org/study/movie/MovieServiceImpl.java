package org.study.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.admin.MovieDAO;
import org.study.admin.MovieVO;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieDAO movieDAO;
	
	@Override
	public List<MovieVO> reserveSelectMovie() throws Exception {
		return movieDAO.reserveSelectMovie();
	}

	@Override
	public MovieVO selectMovieInfo(String movie_code) throws Exception {
		return movieDAO.selectMovieInfo(movie_code);
	}

	@Override
	public List<MovieVO> selectAll() throws Exception {
		return movieDAO.selectAll();
	}
}
