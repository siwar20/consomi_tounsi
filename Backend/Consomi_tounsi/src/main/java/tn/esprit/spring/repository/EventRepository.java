package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
