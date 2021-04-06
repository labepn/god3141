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

import jwd.wafepa.model.Lord;
import jwd.wafepa.model.Planet;
import jwd.wafepa.service.LordService;
import jwd.wafepa.service.PlanetService;
import jwd.wafepa.support.LordDTOToLord;
import jwd.wafepa.support.LordToLordDTO;
import jwd.wafepa.web.dto.LordDTO;


@RestController
@RequestMapping("/api/lords")
public class ApiLordController {
	
	@Autowired
	private LordService lordService;
	
	@Autowired
	private PlanetService planetService;
	
	@Autowired
	private LordToLordDTO toDTO;
	
	@Autowired
	private LordDTOToLord toLord;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<LordDTO>> getAll(){
		
		List<Lord> lords = lordService.findAll();
		
		return new ResponseEntity<List<LordDTO>>(toDTO.convert(lords), HttpStatus.OK);
	}

	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<LordDTO> getById(@PathVariable Long id){
		
		Lord lord = lordService.findOne(id);
		
		if (lord == null) {
			return new ResponseEntity<LordDTO> (HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<LordDTO> (toDTO.convert(lord), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/top10")
	public ResponseEntity<List<LordDTO>> getTop10(){
		List<Lord> top10 = lordService.top10();
		
		return new ResponseEntity<List<LordDTO>>(toDTO.convert(top10), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/unemployed")
	public ResponseEntity<List<LordDTO>> selectUnemployed(){
		List<Lord> top10 = lordService.selectUnemployed();
		
		return new ResponseEntity<List<LordDTO>>(toDTO.convert(top10), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<LordDTO> add(@RequestBody LordDTO lordDTO){
		Lord lord = toLord.convert(lordDTO);
		lordService.save(lord);
		return new ResponseEntity<LordDTO> (toDTO.convert(lord), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}")
	public ResponseEntity<LordDTO> edit(
			@PathVariable Long id,
			@RequestBody LordDTO izmenjen){
		
		if(!id.equals(izmenjen.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Lord lord = toLord.convert(izmenjen); 
		lordService.save(lord);
		Long pid = new Long(izmenjen.getPlanetaId());
		Planet planet = planetService.findOne(pid);
		planet.setLord(lord);
		planetService.save(planet);
		
		return new ResponseEntity<>(toDTO.convert(lord),
				HttpStatus.OK);
	}
}
