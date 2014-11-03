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
public abstract class TradeRoute {

    public TradeRoute() {
        super();
    }

    public abstract long getId();

    public abstract void setId(long id);

    public abstract City getFrom();

    public abstract void setFrom(City from);

    public abstract City getTo();

    public abstract void setTo(City to);

    public abstract List<Tile> getTiles();

    public abstract void setTiles(List<Tile> tiles);
    
}
