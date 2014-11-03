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
public abstract class Policy {

    public Policy() {
        super();
    }

    public abstract long getId();

    public abstract void setId(long Id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract int getCost();

    public abstract void setCost(int cost);

    public abstract SocialPolicy getSocialPolicy();

    public abstract void setSocialPolicy(SocialPolicy socialPolicy);
    
}
