package tn.esprit.spring.restController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.service.CategoryService;


@RestController
@RequestMapping("/api/category")
public class CategoryRestContoller {

	@Autowired
	private CategoryService categoryService ;
	
	

	
	
	@GetMapping("/Category")
    public List<Category> getAllCategory()  {
        return (List<Category>) categoryService.retrieveAllCategory();
    }

    @PostMapping("/add/Category")
    public ResponseEntity<Category> addCategory(@RequestBody Category C)  {
    	Category category= categoryService.addCategory(C);
    	return new ResponseEntity<>( category,  HttpStatus.CREATED);
    }
    
     
    @PutMapping("/update/Category")
    public ResponseEntity<Category> updateCategory(@RequestBody Category Category) {
         if (Category.getId() != null) {
        	 categoryService.updateCategory(Category);
        }
         return new ResponseEntity<>(Category, HttpStatus.OK);
         
    }

   
    @GetMapping("/Category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long idCategory) {
        Category category =  categoryService.retrieveCategory(idCategory);
        return new ResponseEntity<>( category, HttpStatus.OK);	
     }

 
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
    	categoryService.deleteCategory(id);
    }
}

