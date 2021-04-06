package jwd.wafepa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Planet;

@Repository
public interface PlanetRepository 
	extends JpaRepository<Planet, Long> {

}
