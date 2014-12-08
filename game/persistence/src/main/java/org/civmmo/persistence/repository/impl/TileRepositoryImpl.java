package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.TileRepository;
import org.civmmo.model.Tile;
import org.civmmo.persistence.model.TileEntity;

public class TileRepositoryImpl extends BaseRepositoryImpl<Tile> implements TileRepository {
@Override
    protected Class<? extends Tile> getPersistentClass() {
        return TileEntity.class;
    }
}
