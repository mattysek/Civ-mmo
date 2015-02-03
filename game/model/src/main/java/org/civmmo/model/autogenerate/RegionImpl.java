package org.civmmo.model.autogenerate;

import org.civmmo.model.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mattysek
 */
public class RegionImpl extends Region implements Serializable {
    
    private long id;
    private List<TileImpl> tiles;

    public List<Tile> getTiles() {
        return new ArrayList<>(tiles);
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = (List<TileImpl>)(List<?>)tiles;
    }
    
    private static final long serialVersionUID = 1L;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    protected Tile createNewTile() {
        return new TileImpl();
    }

}
