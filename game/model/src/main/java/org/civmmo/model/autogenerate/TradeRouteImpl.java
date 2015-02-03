package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity implementation class for Entity: TradeRoute
 *
 */
public class TradeRouteImpl extends TradeRoute implements Serializable {

	private long id;
	
	private CityImpl from;
	private CityImpl to;
	private List<TileImpl> tiles;
	
	private static final long serialVersionUID = 1L;

	public TradeRouteImpl() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public City getFrom() {
		return from;
	}
	public void setFrom(City from) {
		this.from = (CityImpl)from;
	}
	public City getTo() {
		return to;
	}
	public void setTo(City to) {
		this.to = (CityImpl)to;
	}
	public List<Tile> getTiles() {
		return new ArrayList<>(tiles);
	}
	public void setTiles(List<Tile> tiles) {
		this.tiles = (List<TileImpl>)(List<?>)tiles;
	}
}
