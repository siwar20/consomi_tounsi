package tn.esprit.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Forum;



public interface ForumsRepository extends JpaRepository<Forum, Long> {
	@Modifying
	@Query(value="UPDATE Forum s SET s.likes=:nb WHERE s.id=:id",nativeQuery= true)
    int addLike(@Param("nb") int nb , @Param("id") long id);
	
	
	@Query("FROM Forum ORDER BY likes DESC")
	List<Forum> findbylikes();

	
    
	 
	
	
	

}
