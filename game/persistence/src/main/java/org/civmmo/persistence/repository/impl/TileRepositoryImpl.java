package org.civmmo.persistence.repository.impl;

import java.util.List;
import javax.persistence.Query;
import org.civmmo.persistence.repository.TileRepository;
import org.civmmo.model.Tile;
import org.civmmo.persistence.model.TileEntity;

public class TileRepositoryImpl extends BaseRepositoryImpl<Tile> implements TileRepository {
@Override
    protected Class<? extends Tile> getPersistentClass() {
        return TileEntity.class;
    }

    @Override
    public List<Tile> getUnusedTilesOfRegion(long regionId) {
        Query q = getEntityManager().createQuery("SELECT o FROM " +
                getPersistentClass().getSimpleName() + " o JOIN o.region r WHERE r.id = " + regionId + " AND o.center = NULL");
        return (List<Tile>) q.getResultList();
    }

    @Override
    public List<Tile> getvisibleTilesOfRegionforCiv(long regionId, long civId) {
        String citiesOfCiv = "SELECT city FROM City city JOIN city.ownedBy civ WHERE civ.id = " + civId;
        String unitsOfCiv = "SELECT unit FROM Unit unit JOIN unit.ownedBy civ WHERE civ.id = " + civId;
        
        Query q = getEntityManager().createQuery("SELECT o FROM " +
                getPersistentClass().getSimpleName() + " o JOIN o.region r WHERE r.id = " + regionId + " JOIN o.visibleForCities c WHERE c.id IN (" + citiesOfCiv + ") JOIN o.visibleForUnits u WHERE u IN (" + unitsOfCiv + ")");
        return (List<Tile>) q.getResultList();
    }
}
