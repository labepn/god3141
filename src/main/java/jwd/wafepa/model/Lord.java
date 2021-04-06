package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Lord {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String name;
	@Column
	private Integer age;
	@OneToMany(mappedBy = "lord", fetch=FetchType.EAGER)
	private List<Planet> planets = new ArrayList<Planet>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Planet> getPlanets() {
		return planets;
	}
	public void addPlanet(Planet planet) {
		this.planets.add(planet);
		if(!this.equals(planet.getLord())) {
			planet.setLord(this);
		}
	}
	
	
	

}
