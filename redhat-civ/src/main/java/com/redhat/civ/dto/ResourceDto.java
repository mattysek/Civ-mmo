package com.redhat.civ.dto;

import java.lang.String;
import java.util.List;

public class ResourceDto {

	public long id;
	public String name;
	public int food;
	public int production;
	public int gold;
	public float happiness;
	public ImprovementDto improvement;
	public ResourceDto revealedBy;
	public List<BuildingDto> requiredByBuildings;
	public List<UnitDto> requiredByUnits;
	public List<TileDto> canBeFoundOnTiles;
}
