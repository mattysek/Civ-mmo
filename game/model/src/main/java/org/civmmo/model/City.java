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
public abstract class City {

    public City() {
        super();
    }

    public abstract String getName();

    public abstract void setName(String name);

    public abstract long getId();

    public abstract void setId(long id);

    public abstract int getRange();

    public abstract void setRange(int range);

    public abstract int getFood();

    public abstract void setFood(int food);

    public abstract int getProduction();

    public abstract void setProduction(int production);

    public abstract int getGold();

    public abstract void setGold(int gold);

    public abstract int getScience();

    public abstract void setScience(int science);

    public abstract int getCulture();

    public abstract void setCulture(int culture);

    public abstract int getHitPoints();

    public abstract void setHitPoints(int hitPoints);

    public abstract int getCitizens();

    public abstract void setCitizens(int citizens);

    public abstract Tile getCenter();

    public abstract void setCenter(Tile center);

    public abstract Civilization getOwnedBy();

    public abstract void setOwnedBy(Civilization ownedBy);

    public abstract Building getCurrentlyConstructedBuilding();

    public abstract void setCurrentlyConstructedBuilding(Building currentlyConstructedBuilding);

    public abstract List<Unit> getAttackedBy();

    public abstract void setAttackedBy(List<Unit> units);
    
    public abstract List<Building> getConstructedBuildings();

    public abstract void setConstructedBuildings(List<Building> constructedBuildings);

    public abstract List<Building> getWorkedBuildings();

    public abstract void setWorkedBuildings(List<Building> workedBuildings);

    public abstract List<TradeRoute> getTradeRoutesFrom();

    public abstract void setTradeRoutesFrom(List<TradeRoute> tradeRoutesFrom);

    public abstract List<TradeRoute> getTradeRoutesTo();

    public abstract void setTradeRoutesTo(List<TradeRoute> tradeRoutesTo);

    public abstract List<Tile> getVisibleTiles();

    public abstract void setVisibleTiles(List<Tile> visibleTiles);

    public abstract List<Tile> getControledTiles();

    public abstract void setControledTiles(List<Tile> controledTiles);

    public abstract List<Tile> getWorkedTiles();

    public abstract void setWorkedTiles(List<Tile> workedTiles);

    public abstract Unit getCurrentlyConstructedUnit();

    public abstract void setCurrentlyConstructedUnit(Unit currentlyConstructedUnit);

    public void constructBuilding(Building building) {
        if (this.getConstructedBuildings() == null) {
            this.setConstructedBuildings(new ArrayList());
        }
        this.getConstructedBuildings().add(building);
    }

    public void workBuilding(Building building) {
        if (this.getWorkedBuildings() == null) {
            this.setWorkedBuildings(new ArrayList());
        }
        this.getWorkedBuildings().add(building);
    }

    public void constructUnit(Unit unit) {
        this.setCurrentlyConstructedUnit(unit);
    }

    public boolean hasTradeRouteWith(City city) {
        if (this.getTradeRoutesTo() == null) {
            return false;
        }
        return this.getTradeRoutesTo().stream().anyMatch((TradeRoute t) -> t.getFrom().equals(city));
    }

    public void controlTile(Tile tile) {
        if (this.getControledTiles() == null) {
            this.setControledTiles(new ArrayList());
        }
        this.getControledTiles().add(tile);
    }

    public void workTile(Tile tile) {
        if (this.getWorkedTiles() == null) {
            this.setWorkedTiles(new ArrayList<>());
        }
        this.getWorkedTiles().add(tile);
    }

    public void attackUnit(Unit unit) {
        unit.setHitPoints(unit.getHitPoints() - this.getCitizens());
    }
    
    public void getAttackedByUnit(Unit unit) {
        this.setHitPoints(this.getHitPoints() - unit.getCombatStrength());
    }

    public void computeWealthGrowth() {
        this.setFood(this.getControledTiles().stream().mapToInt((Tile t) -> t.getTerrainFeature().getFood() + t.getTerrainType().getFood()).sum());
        this.setGold(this.getControledTiles().stream().mapToInt((Tile t) -> t.getTerrainFeature().getGold() + t.getTerrainType().getGold()).sum());
        this.setProduction(this.getControledTiles().stream().mapToInt((Tile t) -> t.getTerrainFeature().getProduction() + t.getTerrainType().getProduction()).sum());
    }
    
}
