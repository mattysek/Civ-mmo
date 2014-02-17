package com.redhat.civ.dto;

import java.lang.String;
import java.util.List;

public class PromotionDto {

	public long id;
	public String name;
	public List<UnitTypeDto> affectedBy;
	public List<UnitDto> units;
	public List<TechnologyDto> prerequisities;
}
