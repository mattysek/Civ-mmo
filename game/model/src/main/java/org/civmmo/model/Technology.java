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
public abstract class Technology {

    public Technology() {
        super();
    }

    public abstract String getName();

    public abstract void setName(String name);

    public abstract long getCost();

    public abstract void setCost(long cost);

    public abstract long getId();

    public abstract void setId(long id);

    public abstract List<Resource> getRevealsResources();

    public abstract void setRevealsResources(List<Resource> revealsResources);

    public abstract List<Building> getRevealsBuildings();

    public abstract void setRevealsBuildings(List<Building> revealsBuildings);

    public abstract List<UnitType> getRevealsUnits();

    public abstract void setRevealsUnits(List<UnitType> revealsUnits);

    public abstract List<Technology> getPrerequisities();

    public abstract void setPrerequisities(List<Technology> prerequisities);

    public abstract List<Civilization> getKnownBy();

    public abstract void setKnownBy(List<Civilization> knownBy);
    
}
