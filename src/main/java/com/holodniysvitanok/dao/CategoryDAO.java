package com.holodniysvitanok.dao;

import java.util.List;

import com.holodniysvitanok.entity.Category;

public interface CategoryDAO extends FileDublicate{

	List<Category> getAllCategory(int count);

	Category getCategory(long id);

	void saveOrUpdateCategory(Category category);

	void deleteCategory(Category category);


}
