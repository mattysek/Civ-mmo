package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.PromotionRepository;
import org.civmmo.model.Promotion;
import org.civmmo.persistence.model.PromotionEntity;

public class PromotionRepositoryImpl extends BaseRepositoryImpl<Promotion> implements PromotionRepository {
    @Override
    protected Class<? extends Promotion> getPersistentClass() {
        return PromotionEntity.class;
    }
}
