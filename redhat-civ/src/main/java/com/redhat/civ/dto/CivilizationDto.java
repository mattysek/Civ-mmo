package com.redhat.civ.dto;

import java.lang.String;
import java.util.List;

public class CivilizationDto {

	public long id;
	public String name;
	public long gold;
	public long culture;
	public long science;
	public float happiness;
	public SocialPolicyDto currentPolicy;
	public TechnologyDto currentlyStudiedTechnology;
	public List<CivilizationDto> enemies;
	public List<CivilizationDto> allies;
	public List<SocialPolicyDto> availableSocialPolicies;
	public List<PolicyDto> unlockedPolicies;
	public List<TechnologyDto> knownTechnologies;
	public List<CityDto> cities;
	public List<UnitDto> units;
}
