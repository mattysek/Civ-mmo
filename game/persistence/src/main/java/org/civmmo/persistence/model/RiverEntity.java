package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: River
 *
 */
@Entity
@Indexed
public class RiverEntity extends River implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<TileEntity> tiles;
	
	private static final long serialVersionUID = 1L;

	public RiverEntity() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public List<Tile> getTiles() {
		return new ArrayList<>(tiles);
	}
	public void setTiles(List<Tile> tiles) {
		this.tiles = (List<TileEntity>)(List<?>)tiles;
	}
}
