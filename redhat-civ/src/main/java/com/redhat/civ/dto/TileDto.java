package com.redhat.civ.dto;

import java.util.List;

public class TileDto {

	public long id;
	public long x;
	public long y;
	public CityDto city;
	public UnitDto militaryUnit;
	public UnitDto civilUnit;
	public TerrainFeatureDto terrainFeature;
	public TerrainTypeDto terrainType;
	public ImprovementDto improvement;
	public ResourceDto resource;
	public List<TradeRouteDto> tradeRoutes;
	public List<RiverDto> rivers;
	public List<CityDto> visibleForCities;
	public List<UnitDto> visibleForUnits;
	public List<CityDto> controledByCity;
	public List<UnitDto> controledByUnit;
	public List<CityDto> workedBy;
}
