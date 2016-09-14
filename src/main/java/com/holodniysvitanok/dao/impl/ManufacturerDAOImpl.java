package com.holodniysvitanok.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.holodniysvitanok.dao.ManufacturerDAO;
import com.holodniysvitanok.entity.Manufacturer;


@Repository
public class ManufacturerDAOImpl implements ManufacturerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Manufacturer> getAllManufacturer(int count) {
		Session session = sessionFactory.getCurrentSession();
		List<Manufacturer> list = session.createCriteria(Manufacturer.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setMaxResults(count).list();
		return list;
	}

	@Override
	@Transactional
	public Manufacturer getManufacturer(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Manufacturer manufacturer = (Manufacturer) currentSession.get(Manufacturer.class, id);
		return manufacturer;
	}

	@Override
	@Transactional
	public void saveOrUpdateManufacturer(Manufacturer manufacturer) {
		Session session  = sessionFactory.getCurrentSession();
		session.saveOrUpdate(manufacturer);
		
	}

	@Override
	@Transactional
	public void deleteManufacturer(Manufacturer manufacturer) {
		Session session  = sessionFactory.getCurrentSession();
		session.remove(manufacturer);
		
	}

	@Override
	@Transactional
	public long getCountDuplicateFiles(String fileName) {
		Session session  = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(*) from Manufacturer where urlImage = :fileName ");
		query.setParameter("fileName", fileName);
		return ((Long)query.uniqueResult()).intValue();
	}


}
