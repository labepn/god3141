package jwd.wafepa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Planet;
import jwd.wafepa.model.Lord;
import jwd.wafepa.service.PlanetService;
import jwd.wafepa.service.LordService;

@Component
public class TestData {

	@Autowired
	private LordService lordService;
	
	@Autowired
	private PlanetService planetService;
	

	@PostConstruct
	public void init() {
		
		
		Lord l1 = new Lord();
		l1.setId(1L);
		l1.setAge(40);
		l1.setName("Augustus");
		lordService.save(l1);
		
		
		Lord l2 = new Lord();
		l2.setId(2L);
		l2.setAge(35);
		l2.setName("Tiberius");
		lordService.save(l2);
		
		Lord l3 = new Lord();
		l3.setId(3L);
		l3.setAge(27);
		l3.setName("Caligula");
		lordService.save(l3);
		
		Lord l4 = new Lord();
		l4.setId(4L);
		l4.setAge(33);
		l4.setName("Claudius");
		lordService.save(l4);
		
		Lord l5 = new Lord();
		l5.setId(5L);
		l5.setAge(55);
		l5.setName("Nero");
		lordService.save(l5);
		
		Lord l6 = new Lord();
		l6.setId(6L);
		l6.setAge(65);
		l6.setName("Galba");
		lordService.save(l6);
		
		Lord l7 = new Lord();
		l7.setId(7L);
		l7.setAge(37);
		l7.setName("Otho");
		lordService.save(l7);
		
		Lord l8 = new Lord();
		l8.setId(8L);
		l8.setAge(48);
		l8.setName("Vitellius");
		lordService.save(l8);
		
		Lord l9 = new Lord();
		l9.setId(9L);
		l9.setAge(39);
		l9.setName("Vespasian");
		lordService.save(l9);
		
		Lord l10 = new Lord();
		l10.setId(10L);
		l10.setAge(61);
		l10.setName("Titus");
		lordService.save(l10);
		
		Lord l11 = new Lord();
		l11.setId(11L);
		l11.setAge(54);
		l11.setName("Domitian");
		lordService.save(l11);

		Lord l12 = new Lord();
		l12.setId(12L);
		l12.setAge(21);
		l12.setName("Trajan");
		lordService.save(l12);
		
		Lord l13 = new Lord();
		l13.setId(13L);
		l13.setAge(29);
		l13.setName("Hadrian");
		lordService.save(l13);
		
		Lord l14 = new Lord();
		l14.setId(14L);
		l14.setAge(30);
		l14.setName("Marcus Aurelius");
		lordService.save(l14);
		
		Lord l15 = new Lord();
		l15.setId(15L);
		l15.setAge(20);
		l15.setName("Geta");
		lordService.save(l15);
		
		Planet p1 = new Planet();
		p1.setId(1L);
		p1.setName("Earth");
		p1.setLord(l1);
		planetService.save(p1);
		
		Planet p2 = new Planet();
		p2.setId(2L);
		p2.setName("Mars");
		p1.setLord(l2);
		planetService.save(p2);
		
		Planet p3 = new Planet();
		p3.setId(3L);
		p3.setName("Venera");
		p3.setLord(l3);
		planetService.save(p3);
		
		Planet p4 = new Planet();
		p4.setId(4L);
		p4.setName("Jupiter");
		p4.setLord(l1);
		planetService.save(p4);
		
		Planet p5 = new Planet();
		p5.setId(5L);
		p5.setName("Uranus");
		p5.setLord(l11);
		planetService.save(p5);
		
		Planet p6 = new Planet();
		p6.setId(6L);
		p6.setName("Neptun");
		p6.setLord(l6);
		planetService.save(p6);
		
		Planet p7 = new Planet();
		p7.setId(7L);
		p7.setName("Pluto");
		p7.setLord(l8);
		planetService.save(p7);
		
		Planet p8 = new Planet();
		p8.setId(8L);
		p8.setName("Miller");
		p8.setLord(l4);
		planetService.save(p8);
		
		Planet p9 = new Planet();
		p9.setId(9L);
		p9.setName("Edmuns");
		p9.setLord(l12);
		planetService.save(p9);
		
		Planet p10 = new Planet();
		p10.setId(10L);
		p10.setName("Mann");
		p10.setLord(l14);
		planetService.save(p10);
		
		Planet p11 = new Planet();
		p11.setId(11L);
		p11.setName("Saturn");
		p11.setLord(l2);
		planetService.save(p11);
	}
}
