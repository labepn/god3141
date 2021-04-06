package jwd.wafepa.service;

import java.util.List;


import jwd.wafepa.model.Lord;


public interface LordService {
	
	Lord findOne(Long id);
	List<Lord> findAll();
	void save(Lord lord);
	void remove(Long id);
	List<Lord> top10();
	List<Lord> selectUnemployed();
}
