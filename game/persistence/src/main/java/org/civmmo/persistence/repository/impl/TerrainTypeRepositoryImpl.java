package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.TerrainTypeRepository;
import org.civmmo.model.TerrainType;
import org.civmmo.persistence.model.TerrainTypeEntity;

public class TerrainTypeRepositoryImpl extends BaseRepositoryImpl<TerrainType> implements TerrainTypeRepository {
	@Override
    protected Class<? extends TerrainType> getPersistentClass() {
        return TerrainTypeEntity.class;
    }
}
