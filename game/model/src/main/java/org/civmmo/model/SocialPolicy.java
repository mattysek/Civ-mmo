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
public abstract class SocialPolicy {

    public SocialPolicy() {
        super();
    }

    public abstract String getName();

    public abstract void setName(String name);

    public abstract int getBaseCost();

    public abstract void setBaseCost(int baseCost);

    public abstract long getId();

    public abstract void setId(long id);

    public abstract List<Civilization> getCurrentlyUsedBy();

    public abstract void setCurrentlyUsedBy(List<Civilization> currentlyUsedBy);

    public abstract List<Policy> getPolicies();

    public abstract void setPolicies(List<Policy> policies);
    
}
