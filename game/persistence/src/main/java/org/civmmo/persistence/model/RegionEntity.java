package org.civmmo.persistence.model;

import org.civmmo.model.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Mattysek
 */
@Entity
@Indexed
public class RegionEntity extends Region implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy="region", cascade = CascadeType.ALL)
    private List<TileEntity> tiles;

    public List<Tile> getTiles() {
        return new ArrayList<>(tiles);
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = (List<TileEntity>)(List<?>)tiles;
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
        return new TileEntity();
    }

}
