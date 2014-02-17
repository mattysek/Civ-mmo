package com.redhat.civ.dto;

import java.lang.String;
import java.util.List;

public class UnitTypeDto {

	public long id;
	public String name;
	public List<UnitDto> units;
	public PromotionDto affectedPromotion;
}
