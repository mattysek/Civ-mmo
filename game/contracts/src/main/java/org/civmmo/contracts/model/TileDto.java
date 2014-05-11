package org.civmmo.contracts.model;

import java.io.Serializable;
import java.util.List;

public class TileDto implements Serializable {

	private long id;
	private long x;
	private long y;
	
	private CityDto city;
	private UnitDto militaryUnit;
	private UnitDto civilUnit;
	private RegionDto region;
	private TerrainFeatureDto terrainFeature;
	private TerrainTypeDto terrainType;
	private ImprovementDto improvement;
	private ResourceDto resource;
	private List<TradeRouteDto> tradeRoutes;
	private List<RiverDto> rivers;
	private List<CityDto> visibleForCities;
	private List<UnitDto> visibleForUnits;
	private List<CityDto> controledByCity;
	private List<UnitDto> controledByUnit;
	private List<CityDto> workedBy;
	
	private static final long serialVersionUID = 1L;

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
        public RegionDto getRegion() {
            return region;
        }

        public void setRegion(RegionDto region) {
            this.region = region;
        }
	public CityDto getCity() {
		return city;
	}
	public void setCity(CityDto city) {
		this.city = city;
	}
	public UnitDto getMilitaryUnit() {
		return militaryUnit;
	}
	public void setMilitaryUnit(UnitDto militaryUnit) {
		this.militaryUnit = militaryUnit;
	}
	public UnitDto getCivilUnit() {
		return civilUnit;
	}
	public void setCivilUnit(UnitDto civilUnit) {
		this.civilUnit = civilUnit;
	}
	public TerrainFeatureDto getTerrainFeature() {
		return terrainFeature;
	}
	public void setTerrainFeature(TerrainFeatureDto terrainFeature) {
		this.terrainFeature = terrainFeature;
	}
	public TerrainTypeDto getTerrainType() {
		return terrainType;
	}
	public void setTerrainType(TerrainTypeDto terrainType) {
		this.terrainType = terrainType;
	}
	public ImprovementDto getImprovement() {
		return improvement;
	}
	public void setImprovement(ImprovementDto improvement) {
		this.improvement = improvement;
	}
	public ResourceDto getResource() {
		return resource;
	}
	public void setResource(ResourceDto resource) {
		this.resource = resource;
	}
	public List<TradeRouteDto> getTradeRoutes() {
		return tradeRoutes;
	}
	public void setTradeRoutes(List<TradeRouteDto> tradeRoutes) {
		this.tradeRoutes = tradeRoutes;
	}
	public List<RiverDto> getRivers() {
		return rivers;
	}
	public void setRivers(List<RiverDto> rivers) {
		this.rivers = rivers;
	}
	public List<CityDto> getVisibleForCities() {
		return visibleForCities;
	}
	public void setVisibleForCities(List<CityDto> visibleForCities) {
		this.visibleForCities = visibleForCities;
	}
	public List<UnitDto> getVisibleForUnits() {
		return visibleForUnits;
	}
	public void setVisibleForUnits(List<UnitDto> visibleForUnits) {
		this.visibleForUnits = visibleForUnits;
	}
	public List<CityDto> getControledByCity() {
		return controledByCity;
	}
	public void setControledByCity(List<CityDto> controledByCity) {
		this.controledByCity = controledByCity;
	}
	public List<UnitDto> getControledByUnit() {
		return controledByUnit;
	}
	public void setControledByUnit(List<UnitDto> controledByUnit) {
		this.controledByUnit = controledByUnit;
	}
	public List<CityDto> getWorkedBy() {
		return workedBy;
	}
	public void setWorkedBy(List<CityDto> workedBy) {
		this.workedBy = workedBy;
	}
}
