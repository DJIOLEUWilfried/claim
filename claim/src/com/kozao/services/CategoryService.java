package com.kozao.services;

import java.util.List;

import com.kozao.models.Category;

public interface CategoryService {

	int addCategory(Category cat);

	int updateCategory(Category cat);

	int deleteCategory(int id);

	Category findCategoryById(int id);

	Category findCategoryByName(String name);

	List<Category> findAllCategory();

}
