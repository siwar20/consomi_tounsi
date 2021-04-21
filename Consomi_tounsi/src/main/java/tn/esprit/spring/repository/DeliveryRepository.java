package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Delivery;

public interface DeliveryRepository extends CrudRepository<Delivery,Integer> {
}
