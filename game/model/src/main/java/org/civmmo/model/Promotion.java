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
public abstract class Promotion {

    public Promotion() {
        super();
    }

    public abstract long getId();

    public abstract void setId(long id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract List<UnitType> getAffectedBy();

    public abstract void setAffectedBy(List<UnitType> affectedBy);

    public abstract List<Unit> getUnits();

    public abstract void setUnits(List<Unit> units);

    public abstract List<Technology> getPrerequisities();

    public abstract void setPrerequisities(List<Technology> prerequisities);
    
}
