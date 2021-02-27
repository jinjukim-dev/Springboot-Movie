package org.study.cinema;

import java.util.List;

public interface CinemaService {
	public List<CinemaVO2> reserveSelectCinema() throws Exception;
	public CinemaVO2 selectCinemaInfo(String cinema_code) throws Exception;
}
