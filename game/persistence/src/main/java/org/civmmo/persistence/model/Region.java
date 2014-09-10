package org.civmmo.persistence.model;

import java.io.Serializable;
import java.util.List;
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
public class Region implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy="region", cascade = CascadeType.ALL)
    private List<Tile> tiles;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Region other = (Region) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }
    
    private static final long serialVersionUID = 1L;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
