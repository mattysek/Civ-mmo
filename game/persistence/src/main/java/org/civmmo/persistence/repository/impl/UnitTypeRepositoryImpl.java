package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.UnitTypeRepository;
import org.civmmo.model.UnitType;
import org.civmmo.persistence.model.UnitTypeEntity;

public class UnitTypeRepositoryImpl extends BaseRepositoryImpl<UnitType> implements UnitTypeRepository {
@Override
    protected Class<? extends UnitType> getPersistentClass() {
        return UnitTypeEntity.class;
    }
}
