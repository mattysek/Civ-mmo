package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.ResourceRepository;
import org.civmmo.model.Resource;
import org.civmmo.persistence.model.ResourceEntity;

public class ResourceRepositoryImpl extends BaseRepositoryImpl<Resource> implements ResourceRepository {
	@Override
    protected Class<? extends Resource> getPersistentClass() {
        return ResourceEntity.class;
    }
}
