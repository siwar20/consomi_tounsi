package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findProductByid(Long id);

	@Query(value = "select p from Product p where p.product_name like %:q%  and " + " p.category.type like %:t%  ")
	List<Product> findProductByProduct_nameAndProduct_type(@Param("q") String q, @Param("t") String t);
	
	
}
