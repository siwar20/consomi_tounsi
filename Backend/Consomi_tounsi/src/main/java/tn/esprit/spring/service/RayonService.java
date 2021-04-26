package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Rayon;

public interface RayonService {
	
	List<Rayon> retrieveAllRayon();
	
	Rayon addRayon(Rayon R);
	
	void deleteRayon(Long id);
	
	Rayon updateRayon(Rayon R);
	
	Rayon retrieveRayon(Long idRayon);

	Rayon classifyProduct(Product product);

	void affecterProductARayon(Long ProId, Long RayonId);

}
