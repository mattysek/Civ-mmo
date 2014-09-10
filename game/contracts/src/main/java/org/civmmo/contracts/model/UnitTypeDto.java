package org.civmmo.contracts.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

public class UnitTypeDto implements Serializable {

	private long id;
	private String name;
	
        private List<ActionDto> actions;
	private List<UnitDto> units;
	private PromotionDto affectedPromotion;
	
	private static final long serialVersionUID = 1L;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public List<UnitDto> getUnits() {
		return units;
	}
	public void setUnits(List<UnitDto> units) {
		this.units = units;
	}
	public PromotionDto getAffectedPromotion() {
		return affectedPromotion;
	}
	public void setAffectedPromotion(PromotionDto affectedPromotion) {
		this.affectedPromotion = affectedPromotion;
	}
        public List<ActionDto> getActions() {
		return actions;
	}
	public void setActions(List<ActionDto> actions) {
		this.actions = actions;
	}
}
