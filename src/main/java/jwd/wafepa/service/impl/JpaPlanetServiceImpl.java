package jwd.wafepa.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Planet;
import jwd.wafepa.repository.PlanetRepository;
import jwd.wafepa.service.PlanetService;

@Service
@Transactional
public class JpaPlanetServiceImpl implements PlanetService {
	
	@Autowired
	private PlanetRepository planetRepository;

	@Override
	public Planet findOne(Long id) {
		return planetRepository.findOne(id);
	}
	@Override
	public List<Planet> findAll() {
		return planetRepository.findAll();
	}
	@Override
	public void save(Planet planet) {
		planetRepository.save(planet);
	}
	@Override
	public void remove(Long id) {
		planetRepository.delete(id);
	}

	
	
}
