package tn.esprit.spring.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.service.ProductService;
import tn.esprit.spring.service.RayonService;

@Controller
@RequestMapping("/api/rayon")
public class RayonRestController {
	
	@Autowired
	public RayonService rayonservice;
	
	@Autowired
	public ProductService productService;
	
	
	
	
	@GetMapping("/Rayon")
    public ResponseEntity<List<Rayon>> getAllRayon()  {
         List<Rayon> R = rayonservice.retrieveAllRayon();
         return new ResponseEntity<>( R, HttpStatus.OK);
         
    }

	@PostMapping("/add")
    public ResponseEntity<Rayon> addRayon(@RequestBody Rayon  rayon )  {
		Rayon R= rayonservice.addRayon(rayon);
    	return new ResponseEntity<>( R,  HttpStatus.CREATED);
    }
     
	@PutMapping("/update")
    public ResponseEntity<Rayon> updateRayon(@RequestBody Rayon rayon) {
         if (rayon.getId() != null) {
        	 rayon = rayonservice.updateRayon(rayon);
        }
         return new ResponseEntity<>(rayon, HttpStatus.OK);  
    }
    
    @GetMapping("/Rayon/{id}")
    public ResponseEntity<Rayon> getRayon(@PathVariable Long id) {
    	Rayon R = rayonservice.retrieveRayon(id);
    	return new ResponseEntity<>( R, HttpStatus.OK);	
        
     }
    
    
    @DeleteMapping("/delete/{id}")
    public void deleteRayon(@PathVariable Long id) {
    	rayonservice.deleteRayon(id);
    }
	
	@PostMapping("/Classify/{id}")
	public ResponseEntity<Rayon> classifyProduct(@PathVariable long id)
	{
		Product product = productService.retrieveProduct(id);
		
		Rayon rayon = rayonservice.classifyProduct(product);
		product.setRayon(rayon);
		productService.addProduct(product);
		return new ResponseEntity<>(rayon, HttpStatus.OK);
	}
	

}
