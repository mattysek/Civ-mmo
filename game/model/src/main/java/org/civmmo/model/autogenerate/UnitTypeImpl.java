package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity implementation class for Entity: UnitType
 *
 */
public class UnitTypeImpl extends UnitType implements Serializable {

	private long id;
	private String name;
	
	private List<ActionImpl> actions;
	private List<UnitImpl> units;
	private PromotionImpl affectedPromotion;
	
	private static final long serialVersionUID = 1L;

	public UnitTypeImpl() {
		super();
	}   
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
	public List<Unit> getUnits() {
		return new ArrayList<>(units);
	}
	public void setUnits(List<Unit> units) {
		this.units = (List<UnitImpl>)(List<?>)units;
	}
	public Promotion getAffectedPromotion() {
		return affectedPromotion;
	}
	public void setAffectedPromotion(Promotion affectedPromotion) {
		this.affectedPromotion = (PromotionImpl)affectedPromotion;
	}
        public List<Action> getActions() {
		return new ArrayList<>(actions);
	}
	public void setActions(List<Action> actions) {
		this.actions = (List<ActionImpl>)(List<?>)actions;
	}
}
