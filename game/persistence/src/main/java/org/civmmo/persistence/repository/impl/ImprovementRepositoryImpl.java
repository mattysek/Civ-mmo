package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.ImprovementRepository;
import org.civmmo.model.Improvement;
import org.civmmo.persistence.model.ImprovementEntity;

public class ImprovementRepositoryImpl extends BaseRepositoryImpl<Improvement> implements ImprovementRepository {
    @Override
    protected Class<? extends Improvement> getPersistentClass() {
        return ImprovementEntity.class;
    }
}
