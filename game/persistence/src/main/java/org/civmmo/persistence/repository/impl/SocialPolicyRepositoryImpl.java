package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.SocialPolicyRepository;
import org.civmmo.model.SocialPolicy;
import org.civmmo.persistence.model.SocialPolicyEntity;

public class SocialPolicyRepositoryImpl extends BaseRepositoryImpl<SocialPolicy> implements SocialPolicyRepository {
@Override
    protected Class<? extends SocialPolicy> getPersistentClass() {
        return SocialPolicyEntity.class;
    }
}
