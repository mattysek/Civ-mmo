package org.civmmo.persistence.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Resource
 *
 */
@Entity

public class Resource implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String name;
	private int food;
	private int production;
	private int gold;
	private double happiness;
	
	@ManyToOne
	private Improvement improvement;
	@ManyToOne
	private Resource revealedBy;
	@ManyToMany
	private List<Building> requiredByBuildings;
	@ManyToMany
	private List<Unit> requiredByUnits;
	@OneToMany(mappedBy="resource")
	private List<Tile> canBeFoundOnTiles;
	
	private static final long serialVersionUID = 1L;

	public Resource() {
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
	public int getFood() {
		return this.food;
	}

	public void setFood(int food) {
		this.food = food;
	}   
	public int getProduction() {
		return this.production;
	}

	public void setProduction(int production) {
		this.production = production;
	}   
	public int getGold() {
		return this.gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}   
	public double getHappiness() {
		return this.happiness;
	}

	public void setHappiness(double happiness) {
		this.happiness = happiness;
	}
	public Improvement getImprovement() {
		return improvement;
	}
	public void setImprovement(Improvement improvement) {
		this.improvement = improvement;
	}
	public Resource getRevealedBy() {
		return revealedBy;
	}
	public void setRevealedBy(Resource revealedBy) {
		this.revealedBy = revealedBy;
	}
	public List<Building> getRequiredByBuildings() {
		return requiredByBuildings;
	}
	public void setRequiredByBuildings(List<Building> requiredByBuildings) {
		this.requiredByBuildings = requiredByBuildings;
	}
	public List<Unit> getRequiredByUnits() {
		return requiredByUnits;
	}
	public void setRequiredByUnits(List<Unit> requiredByUnits) {
		this.requiredByUnits = requiredByUnits;
	}
	public List<Tile> getCanBeFoundOnTiles() {
		return canBeFoundOnTiles;
	}
	public void setCanBeFoundOnTiles(List<Tile> canBeFoundOnTiles) {
		this.canBeFoundOnTiles = canBeFoundOnTiles;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + this.food;
        hash = 13 * hash + this.production;
        hash = 13 * hash + this.gold;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.happiness) ^ (Double.doubleToLongBits(this.happiness) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Resource other = (Resource) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.food != other.food) {
            return false;
        }
        if (this.production != other.production) {
            return false;
        }
        if (this.gold != other.gold) {
            return false;
        }
        if (Double.doubleToLongBits(this.happiness) != Double.doubleToLongBits(other.happiness)) {
            return false;
        }
        return true;
    }
	
   
}
