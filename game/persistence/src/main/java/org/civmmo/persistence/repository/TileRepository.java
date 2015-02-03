package org.civmmo.persistence.repository;

import java.util.List;
import org.civmmo.model.Tile;

public interface TileRepository extends BaseRepository<Tile> {

    List<Tile> getUnusedTilesOfRegion(long regionId);
    List<Tile> getvisibleTilesOfRegionforCiv(long regionId, long civId);
}
