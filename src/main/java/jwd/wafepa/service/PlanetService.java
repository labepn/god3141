package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Planet;


public interface PlanetService {
	
	Planet findOne(Long id);
	List<Planet> findAll();
	void save(Planet planet);
	void remove(Long id);

}
