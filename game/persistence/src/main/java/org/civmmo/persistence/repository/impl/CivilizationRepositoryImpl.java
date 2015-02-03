package org.civmmo.persistence.repository.impl;

import java.util.List;
import javax.persistence.Query;
import org.civmmo.persistence.repository.CivilizationRepository;
import org.civmmo.model.Civilization;
import org.civmmo.persistence.model.CivilizationEntity;

public class CivilizationRepositoryImpl extends BaseRepositoryImpl<Civilization> implements CivilizationRepository {
    @Override
    protected Class<? extends Civilization> getPersistentClass() {
        return CivilizationEntity.class;
    }

    @Override
    public Civilization getByCityId(long cityId) {
        Query q = getEntityManager().createQuery("SELECT o FROM " +
                getPersistentClass().getSimpleName() + " o JOIN o.ownedBy p WHERE p IN (SELECT q FROM City WHERE City.id = " + cityId + ")");
        return (Civilization) q.getSingleResult();
    }
}
