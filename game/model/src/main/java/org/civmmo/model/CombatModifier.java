/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.model;


/**
 *
 * @author Mattysek
 */
public abstract class CombatModifier {

    public CombatModifier() {
        super();
    }

    public abstract long getId();

    public abstract void setId(long id);

    public abstract double getValue();

    public abstract void setValue(double value);

    public abstract Action getAfectedAction();

    public abstract void setAfectedAction(Action afectedAction);
    
}
