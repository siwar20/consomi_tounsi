package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entities.Eventse;
@Repository
public interface EventRepository extends JpaRepository<Eventse, Long> {

}
