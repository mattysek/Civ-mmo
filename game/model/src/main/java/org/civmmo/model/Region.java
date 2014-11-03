/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Mattysek
 */
public abstract class Region {

    public abstract List<Tile> getTiles();

    public abstract void setTiles(List<Tile> tiles);

    public abstract long getId();

    public abstract void setId(long id);

    public void generateNewRegion(long x, long y, List<TerrainType> types, List<TerrainFeature> features, List<Resource> resources) {
        Random random = new Random();
        if (this.getTiles() == null) {
            this.setTiles(new ArrayList());
        }
        for (long i = x + 1; i <= x + 100; i++) {
            for (long j = y + 1; j <= y + 100; j++) {
                Tile tile = createNewTile();
                tile.setX(i);
                tile.setY(j);
                tile.setTerrainType(types.get(random.nextInt(types.size())));
                tile.setTerrainFeature(features.get(random.nextInt(features.size())));
                tile.setResource(resources.get(random.nextInt(resources.size())));
                this.getTiles().add(tile);
            }
        }
    }
    
    protected abstract Tile createNewTile();
}
