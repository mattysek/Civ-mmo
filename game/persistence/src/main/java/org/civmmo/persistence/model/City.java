package org.civmmo.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: City
 *
 */
@Entity
@Indexed
public class City implements Serializable {

	@Column(nullable=false)
	private String name;   
	@Id
	@GeneratedValue
	private long id;
	private int range;
	private int food;
	private int production;
	private int gold;
	private int science;
	private int culture;
	private int hitPoints;
	private int citizens;
        
        @OneToOne(cascade = CascadeType.ALL)
	private Tile center;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Civilization ownedBy;
	@ManyToOne(cascade = CascadeType.ALL)
	private Building currentlyConstructedBuilding;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Building> constructedBuildings;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Building> workedBuildings;
	@OneToMany(mappedBy="from",cascade = CascadeType.ALL)
	private List<TradeRoute> tradeRoutesFrom;
	@OneToMany(mappedBy="to",cascade = CascadeType.ALL)
	private List<TradeRoute> tradeRoutesTo;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Tile> visibleTiles;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Tile> controledTiles;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Tile> workedTiles;
	@ManyToOne(cascade = CascadeType.ALL)
	private Unit currentlyConstructedUnit;
	
	private static final long serialVersionUID = 1L;

	public City() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public int getRange() {
		return this.range;
	}

	public void setRange(int range) {
		this.range = range;
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
	public int getScience() {
		return this.science;
	}

	public void setScience(int science) {
		this.science = science;
	}   
	public int getCulture() {
		return this.culture;
	}

	public void setCulture(int culture) {
		this.culture = culture;
	}   
	public int getHitPoints() {
		return this.hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}   
	public int getCitizens() {
		return this.citizens;
	}

	public void setCitizens(int citizens) {
		this.citizens = citizens;
	}
	public Tile getCenter() {
		return center;
	}
	public void setCenter(Tile center) {
		this.center = center;
	}
	public Civilization getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(Civilization ownedBy) {
		this.ownedBy = ownedBy;
	}
	public Building getCurrentlyConstructedBuilding() {
		return currentlyConstructedBuilding;
	}
	public void setCurrentlyConstructedBuilding(
			Building currentlyConstructedBuilding) {
		this.currentlyConstructedBuilding = currentlyConstructedBuilding;
	}
	public List<Building> getConstructedBuildings() {
		return constructedBuildings;
	}
	public void setConstructedBuildings(List<Building> constructedBuildings) {
		this.constructedBuildings = constructedBuildings;
	}
	public List<Building> getWorkedBuildings() {
		return workedBuildings;
	}
	public void setWorkedBuildings(List<Building> workedBuildings) {
		this.workedBuildings = workedBuildings;
	}
	public List<TradeRoute> getTradeRoutesFrom() {
		return tradeRoutesFrom;
	}
	public void setTradeRoutesFrom(List<TradeRoute> tradeRoutesFrom) {
		this.tradeRoutesFrom = tradeRoutesFrom;
	}
	public List<TradeRoute> getTradeRoutesTo() {
		return tradeRoutesTo;
	}
	public void setTradeRoutesTo(List<TradeRoute> tradeRoutesTo) {
		this.tradeRoutesTo = tradeRoutesTo;
	}
	public List<Tile> getVisibleTiles() {
		return visibleTiles;
	}
	public void setVisibleTiles(List<Tile> visibleTiles) {
		this.visibleTiles = visibleTiles;
	}
	public List<Tile> getControledTiles() {
		return controledTiles;
	}
	public void setControledTiles(List<Tile> controledTiles) {
		this.controledTiles = controledTiles;
	}
	public List<Tile> getWorkedTiles() {
		return workedTiles;
	}
	public void setWorkedTiles(List<Tile> workedTiles) {
		this.workedTiles = workedTiles;
	}
	public Unit getCurrentlyConstructedUnit() {
		return currentlyConstructedUnit;
	}
	public void setCurrentlyConstructedUnit(Unit currentlyConstructedUnit) {
		this.currentlyConstructedUnit = currentlyConstructedUnit;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + citizens;
		result = prime * result + culture;
		result = prime * result + food;
		result = prime * result + gold;
		result = prime * result + hitPoints;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((ownedBy == null) ? 0 : ownedBy.hashCode());
		result = prime * result + production;
		result = prime * result + range;
		result = prime * result + science;
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
		if (!(obj instanceof City))
			return false;
		City other = (City) obj;
		if (citizens != other.citizens)
			return false;
		if (culture != other.culture)
			return false;
		if (food != other.food)
			return false;
		if (gold != other.gold)
			return false;
		if (hitPoints != other.hitPoints)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ownedBy == null) {
			if (other.ownedBy != null)
				return false;
		} else if (!ownedBy.equals(other.ownedBy))
			return false;
		if (production != other.production)
			return false;
		if (range != other.range)
			return false;
		if (science != other.science)
			return false;
		return true;
	}

    public void constructBuilding(Building building) {
        if(this.constructedBuildings == null)
        {
            this.constructedBuildings = new ArrayList<>();
        }
        this.constructedBuildings.add(building);
    }

    public void workBuilding(Building building) {
        if(this.workedBuildings == null)
        {
            this.workedBuildings = new ArrayList<>();
        }
        this.workedBuildings.add(building);
    }

    public void constructUnit(Unit unit) {
        this.currentlyConstructedUnit = unit;
    }

    public boolean hasTradeRouteWith(City city) {
        if(this.tradeRoutesTo == null)
        {
            return false;
        }
        return this.tradeRoutesTo.stream().anyMatch(t->t.getFrom().equals(city));
    }

    public void controlTile(Tile tile) {
        if(this.controledTiles == null)
        {
            this.controledTiles = new ArrayList<>();
        }
        this.controledTiles.add(tile);
    }

    public void workTile(Tile tile) {
        if(this.workedTiles == null)
        {
            this.workedTiles = new ArrayList<>();
        }
        this.workedTiles.add(tile);
    }

    public Unit attackUnit(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void computeWealthGrowth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
