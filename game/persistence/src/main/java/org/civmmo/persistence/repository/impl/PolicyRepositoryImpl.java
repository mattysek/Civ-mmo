package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.PolicyRepository;
import org.civmmo.model.Policy;
import org.civmmo.persistence.model.PolicyEntity;

public class PolicyRepositoryImpl extends BaseRepositoryImpl<Policy> implements PolicyRepository {
    @Override
    protected Class<? extends Policy> getPersistentClass() {
        return PolicyEntity.class;
    }
}
