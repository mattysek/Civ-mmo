package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: Improvement
 *
 */
@Entity
@Indexed
public class ImprovementEntity extends Improvement implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy="improvement", cascade = CascadeType.ALL)
	private List<TileEntity> ofTiles;
	
	private static final long serialVersionUID = 1L;

	public ImprovementEntity() {
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
		this.ofTiles = (List<TileEntity>)(List<?>)ofTiles;
	}
	
}
