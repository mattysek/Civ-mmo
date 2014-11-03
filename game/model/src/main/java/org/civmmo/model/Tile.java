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
public abstract class Tile {

    public Tile() {
        super();
    }

    public abstract long getId();

    public abstract void setId(long id);

    public abstract long getX();

    public abstract void setX(long x);

    public abstract long getY();

    public abstract void setY(long y);

    public abstract Region getRegion();

    public abstract void setRegion(Region region);

    public abstract City getCity();

    public abstract void setCity(City city);

    public abstract Unit getMilitaryUnit();

    public abstract void setMilitaryUnit(Unit militaryUnit);

    public abstract Unit getCivilUnit();

    public abstract void setCivilUnit(Unit civilUnit);

    public abstract TerrainFeature getTerrainFeature();

    public abstract void setTerrainFeature(TerrainFeature terrainFeature);

    public abstract TerrainType getTerrainType();

    public abstract void setTerrainType(TerrainType terrainType);

    public abstract Improvement getImprovement();

    public abstract void setImprovement(Improvement improvement);

    public abstract Resource getResource();

    public abstract void setResource(Resource resource);

    public abstract List<TradeRoute> getTradeRoutes();

    public abstract void setTradeRoutes(List<TradeRoute> tradeRoutes);

    public abstract List<River> getRivers();

    public abstract void setRivers(List<River> rivers);

    public abstract List<City> getVisibleForCities();

    public abstract void setVisibleForCities(List<City> visibleForCities);

    public abstract List<Unit> getVisibleForUnits();

    public abstract void setVisibleForUnits(List<Unit> visibleForUnits);

    public abstract List<City> getControledByCity();

    public abstract void setControledByCity(List<City> controledByCity);

    public abstract List<Unit> getControledByUnit();

    public abstract void setControledByUnit(List<Unit> controledByUnit);

    public abstract List<City> getWorkedBy();

    public abstract void setWorkedBy(List<City> workedBy);

    public boolean isRiver() {
        if(this.getRivers() == null) return false;
        return this.getRivers().size() > 0;
    }
    
}
