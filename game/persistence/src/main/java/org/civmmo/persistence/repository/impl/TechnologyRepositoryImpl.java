package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.TechnologyRepository;
import org.civmmo.model.Technology;
import org.civmmo.persistence.model.TechnologyEntity;

public class TechnologyRepositoryImpl extends BaseRepositoryImpl<Technology> implements TechnologyRepository {
@Override
    protected Class<? extends Technology> getPersistentClass() {
        return TechnologyEntity.class;
    }
}
