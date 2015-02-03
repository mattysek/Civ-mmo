package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import uk.co.jemos.podam.common.PodamConstructor;

/**
 * Entity implementation class for Entity: CombatModifier
 *
 */
public class CombatModifierImpl extends CombatModifier implements Serializable {

	private long id;
	private double value;
	
	private ActionImpl afectedAction;
	
	private static final long serialVersionUID = 1L;

	public CombatModifierImpl() {
		super();
	}   
    
    public CombatModifierImpl(long id, double value, ActionImpl afectedAction) {
        this.id = id;
        this.value = value;
        this.afectedAction = afectedAction;
    }
        
        
        
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	public Action getAfectedAction() {
		return afectedAction;
	}
	public void setAfectedAction(Action afectedAction) {
		this.afectedAction = (ActionImpl)afectedAction;
	}
}
