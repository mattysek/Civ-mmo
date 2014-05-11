package org.civmmo.contracts.model;

import java.io.Serializable;
import java.util.List;

public class RiverDto implements Serializable {

	private long id;
	private List<TileDto> tiles;
	
	private static final long serialVersionUID = 1L;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public List<TileDto> getTiles() {
		return tiles;
	}
	public void setTiles(List<TileDto> tiles) {
		this.tiles = tiles;
	}
}
