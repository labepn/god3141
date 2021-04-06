package jwd.wafepa.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Lord;
import jwd.wafepa.service.LordService;
import jwd.wafepa.service.PlanetService;
import jwd.wafepa.web.dto.LordDTO;


@Component
public class LordDTOToLord 
	implements Converter<LordDTO, Lord>{
	
	@Autowired
	private LordService lordService;
	
	@Autowired
	private PlanetService planetService;


	@Override
	public Lord convert(LordDTO source) {
		Lord lord;
		if(source.getId()==null) {
			lord = new Lord();
		}else {
			lord = lordService.findOne(source.getId());
		}
		lord.setName(source.getName());
		lord.setAge(source.getAge());
		if(source.getPlanetaId()!=null) {
			lord.addPlanet(planetService.findOne(source.getId()));
		}
		return lord;
	}

}
