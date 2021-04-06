package jwd.wafepa.web.dto;

public class PlanetDTO {

	private Long id;
	private String name;
	private Long lordId;
	private String lordName;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLordName() {
		return lordName;
	}
	public void setLordName(String lordName) {
		this.lordName = lordName;
	}
	public Long getLordId() {
		return lordId;
	}
	public void setLordId(Long lordId) {
		this.lordId = lordId;
	}

	
	
}
