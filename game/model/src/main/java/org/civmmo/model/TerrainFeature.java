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
public abstract class TerrainFeature {

    public TerrainFeature() {
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

    public abstract int getMovementCost();

    public abstract void setMovementCost(int movementCost);

    public abstract CombatModifier getCombatModifier();

    public abstract void setCombatModifier(CombatModifier combatModifier);

    public abstract List<Tile> getOfTiles();

    public abstract void setOfTiles(List<Tile> ofTiles);
    
}
