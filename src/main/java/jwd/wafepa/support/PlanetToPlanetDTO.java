package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Planet;
import jwd.wafepa.web.dto.PlanetDTO;


@Component
public class PlanetToPlanetDTO 
	implements Converter<Planet, PlanetDTO> {

	@Override
	public PlanetDTO convert(Planet source) {
		PlanetDTO dto = new PlanetDTO();
		dto.setId(source.getId());
		dto.setName(source.getName());
		if (source.getLord() != null) {
			dto.setLordId(source.getLord().getId());
			dto.setLordName(source.getLord().getName());
		}
		return dto;
	}
	
	public List<PlanetDTO> convert(List<Planet> planets){
		List<PlanetDTO> dtos = new ArrayList<>();
		
		for(Planet p: planets) {
			dtos.add(convert(p));
		}
		
		return dtos;
	}
}
