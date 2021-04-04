package Oussama;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ReclamationRepository extends CrudRepository<reclamation,Long> {
}
 