package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Lord;
import jwd.wafepa.model.Planet;
import jwd.wafepa.web.dto.LordDTO;


@Component
public class LordToLordDTO 
	implements Converter<Lord, LordDTO> {

	@Override
	public LordDTO convert(Lord source) {
		LordDTO dto = new LordDTO();
		dto.setId(source.getId());
		dto.setName(source.getName());
		dto.setAge(source.getAge());
		String pn = new String();
		if(source.getPlanets().size()>1) {
			for (Planet p : source.getPlanets()) {
				pn = pn + " " + p.getName();
				
			}
		}else if(source.getPlanets().size()==1) {
			pn = " "+ source.getPlanets().get(0).getName();
		}
		dto.setPlanetaName(pn);
		return dto;
	}
	
	public List<LordDTO> convert(List<Lord> lords){
		List<LordDTO> dtos = new ArrayList<>();
		
		for(Lord l : lords) {
			dtos.add(convert(l));
		}
		
		return dtos;	
	}

}
