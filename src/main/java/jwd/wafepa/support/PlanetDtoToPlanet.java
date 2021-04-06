package jwd.wafepa.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Planet;
import jwd.wafepa.service.LordService;
import jwd.wafepa.service.PlanetService;
import jwd.wafepa.web.dto.PlanetDTO;


@Component
public class PlanetDtoToPlanet implements Converter<PlanetDTO, Planet> {
	
	@Autowired
	private PlanetService planetService;
	
	@Autowired
	private LordService lordService;

	@Override
	public Planet convert(PlanetDTO dto) {
		Planet planet;
		if (dto.getId() == null) {
			planet = new Planet();
		} else {
			planet = planetService.findOne(dto.getId());
		}
		planet.setName(dto.getName());
		if(dto.getLordId()!=null) {
			planet.setLord(lordService.findOne(dto.getLordId()));
		}
		return planet;
	}

}
