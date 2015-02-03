package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Entity implementation class for Entity: Tile
 *
 */
public class TileImpl extends Tile implements Serializable {

	private long id;
	private long x;
	private long y;
	
	private CityImpl city;
	private UnitImpl militaryUnit;
	private UnitImpl civilUnit;
	
	private RegionImpl region;
	private TerrainFeatureImpl terrainFeature;
	private TerrainTypeImpl terrainType;
	private ImprovementImpl improvement;
	private ResourceImpl resource;
	private List<TradeRouteImpl> tradeRoutes;
	private List<RiverImpl> rivers;
	private List<CityImpl> visibleForCities;
	private List<UnitImpl> visibleForUnits;
	private List<CityImpl> controledByCity;
	private List<UnitImpl> controledByUnit;
	private List<CityImpl> workedBy;
	
	private static final long serialVersionUID = 1L;

	public TileImpl() {
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
            this.region = (RegionImpl)region;
        }
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = (CityImpl)city;
	}
	public Unit getMilitaryUnit() {
		return militaryUnit;
	}
	public void setMilitaryUnit(Unit militaryUnit) {
		this.militaryUnit = (UnitImpl)militaryUnit;
	}
	public Unit getCivilUnit() {
		return civilUnit;
	}
	public void setCivilUnit(Unit civilUnit) {
		this.civilUnit = (UnitImpl)civilUnit;
	}
	public TerrainFeature getTerrainFeature() {
		return terrainFeature;
	}
	public void setTerrainFeature(TerrainFeature terrainFeature) {
		this.terrainFeature = (TerrainFeatureImpl)terrainFeature;
	}
	public TerrainType getTerrainType() {
		return terrainType;
	}
	public void setTerrainType(TerrainType terrainType) {
		this.terrainType = (TerrainTypeImpl)terrainType;
	}
	public Improvement getImprovement() {
		return improvement;
	}
	public void setImprovement(Improvement improvement) {
		this.improvement = (ImprovementImpl)improvement;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = (ResourceImpl)resource;
	}
	public List<TradeRoute> getTradeRoutes() {
		return new ArrayList<>(tradeRoutes);
	}
	public void setTradeRoutes(List<TradeRoute> tradeRoutes) {
		this.tradeRoutes = (List<TradeRouteImpl>)(List<?>)tradeRoutes;
	}
	public List<River> getRivers() {
		return new ArrayList<>(rivers);
	}
	public void setRivers(List<River> rivers) {
		this.rivers = (List<RiverImpl>)(List<?>)rivers;
	}
	public List<City> getVisibleForCities() {
		return new ArrayList<>(visibleForCities);
	}
	public void setVisibleForCities(List<City> visibleForCities) {
		this.visibleForCities = (List<CityImpl>)(List<?>)visibleForCities;
	}
	public List<Unit> getVisibleForUnits() {
		return new ArrayList<>(visibleForUnits);
	}
	public void setVisibleForUnits(List<Unit> visibleForUnits) {
		this.visibleForUnits = (List<UnitImpl>)(List<?>)visibleForUnits;
	}
	public List<City> getControledByCity() {
		return new ArrayList<>(controledByCity);
	}
	public void setControledByCity(List<City> controledByCity) {
		this.controledByCity = (List<CityImpl>)(List<?>)controledByCity;
	}
	public List<Unit> getControledByUnit() {
		return new ArrayList<>(controledByUnit);
	}
	public void setControledByUnit(List<Unit> controledByUnit) {
		this.controledByUnit = (List<UnitImpl>)(List<?>)controledByUnit;
	}
	public List<City> getWorkedBy() {
		return new ArrayList<>(workedBy);
	}
	public void setWorkedBy(List<City> workedBy) {
		this.workedBy = (List<CityImpl>)(List<?>)workedBy;
	}
	
}
