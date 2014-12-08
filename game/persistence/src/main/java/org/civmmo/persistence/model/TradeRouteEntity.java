package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: TradeRoute
 *
 */
@Entity
@Indexed
public class TradeRouteEntity extends TradeRoute implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CityEntity from;
	@ManyToOne(cascade = CascadeType.ALL)
	private CityEntity to;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<TileEntity> tiles;
	
	private static final long serialVersionUID = 1L;

	public TradeRouteEntity() {
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
		this.from = (CityEntity)from;
	}
	public City getTo() {
		return to;
	}
	public void setTo(City to) {
		this.to = (CityEntity)to;
	}
	public List<Tile> getTiles() {
		return new ArrayList<>(tiles);
	}
	public void setTiles(List<Tile> tiles) {
		this.tiles = (List<TileEntity>)(List<?>)tiles;
	}
}
