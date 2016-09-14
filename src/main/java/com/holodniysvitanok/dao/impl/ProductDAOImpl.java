package com.holodniysvitanok.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.holodniysvitanok.dao.FileDublicate;
import com.holodniysvitanok.dao.ProductDAO;
import com.holodniysvitanok.entity.Product;


@Repository
public  class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Product> getAllProducts(int count) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> list = session.createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setMaxResults(count).list();
		return list;
	}

	@Override
	@Transactional
	public Product getProduct(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Product product = (Product) currentSession.get(Product.class, id);
		return product;
	}

	@Override
	@Transactional
	public void saveOrUpdateProduct(Product product) {
		Session session  = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		
	}

	@Override
	@Transactional
	public void deleteProduct(Product product) {
		Session session  = sessionFactory.getCurrentSession();
		session.remove(product);
		
	}

	@Override
	public long getCountDuplicateFiles(String fileName, int numberFieldUrl) {
		Session session  = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(*) from Product where urlImage"+numberFieldUrl+" = :fileName ");
		query.setParameter("fileName", fileName);
		return ((Long)query.uniqueResult()).intValue();
	}

}
