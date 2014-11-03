package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import org.hibernate.search.annotations.Indexed;

/**
 * Entity implementation class for Entity: Tile
 *
 */
@Entity
@Indexed
public class TileEntity extends Tile implements Serializable {

	   
	@Id
	@GeneratedValue
	private long id;
	private long x;
	private long y;
	
        @OneToOne(mappedBy="center", cascade = CascadeType.ALL)
	private City city;
        @OneToOne(mappedBy="position", cascade = CascadeType.ALL)
	private Unit militaryUnit;
        @OneToOne(mappedBy="position", cascade = CascadeType.ALL)
	private Unit civilUnit;
	
        @ManyToOne(cascade = CascadeType.ALL)
	private Region region;
	@ManyToOne(cascade = CascadeType.ALL)
	private TerrainFeature terrainFeature;
	@ManyToOne(cascade = CascadeType.ALL)
	private TerrainType terrainType;
	@ManyToOne(cascade = CascadeType.ALL)
	private Improvement improvement;
	@ManyToOne(cascade = CascadeType.ALL)
	private Resource resource;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<TradeRoute> tradeRoutes;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<River> rivers;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<City> visibleForCities;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Unit> visibleForUnits;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<City> controledByCity;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Unit> controledByUnit;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<City> workedBy;
	
	private static final long serialVersionUID = 1L;

	public TileEntity() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public long getX() {
		return this.x;
	}

	public void setX(long x) {
		this.x = x;
	}   
	public long getY() {
		return this.y;
	}

	public void setY(long y) {
		this.y = y;
	}
        public Region getRegion() {
            return region;
        }

        public void setRegion(Region region) {
            this.region = region;
        }
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Unit getMilitaryUnit() {
		return militaryUnit;
	}
	public void setMilitaryUnit(Unit militaryUnit) {
		this.militaryUnit = militaryUnit;
	}
	public Unit getCivilUnit() {
		return civilUnit;
	}
	public void setCivilUnit(Unit civilUnit) {
		this.civilUnit = civilUnit;
	}
	public TerrainFeature getTerrainFeature() {
		return terrainFeature;
	}
	public void setTerrainFeature(TerrainFeature terrainFeature) {
		this.terrainFeature = terrainFeature;
	}
	public TerrainType getTerrainType() {
		return terrainType;
	}
	public void setTerrainType(TerrainType terrainType) {
		this.terrainType = terrainType;
	}
	public Improvement getImprovement() {
		return improvement;
	}
	public void setImprovement(Improvement improvement) {
		this.improvement = improvement;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public List<TradeRoute> getTradeRoutes() {
		return tradeRoutes;
	}
	public void setTradeRoutes(List<TradeRoute> tradeRoutes) {
		this.tradeRoutes = tradeRoutes;
	}
	public List<River> getRivers() {
		return rivers;
	}
	public void setRivers(List<River> rivers) {
		this.rivers = rivers;
	}
	public List<City> getVisibleForCities() {
		return visibleForCities;
	}
	public void setVisibleForCities(List<City> visibleForCities) {
		this.visibleForCities = visibleForCities;
	}
	public List<Unit> getVisibleForUnits() {
		return visibleForUnits;
	}
	public void setVisibleForUnits(List<Unit> visibleForUnits) {
		this.visibleForUnits = visibleForUnits;
	}
	public List<City> getControledByCity() {
		return controledByCity;
	}
	public void setControledByCity(List<City> controledByCity) {
		this.controledByCity = controledByCity;
	}
	public List<Unit> getControledByUnit() {
		return controledByUnit;
	}
	public void setControledByUnit(List<Unit> controledByUnit) {
		this.controledByUnit = controledByUnit;
	}
	public List<City> getWorkedBy() {
		return workedBy;
	}
	public void setWorkedBy(List<City> workedBy) {
		this.workedBy = workedBy;
	}
	
}
