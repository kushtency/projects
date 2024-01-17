package dev.spring.springdata.hibernate.service;

import java.util.List;

import dev.spring.springdata.hibernate.model.Tour;

public interface TourService {
	List<Tour> getAll();
	Tour getTourByID(int ID);
	void saveTour(Tour tour);
	void deleteTour(int ID);
	void updateTour(Tour tour);
}
