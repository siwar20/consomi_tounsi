package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Category;


public interface CategoryService {
	
List<Category> retrieveAllCategory();
	
 	Category addCategory(Category C);
 	
	void deleteCategory(Long id);
	
	Category updateCategory(Category C);
	
	Category retrieveCategory(Long idCategory);
}
