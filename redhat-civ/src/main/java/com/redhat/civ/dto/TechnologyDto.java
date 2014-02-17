package com.redhat.civ.dto;

import java.lang.String;
import java.util.List;

public class TechnologyDto {

	public long id;
	public String name;
	public long cost;
	public List<ResourceDto> revealsResources;
	public List<BuildingDto> revealsBuildings;
	public List<UnitDto> revealsUnits;
	public List<TechnologyDto> prerequisities;
	public List<CivilizationDto> knownBy;
}
