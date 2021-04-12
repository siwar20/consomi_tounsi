package tn.esprit.spring.restController;

import java.util.List;
//import java.util.Optional;

import javax.xml.ws.Response;

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
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.service.CategoryService;
import tn.esprit.spring.service.ProductService;

@Controller
@RequestMapping("/api/product")
public class ProductRestController {
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	public ProductRestController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProduits() {
		List<Product> P = productService.retrieveAllProducts();
		return new ResponseEntity<>(P, HttpStatus.OK);

	}

	@PostMapping("/add/{categoryId}")
	public ResponseEntity<Product> addProduit(@RequestBody Product product, @PathVariable("categoryId") Long categoryId) {
		String codeABarre = String.valueOf(product.getCode_a_barre());
		if (codeABarre.startsWith("619")) {
			Category category = categoryService.retrieveCategory(categoryId);
			product.setCategory(category);
			product = productService.addProduct(product);

		} else {
			return new ResponseEntity<>(product, HttpStatus.FORBIDDEN);
		}

		return new ResponseEntity<>(product, HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<Product> updateProduit(@RequestBody Product product) {
		if (product.getId() != null) {
			product = productService.updateProduct(product);

		}
		return new ResponseEntity<>(product, HttpStatus.OK);

	}

	@GetMapping("/Product/{id}")
	public ResponseEntity<Product> getProduit(@PathVariable Long id) {
		Product P = productService.retrieveProduct(id);
		return new ResponseEntity<>(P, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public void deleteProduit(@PathVariable Long id) {
		productService.deleteProduct(id);
	}

	@GetMapping("/Product/find")
	public ResponseEntity<List<Product>> findProductByNameAndType(@RequestParam String q, @RequestParam String t) {
		List<Product> list = productService.findProductByNameAndType(q, t);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PutMapping("/product/verif/{idProduct}")
	public ResponseEntity<String> verifierProductByDateExpiration(@PathVariable("idProduct") Long id){
		Product product = productService.retrieveProduct(id);
		productService.verifierProductByDateExpiration(product);
		return new ResponseEntity<>("Product verified.", HttpStatus.OK);
	}

}
