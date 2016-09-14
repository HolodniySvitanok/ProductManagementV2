package com.holodniysvitanok.dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.holodniysvitanok.dao.UserDAO;
import com.holodniysvitanok.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public User getUserByLogin(String login) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> query = currentSession.createQuery("from User where login = :userLogin");
		query.setParameter("userLogin", login);
		return query.uniqueResult();
	}

	@Override
	@Transactional
	public boolean saveUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		try {
			currentSession.saveOrUpdate(user);
		} catch (Exception ex) {
			return false;
		}

		return true;
	}

	@Override
	@Transactional
	public User getUserById(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = (User) currentSession.get(User.class, id);
		return user;
	}

	
	
	@Override
	@Transactional
	public List<User> getAllUsers(int start, int maxRows) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = session.createQuery("from User");
		query.setFirstResult(start);
		query.setMaxResults(maxRows);
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<User> getAllUsers(int count) {
		Session session = sessionFactory.getCurrentSession();
		List<User> list = session.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setMaxResults(count).list();
		
		return list;
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
	}
}
