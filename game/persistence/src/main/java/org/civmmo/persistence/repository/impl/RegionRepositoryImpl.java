package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.RegionRepository;
import org.civmmo.model.Region;
import org.civmmo.persistence.model.RegionEntity;

public class RegionRepositoryImpl extends BaseRepositoryImpl<Region> implements RegionRepository {
    @Override
    protected Class<? extends Region> getPersistentClass() {
        return RegionEntity.class;
    }
}