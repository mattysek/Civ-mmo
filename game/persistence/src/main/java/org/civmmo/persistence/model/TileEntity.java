package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;
import java.util.ArrayList;
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
	private CityEntity city;
    @OneToOne(mappedBy="position", cascade = CascadeType.ALL)
	private UnitEntity militaryUnit;
    @OneToOne(mappedBy="position", cascade = CascadeType.ALL)
	private UnitEntity civilUnit;
	
    @ManyToOne(cascade = CascadeType.ALL)
	private RegionEntity region;
	@ManyToOne(cascade = CascadeType.ALL)
	private TerrainFeatureEntity terrainFeature;
	@ManyToOne(cascade = CascadeType.ALL)
	private TerrainTypeEntity terrainType;
	@ManyToOne(cascade = CascadeType.ALL)
	private ImprovementEntity improvement;
	@ManyToOne(cascade = CascadeType.ALL)
	private ResourceEntity resource;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<TradeRouteEntity> tradeRoutes;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<RiverEntity> rivers;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<CityEntity> visibleForCities;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<UnitEntity> visibleForUnits;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<CityEntity> controledByCity;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<UnitEntity> controledByUnit;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<CityEntity> workedBy;
	
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
            this.region = (RegionEntity)region;
        }
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = (CityEntity)city;
	}
	public Unit getMilitaryUnit() {
		return militaryUnit;
	}
	public void setMilitaryUnit(Unit militaryUnit) {
		this.militaryUnit = (UnitEntity)militaryUnit;
	}
	public Unit getCivilUnit() {
		return civilUnit;
	}
	public void setCivilUnit(Unit civilUnit) {
		this.civilUnit = (UnitEntity)civilUnit;
	}
	public TerrainFeature getTerrainFeature() {
		return terrainFeature;
	}
	public void setTerrainFeature(TerrainFeature terrainFeature) {
		this.terrainFeature = (TerrainFeatureEntity)terrainFeature;
	}
	public TerrainType getTerrainType() {
		return terrainType;
	}
	public void setTerrainType(TerrainType terrainType) {
		this.terrainType = (TerrainTypeEntity)terrainType;
	}
	public Improvement getImprovement() {
		return improvement;
	}
	public void setImprovement(Improvement improvement) {
		this.improvement = (ImprovementEntity)improvement;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = (ResourceEntity)resource;
	}
	public List<TradeRoute> getTradeRoutes() {
		return new ArrayList<>(tradeRoutes);
	}
	public void setTradeRoutes(List<TradeRoute> tradeRoutes) {
		this.tradeRoutes = (List<TradeRouteEntity>)(List<?>)tradeRoutes;
	}
	public List<River> getRivers() {
		return new ArrayList<>(rivers);
	}
	public void setRivers(List<River> rivers) {
		this.rivers = (List<RiverEntity>)(List<?>)rivers;
	}
	public List<City> getVisibleForCities() {
		return new ArrayList<>(visibleForCities);
	}
	public void setVisibleForCities(List<City> visibleForCities) {
		this.visibleForCities = (List<CityEntity>)(List<?>)visibleForCities;
	}
	public List<Unit> getVisibleForUnits() {
		return new ArrayList<>(visibleForUnits);
	}
	public void setVisibleForUnits(List<Unit> visibleForUnits) {
		this.visibleForUnits = (List<UnitEntity>)(List<?>)visibleForUnits;
	}
	public List<City> getControledByCity() {
		return new ArrayList<>(controledByCity);
	}
	public void setControledByCity(List<City> controledByCity) {
		this.controledByCity = (List<CityEntity>)(List<?>)controledByCity;
	}
	public List<Unit> getControledByUnit() {
		return new ArrayList<>(controledByUnit);
	}
	public void setControledByUnit(List<Unit> controledByUnit) {
		this.controledByUnit = (List<UnitEntity>)(List<?>)controledByUnit;
	}
	public List<City> getWorkedBy() {
		return new ArrayList<>(workedBy);
	}
	public void setWorkedBy(List<City> workedBy) {
		this.workedBy = (List<CityEntity>)(List<?>)workedBy;
	}
	
}
