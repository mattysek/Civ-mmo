package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.UnitRepository;
import org.civmmo.model.Unit;
import org.civmmo.persistence.model.UnitEntity;

public class UnitRepositoryImpl extends BaseRepositoryImpl<Unit> implements UnitRepository {
@Override
    protected Class<? extends Unit> getPersistentClass() {
        return UnitEntity.class;
    }
}
