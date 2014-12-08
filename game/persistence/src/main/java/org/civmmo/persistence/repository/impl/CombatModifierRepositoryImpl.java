package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.CombatModifierRepository;
import org.civmmo.model.CombatModifier;
import org.civmmo.persistence.model.CombatModifierEntity;

public class CombatModifierRepositoryImpl extends BaseRepositoryImpl<CombatModifier> implements CombatModifierRepository{
    @Override
    protected Class<? extends CombatModifier> getPersistentClass() {
        return CombatModifierEntity.class;
    }
}
