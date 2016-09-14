package com.holodniysvitanok.dao;

import java.util.List;

import com.holodniysvitanok.entity.Product;



public interface ProductDAO{

	List<Product> getAllProducts(int count);
	
	Product getProduct(long id);
	
	void saveOrUpdateProduct(Product product);

	void deleteProduct(Product product);
	
	long getCountDuplicateFiles(String fileName, int numberUrlImageField);
	
	
}
