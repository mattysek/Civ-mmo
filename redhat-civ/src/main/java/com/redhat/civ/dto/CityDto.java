package com.redhat.civ.dto;

import java.lang.String;
import java.util.List;

public class CityDto {

	public String name; 
	public long id;
	public int range;
	public int food;
	public int production;
	public int gold;
	public int science;
	public int culture;
	public int hitPoints;
	public int citizens;
	public TileDto center;
	public CivilizationDto ownedBy;
	public BuildingDto currentlyConstructedBuilding;
	public List<BuildingDto> constructedBuildings;
	public List<BuildingDto> workedBuildings;
	public List<TradeRouteDto> tradeRoutesFrom;
	public List<TradeRouteDto> tradeRoutesTo;
	public List<TileDto> visibleTiles;
	public List<TileDto> controledTiles;
	public List<TileDto> workedTiles;
	public BuildingDto currentlyConstructedUnit;
}
