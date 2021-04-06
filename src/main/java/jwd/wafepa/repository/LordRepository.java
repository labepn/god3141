package jwd.wafepa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Lord;

@Repository
public interface LordRepository 
	extends JpaRepository<Lord, Long> {
	
	@Query ("SELECT s FROM Lord s ORDER BY AGE ASC")
	List<Lord> top10 ();	

}
