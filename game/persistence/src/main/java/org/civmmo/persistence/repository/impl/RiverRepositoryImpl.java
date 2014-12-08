package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.RiverRepository;
import org.civmmo.model.River;
import org.civmmo.persistence.model.RiverEntity;

public class RiverRepositoryImpl extends BaseRepositoryImpl<River> implements RiverRepository {
@Override
    protected Class<? extends River> getPersistentClass() {
        return RiverEntity.class;
    }
}
