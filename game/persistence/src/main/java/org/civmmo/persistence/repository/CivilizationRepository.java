package org.civmmo.persistence.repository;

import org.civmmo.model.Civilization;

public interface CivilizationRepository extends BaseRepository<Civilization>{
    
    Civilization getByCityId(long cityId);
}
