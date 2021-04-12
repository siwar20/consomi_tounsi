package tn.esprit.spring.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.repository.CategoryRepository;
import tn.esprit.spring.service.CategoryService;

@Service
public class CategoryServicelmpl implements CategoryService {

	
	@Autowired
	public CategoryRepository categoryrep;
	
	@Override
	public List<Category> retrieveAllCategory() {
		return categoryrep.findAll();
	}

	@Override
	public Category addCategory(Category C) {
		
		return categoryrep.save(C) ;
	}

	@Override
	public void deleteCategory(Long id) {
		categoryrep.deleteById(id);
		
	}

	@Override
	public Category updateCategory(Category C) {
		
		return categoryrep.save(C);
	}

	@Override
	public Category retrieveCategory(Long idCategory) {
		
		return categoryrep.findCategoryById(idCategory);
	}	

}
