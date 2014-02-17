package com.redhat.civ.dto;

import java.lang.String;
import java.util.List;

public class UnitDto {

	public long id;
	public String name;
	public int cost;
	public int movementPoints;
	public int combatStrength;
	public int rangedCombatStrength;
	public int range;
	public int hitPoints;
	public int experience;
	public TileDto position;
	public List<ActionDto> actions;
	public List<UnitTypeDto> types;
	public List<PromotionDto> promotions;
	public List<CityDto> currentlyConstructedBy;
	public CivilizationDto ownedBy;
	public List<TileDto> visibleTiles;
	public List<TileDto> controledTiles;
}
