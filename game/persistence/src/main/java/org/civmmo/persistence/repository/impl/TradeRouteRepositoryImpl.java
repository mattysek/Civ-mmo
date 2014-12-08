package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.TradeRouteRepository;
import org.civmmo.model.TradeRoute;
import org.civmmo.persistence.model.TradeRouteEntity;

public class TradeRouteRepositoryImpl extends BaseRepositoryImpl<TradeRoute> implements TradeRouteRepository {
@Override
    protected Class<? extends TradeRoute> getPersistentClass() {
        return TradeRouteEntity.class;
    }
}
