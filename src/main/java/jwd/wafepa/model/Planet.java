package jwd.wafepa.model;

import javax.persistence.*;

@Entity
@Table
public class Planet {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column (nullable = false)
	private String name;
	@ManyToOne(fetch=FetchType.EAGER)
	private Lord lord;
	
	
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
	public Lord getLord() {
		return lord;
	}
	public void setLord(Lord lord) {
		this.lord = lord;
		if(lord != null && !lord.getPlanets().contains(this)) {
			lord.getPlanets().add(this);
		}
	}
	
		

	
	
}
