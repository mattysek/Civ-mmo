/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.model;

import java.util.List;

/**
 *
 * @author Mattysek
 */
public abstract class Action {

    public Action() {
        super();
    }

    public abstract long getId();

    public abstract void setId(long id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract List<CombatModifier> getCombatModifiers();

    public abstract void setCombatModifiers(List<CombatModifier> combatModifiers);

    public abstract List<UnitType> getAplicableTo();

    public abstract void setAplicableTo(List<UnitType> aplicableTo);
    
}
