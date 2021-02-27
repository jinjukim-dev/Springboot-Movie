package org.study.cinema;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService{
	@Autowired
	private CinemaDAO2 cinemaDAO;

	@Override
	public List<CinemaVO2> reserveSelectCinema() throws Exception {
		return cinemaDAO.reserveSelectCinema();
	}

	@Override
	public CinemaVO2 selectCinemaInfo(String cinema_code) throws Exception {
		// TODO Auto-generated method stub
		return cinemaDAO.selectCinemaInfo(cinema_code);
	}
}
