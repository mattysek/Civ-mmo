package com.redhat.civ.dto;

import java.lang.String;
import java.util.List;

public class TerrainFeatureDto {

	public long id;
	public String name;
	public int food;
	public int production;
	public int gold;
	public int movementCost;
	public CombatModifierDto combatModifier;
	public List<TileDto> ofTiles;
}
