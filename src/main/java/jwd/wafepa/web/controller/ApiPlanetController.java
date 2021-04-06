package jwd.wafepa.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Planet;
import jwd.wafepa.service.PlanetService;
import jwd.wafepa.support.PlanetDtoToPlanet;
import jwd.wafepa.support.PlanetToPlanetDTO;
import jwd.wafepa.web.dto.PlanetDTO;

@RestController
@RequestMapping(value = "/api/planets")
public class ApiPlanetController {

	@Autowired
	private PlanetService planetService;
	
	@Autowired
	private PlanetToPlanetDTO toDTO;
	
	@Autowired
	private PlanetDtoToPlanet toPlanet;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PlanetDTO>> getAll(){
		
		List<Planet> planets = planetService.findAll();
		
		return new ResponseEntity<List<PlanetDTO>>(toDTO.convert(planets), HttpStatus.OK);
	}

	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<PlanetDTO> getById(@PathVariable Long id){
		
		Planet planet = planetService.findOne(id);
		
		if (planet == null) {
			return new ResponseEntity<PlanetDTO> (HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<PlanetDTO> (toDTO.convert(planet), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PlanetDTO> add(@RequestBody PlanetDTO newPlanet){
		Planet planet = toPlanet.convert(newPlanet);
		planetService.save(planet);
		return new ResponseEntity<PlanetDTO> (toDTO.convert(planet), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}")
	public ResponseEntity<PlanetDTO> edit(
			@PathVariable Long id,
			@RequestBody PlanetDTO izmenjen){
		
		if(!id.equals(izmenjen.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Planet planet = toPlanet.convert(izmenjen); 
		planetService.save(planet);
		
		return new ResponseEntity<>(toDTO.convert(planet),
				HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<PlanetDTO> delete (@PathVariable Long id){
		planetService.remove(id);
		return new ResponseEntity<PlanetDTO>(HttpStatus.ACCEPTED);
	}
}
