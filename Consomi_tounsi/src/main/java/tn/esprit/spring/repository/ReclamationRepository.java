package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.reclamation;

@Repository
public interface ReclamationRepository extends CrudRepository<reclamation,Integer> {
}
 