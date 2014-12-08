package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.TerrainFeatureRepository;
import org.civmmo.model.TerrainFeature;
import org.civmmo.persistence.model.TerrainFeatureEntity;

public class TerrainFeatureRepositoryImpl extends BaseRepositoryImpl<TerrainFeature> implements TerrainFeatureRepository {
@Override
    protected Class<? extends TerrainFeature> getPersistentClass() {
        return TerrainFeatureEntity.class;
    }
}
