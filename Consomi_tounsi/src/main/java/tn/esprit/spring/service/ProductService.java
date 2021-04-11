package tn.esprit.spring.service;

import java.util.List;
//import java.util.Optional;

import tn.esprit.spring.entity.Product;

public interface ProductService {
	
	List<Product> retrieveAllProducts();
	
	Product addProduct(Product P);
	
	void deleteProduct(Long id);
	
	Product updateProduct(Product P);
	
	Product retrieveProduct(Long idProduct);

	List<Product> findProductByNameAndType(String q,String t);
	
	void verifierProductByDateExpiration(Product product);

}
