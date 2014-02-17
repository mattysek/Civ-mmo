package com.redhat.civ.dto;

import java.lang.String;
import java.util.List;


public class BuildingDto {

	public long id;
	public String name;
	public int cost;
	public int maintenence;
	public int specialistsSlots;
	public List<TechnologyDto> requiredTechnologies;
	public List<ResourceDto> requiredResources;
	public List<CityDto> workedBy;
	public List<CityDto> currentlyConstructedBy;
}
