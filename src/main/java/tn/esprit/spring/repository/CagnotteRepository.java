package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Entities.Cagnotte;

public interface CagnotteRepository extends JpaRepository<Cagnotte, Long> {
List<Cagnotte> findByidEvent(Long idEvent) ;
@Query(value = "SELECT SUM (money) from Cagnotte")
public double sommeDon();
@Query(value = "SELECT SUM (money) from Cagnotte WHERE idEvent = :idEvent")
public double sommeDonEvent(@Param("idEvent") Long idEvent);

}
