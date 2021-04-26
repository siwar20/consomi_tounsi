package tn.esprit.spring.service;

import java.util.List;
//import java.util.Optional;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.RayonType;

public interface ProductService {
	
	List<Product> retrieveAllProducts();
	
	Product addProduct(Product P);
	
	void deleteProduct(Long id);
	
	Product updateProduct(Product P);
	
	Product retrieveProduct(Long idProduct);

	List<Product> findProductByName(String q);
	
	void verifierProductByDateExpiration(Product product);

}
