package dev.spring.springdata.hibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.spring.springdata.hibernate.model.Tour;

@Repository
public class TourDAOImpl implements TourDAO{
	
	private final SessionFactory sessionFactory;
	
	@Autowired
	public TourDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Tour> getAll() {
		return sessionFactory
				.getCurrentSession()
				.createQuery("from Tour t", Tour.class)
				.list();
	}

	@Override
	public Tour getTourByID(int ID) {
		return sessionFactory
				.getCurrentSession()
				.get(Tour.class, ID);
	}

	@Override
	public void saveTour(Tour tour){
		sessionFactory
		.getCurrentSession()
		.persist(tour);
	}

	@Override
	public void deleteTour(int ID) {
		Tour tour = getTourByID(ID);
		sessionFactory.getCurrentSession().remove(tour);
	}

	@Override
	public void updateTour(Tour tour) {
		sessionFactory.getCurrentSession().merge(tour);
	}

}
