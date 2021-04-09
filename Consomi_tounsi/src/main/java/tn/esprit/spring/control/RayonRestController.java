package tn.esprit.spring.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.service.ProductService;
import tn.esprit.spring.service.RayonService;

=======
>>>>>>> 2a486c3 (oussama)
@Controller
@RequestMapping("/api/rayon")
public class RayonRestController {
	/*
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
		return new ResponseEntity<>(rayon, HttpStatus.OK);
	}

	 */
	

}
