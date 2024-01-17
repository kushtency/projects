package dev.spring.springdata.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.spring.springdata.hibernate.dao.TourDAO;
import dev.spring.springdata.hibernate.model.Tour;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TourServiceImpl implements TourService{
	
	private final TourDAO tourDao;
	
	@Autowired
	public TourServiceImpl(TourDAO tourDao) {
		this.tourDao = tourDao;
	}

	@Override
	public List<Tour> getAll() {
		return tourDao.getAll();
	}

	@Override
	public Tour getTourByID(int ID) {
		return tourDao.getTourByID(ID);
	}

	@Override
	public void saveTour(Tour tour) {
		tourDao.saveTour(tour);
	}

	@Override
	public void deleteTour(int ID) {
		tourDao.deleteTour(ID);
	}

	@Override
	public void updateTour(Tour tour) {
		tourDao.updateTour(tour);
	}

}
