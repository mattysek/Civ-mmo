/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mattysek
 */
public abstract class Unit {

    public Unit() {
        super();
    }

    public abstract long getId();

    public abstract void setId(long id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract int getCost();

    public abstract void setCost(int cost);

    public abstract int getMovementPoints();

    public abstract void setMovementPoints(int movementPoints);

    public abstract int getCombatStrength();

    public abstract void setCombatStrength(int combatStrength);

    public abstract int getRangedCombatStrength();

    public abstract void setRangedCombatStrength(int rangedCombatStrength);

    public abstract int getRange();

    public abstract void setRange(int range);

    public abstract int getHitPoints();

    public abstract void setHitPoints(int hitPoints);

    public abstract int getExperience();

    public abstract void setExperience(int experience);

    public abstract Tile getPosition();

    public abstract void setPosition(Tile position);

    public abstract List<UnitType> getTypes();

    public abstract void setTypes(List<UnitType> types);

    public abstract List<Promotion> getPromotions();

    public abstract void setPromotions(List<Promotion> promotions);

    public abstract List<City> getCurrentlyConstructedBy();

    public abstract void setCurrentlyConstructedBy(List<City> currentlyConstructedBy);

    public abstract Civilization getOwnedBy();

    public abstract void setOwnedBy(Civilization ownedBy);

    public abstract List<Tile> getVisibleTiles();

    public abstract void setVisibleTiles(List<Tile> visibleTiles);

    public abstract List<Tile> getControledTiles();

    public abstract void setControledTiles(List<Tile> controledTiles);

    public void attackUnit(Unit unit) {
        unit.setHitPoints(unit.getHitPoints() - this.getCombatStrength());
    }

    public void attackCity(City city) {
        city.setHitPoints(city.getHitPoints() - this.getCombatStrength());
    }

    public void promoteUnit(Promotion promotion) {
        if (this.getPromotions() == null) {
            this.setPromotions(new ArrayList<>());
        }
        this.getPromotions().add(promotion);
    }

    public void moveUnit(Tile tile) {
        this.setPosition(tile);
    }
    
}
