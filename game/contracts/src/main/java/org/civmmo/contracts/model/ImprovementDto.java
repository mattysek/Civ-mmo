package org.civmmo.contracts.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

public class ImprovementDto implements Serializable {

	private long id;
	private String name;
	
	private List<TileDto> ofTiles;
	
	private static final long serialVersionUID = 1L;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public List<TileDto> getOfTiles() {
		return ofTiles;
	}
	public void setOfTiles(List<TileDto> ofTiles) {
		this.ofTiles = ofTiles;
	}
}
