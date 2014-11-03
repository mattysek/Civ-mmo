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
public abstract class Resource {

    public Resource() {
        super();
    }

    public abstract long getId();

    public abstract void setId(long id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract int getFood();

    public abstract void setFood(int food);

    public abstract int getProduction();

    public abstract void setProduction(int production);

    public abstract int getGold();

    public abstract void setGold(int gold);

    public abstract double getHappiness();

    public abstract void setHappiness(double happiness);

    public abstract Improvement getImprovement();

    public abstract void setImprovement(Improvement improvement);

    public abstract Technology getRevealedBy();

    public abstract void setRevealedBy(Technology revealedBy);

    public abstract List<Building> getRequiredByBuildings();

    public abstract void setRequiredByBuildings(List<Building> requiredByBuildings);

    public abstract List<Unit> getRequiredByUnits();

    public abstract void setRequiredByUnits(List<Unit> requiredByUnits);

    public abstract List<Tile> getCanBeFoundOnTiles();

    public abstract void setCanBeFoundOnTiles(List<Tile> canBeFoundOnTiles);
    
}
