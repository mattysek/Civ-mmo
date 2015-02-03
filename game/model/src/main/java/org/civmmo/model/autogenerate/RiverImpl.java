package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Entity implementation class for Entity: River
 *
 */
public class RiverImpl extends River implements Serializable {

	private long id;
	
	private List<TileImpl> tiles;
	
	private static final long serialVersionUID = 1L;

	public RiverImpl() {
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
		this.tiles = (List<TileImpl>)(List<?>)tiles;
	}
}
