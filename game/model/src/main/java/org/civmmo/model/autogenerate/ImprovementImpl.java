package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;


/**
 * Entity implementation class for Entity: Improvement
 *
 */
public class ImprovementImpl extends Improvement implements Serializable {

	private long id;
	private String name;
	
	private List<TileImpl> ofTiles;
	
	private static final long serialVersionUID = 1L;

	public ImprovementImpl() {
		super();
	}   
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
	public List<Tile> getOfTiles() {
		return new ArrayList<>(ofTiles);
	}
	public void setOfTiles(List<Tile> ofTiles) {
		this.ofTiles = (List<TileImpl>)(List<?>)ofTiles;
	}
	
}
