/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Mattysek
 */
public abstract class Civilization {

    public Civilization() {
        super();
    }

    public abstract String getName();

    public abstract void setName(String name);

    public abstract long getGold();

    public abstract void setGold(long gold);

    public abstract long getCulture();

    public abstract void setCulture(long culture);

    public abstract long getScience();

    public abstract void setScience(long science);

    public abstract double getHappiness();

    public abstract void setHappiness(double happiness);

    public abstract long getId();

    public abstract void setId(long id);

    public abstract SocialPolicy getCurrentPolicy();

    public abstract void setCurrentPolicy(SocialPolicy currentPolicy);

    public abstract Technology getCurrentlyStudiedTechnology();

    public abstract void setCurrentlyStudiedTechnology(Technology currentlyStudiedTechnology);

    public abstract List<Civilization> getEnemies();

    public abstract void setEnemies(List<Civilization> enemies);

    public abstract List<Civilization> getAllies();

    public abstract void setAllies(List<Civilization> allies);

    public abstract List<SocialPolicy> getAvailableSocialPolicies();

    public abstract void setAvailableSocialPolicies(List<SocialPolicy> availableSocialPolicies);

    public abstract List<Policy> getUnlockedPolicies();

    public abstract void setUnlockedPolicies(List<Policy> unlockedPolicies);

    public abstract List<Technology> getKnownTechnologies();

    public abstract void setKnownTechnologies(List<Technology> knownTechnologies);

    public abstract List<City> getCities();

    public abstract void setCities(List<City> cities);

    public abstract List<Unit> getUnits();

    public abstract void setUnits(List<Unit> units);

    public void unlockPolicy(Policy policy) {
        if (this.getUnlockedPolicies() == null) {
            this.setUnlockedPolicies(new ArrayList());
        }
        this.getUnlockedPolicies().add(policy);
    }

    public void useSocialPolicy(SocialPolicy socialPolicy) {
        this.setCurrentPolicy(socialPolicy);
    }

    public void ownSocialPolicy(SocialPolicy socialPolicy) {
        if (this.getAvailableSocialPolicies() == null) {
            this.setAvailableSocialPolicies(new ArrayList());
        }
        this.getAvailableSocialPolicies().add(socialPolicy);
    }

    public void declareWarBetween(Civilization civilization) {
        if (this.getEnemies() == null) {
            this.setEnemies(new ArrayList());
        }
        this.getEnemies().add(civilization);
    }

    public void declarePeaceBetween(Civilization civilization) {
        if (this.getAllies() == null) {
            this.setAllies(new ArrayList());
        }
        this.getAllies().add(civilization);
    }

    public void ownCity(City city) {
        if (this.getCities() == null) {
            this.setCities(new ArrayList());
        }
        this.getCities().add(city);
    }

    public void knowTechnology(Technology technology) {
        if (this.getKnownTechnologies() == null) {
            this.setKnownTechnologies(new ArrayList());
        }
        this.getKnownTechnologies().add(technology);
    }

    public void studyTechnology(Technology technology) {
        this.setCurrentlyStudiedTechnology(technology);
    }

    public List<Resource> getVisibleResources() {
        return this.getKnownTechnologies().stream()
                              .flatMap(t -> t.getRevealsResources().stream())
                              .collect(Collectors.toList());
    }

    public List<Tile> getVisibleTilesFromRegion(Region region) {
        List<Tile> result = this.getUnits().stream()
                                .flatMap(u -> u.getVisibleTiles().stream()
                                               .filter(t -> t.getRegion().getId() == region.getId()))
                                .collect(Collectors.toList());
        result.addAll(this.getCities().stream()
                          .flatMap(c -> c.getVisibleTiles().stream()
                                         .filter(t -> t.getRegion().getId() == region.getId()))
                          .collect(Collectors.toList()));
        return result;
    }

    public void computeWealthChange() {
        if(this.getCities() != null)
        {
            this.setGold( this.getGold() + this.getCities().stream().mapToInt((City c) -> {
                c.computeWealthGrowth();
                return c.getGold();
            }).sum());
        }
    }
    
}
