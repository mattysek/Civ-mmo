package org.civmmo.contracts.model;

import java.io.Serializable;
import java.util.List;

public class TradeRouteDto implements Serializable {

	private long id;
        
	private CityDto from;
	private CityDto to;
	private List<TileDto> tiles;
	
	private static final long serialVersionUID = 1L;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public CityDto getFrom() {
		return from;
	}
	public void setFrom(CityDto from) {
		this.from = from;
	}
	public CityDto getTo() {
		return to;
	}
	public void setTo(CityDto to) {
		this.to = to;
	}
	public List<TileDto> getTiles() {
		return tiles;
	}
	public void setTiles(List<TileDto> tiles) {
		this.tiles = tiles;
	}
}
