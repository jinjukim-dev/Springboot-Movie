package org.study.movie;

import java.util.List;

import org.study.admin.MovieVO;

public interface MovieService {
	
	public List<MovieVO> reserveSelectMovie() throws Exception;
	
	public MovieVO selectMovieInfo(String movie_code) throws Exception;
	
	public List<MovieVO> selectAll() throws Exception;
	
}
