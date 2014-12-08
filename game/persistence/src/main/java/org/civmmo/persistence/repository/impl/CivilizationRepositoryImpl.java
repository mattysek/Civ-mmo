package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.CivilizationRepository;
import org.civmmo.model.Civilization;
import org.civmmo.persistence.model.CivilizationEntity;

public class CivilizationRepositoryImpl extends BaseRepositoryImpl<Civilization> implements CivilizationRepository {
    @Override
    protected Class<? extends Civilization> getPersistentClass() {
        return CivilizationEntity.class;
    }
}
