package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.CityRepository;
import org.civmmo.model.City;
import org.civmmo.persistence.model.CityEntity;

public class CityRepositoryImpl extends BaseRepositoryImpl<City> implements CityRepository {
    @Override
    protected Class<? extends City> getPersistentClass() {
        return CityEntity.class;
    }
}
