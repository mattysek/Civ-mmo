package org.civmmo.persistence.repository.impl;

import java.util.List;
import org.civmmo.persistence.repository.ActionRepository;
import org.civmmo.model.Action;
import org.civmmo.persistence.model.ActionEntity;

public class ActionRepositoryImpl extends BaseRepositoryImpl<Action> implements ActionRepository {

    @Override
    protected Class<? extends Action> getPersistentClass() {
        return ActionEntity.class;
    }
    
}
