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
public abstract class Building {

    public Building() {
        super();
    }

    public abstract long getId();

    public abstract void setId(long id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract int getCost();

    public abstract void setCost(int cost);

    public abstract int getMaintenence();

    public abstract void setMaintenence(int maintenence);

    public abstract int getSpecialistsSlots();

    public abstract void setSpecialistsSlots(int specialistsSlots);

    public abstract List<Technology> getRequiredTechnologies();

    public abstract void setRequiredTechnologies(List<Technology> requiredTechnologies);

    public abstract List<Resource> getRequiredResources();

    public abstract void setRequiredResources(List<Resource> requiredResources);

    public abstract List<City> getWorkedBy();

    public abstract void setWorkedBy(List<City> workedBy);

    public abstract List<City> getCurrentlyConstructedBy();

    public abstract void setCurrentlyConstructedBy(List<City> currentlyConstructedBy);
    
}
