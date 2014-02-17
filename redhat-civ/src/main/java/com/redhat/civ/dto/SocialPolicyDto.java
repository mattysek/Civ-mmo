package com.redhat.civ.dto;

import java.lang.String;
import java.util.List;

public class SocialPolicyDto {

	public Long id;
	public String name;
	public int baseCost;
	public List<CivilizationDto> currentlyUsedBy;
	public List<PolicyDto> policies;
}
