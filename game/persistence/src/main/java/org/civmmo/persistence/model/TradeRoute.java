package org.civmmo.persistence.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: TradeRoute
 *
 */
@Entity
@Indexed
public class TradeRoute implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private City from;
	@ManyToOne
	private City to;
	@ManyToMany
	private List<Tile> tiles;
	
	private static final long serialVersionUID = 1L;

	public TradeRoute() {
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
		this.from = from;
	}
	public City getTo() {
		return to;
	}
	public void setTo(City to) {
		this.to = to;
	}
	public List<Tile> getTiles() {
		return tiles;
	}
	public void setTiles(List<Tile> tiles) {
		this.tiles = tiles;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TradeRoute))
			return false;
		TradeRoute other = (TradeRoute) obj;
		if (id != other.id)
			return false;
		return true;
	}
   
}
