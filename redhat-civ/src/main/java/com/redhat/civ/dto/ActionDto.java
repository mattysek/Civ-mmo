package com.redhat.civ.dto;

import java.util.List;

public class ActionDto {

	public long id;
	public String name;
	public List<CombatModifierDto> combatModifiers;
	public List<UnitDto> aplicableTo;  
}
