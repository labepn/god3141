package jwd.wafepa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Lord;
import jwd.wafepa.repository.LordRepository;
import jwd.wafepa.service.LordService;

@Service
@Transactional
public class JpaLordServiceImpl implements LordService {
	
	@Autowired
	private LordRepository lordRepository;

	@Override
	public Lord findOne(Long id) {
		return lordRepository.findOne(id);
	}
	@Override
	public List<Lord> findAll() {
		return lordRepository.findAll();
	}
	@Override
	public void save(Lord lord) {
		lordRepository.save(lord);
	}
	@Override
	public void remove(Long id) {
		lordRepository.delete(id);
	}
	@Override
	public List<Lord> top10() {
		List<Lord> in = lordRepository.top10();
		System.out.println("LISTA:"+in);
		System.out.println("LISTA:"+lordRepository.top10());
		List<Lord> out = new ArrayList<Lord>(10);
		for (int i = 0; i < 10; i++) {
			out.add(i, in.get(i));
		}
		return out;
	}
	@Override
	public List<Lord> selectUnemployed() {
		List<Lord> in = lordRepository.findAll();
		List<Lord> out = new ArrayList<>();
		for (Lord lord : in) {
			if (lord.getPlanets().isEmpty()) {
				out.add(lord);
			}
		}
		return out;
	}

}
