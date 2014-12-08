package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.BuildingRepository;
import org.civmmo.model.Building;
import org.civmmo.persistence.model.BuildingEntity;

public class BuildingRepositoryImpl extends BaseRepositoryImpl<Building> implements BuildingRepository {

    @Override
    protected Class<? extends Building> getPersistentClass() {
        return BuildingEntity.class;
    }
	
}
