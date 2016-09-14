package com.holodniysvitanok.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.holodniysvitanok.dao.RecordDAO;
import com.holodniysvitanok.entity.Record;


@Repository
public class RecordDAOImpl implements RecordDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Record> getAllRecord(int count) {
		Session session = sessionFactory.getCurrentSession();
		List<Record> list = session.createCriteria(Record.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setMaxResults(count).list();
		return list;
	}

	@Override
	@Transactional
	public Record getRecord(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Record record = (Record) currentSession.get(Record.class, id);
		return record;
	}

	@Override
	@Transactional
	public void saveRecord(Record record) {
		Session session  = sessionFactory.getCurrentSession();
		session.save(record);
	}

	@Override
	@Transactional
	public void deleteRecord(Record record) {
		Session session  = sessionFactory.getCurrentSession();
		session.remove(record);
		
	}
	

	
	


}
