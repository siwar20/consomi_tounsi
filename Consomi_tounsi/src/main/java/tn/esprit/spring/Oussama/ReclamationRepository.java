package tn.esprit.spring.Oussama;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository extends CrudRepository<reclamation,Integer> {
}
 