package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.delivery_man;

public interface delivery_manRepository extends CrudRepository<delivery_man,Integer> {


// get All Salaries
    @Query("SELECT SUM(d.salaire) FROM delivery_man d")
    double salairedeliveryman();
//update la salaire avec la salaire
    @Modifying
    @Query(value="UPDATE delivery_man d SET d.salaire=:nb WHERE d.id=:id",nativeQuery= true)
    int salaireprimé(@Param("nb") double nb , @Param("id") int id);
// update bonus
    @Modifying
    @Query(value="UPDATE delivery_man d SET d.bonus=:nb WHERE d.id=:id",nativeQuery= true)
    int primeupdate(@Param("nb") double nb , @Param("id") int id);

}
