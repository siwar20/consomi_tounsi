package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.RayonType;

@Repository
public interface RayonRepository  extends JpaRepository<Rayon, Long> {
	 Rayon findRayonByid(Long id);

	List<Rayon> findRayonByType(RayonType type);

}
