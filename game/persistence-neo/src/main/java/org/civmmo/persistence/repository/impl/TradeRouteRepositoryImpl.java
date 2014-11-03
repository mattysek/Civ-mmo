package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.TradeRouteRepository;
import org.civmmo.model.TradeRoute;
import org.civmmo.persistence.model.TradeRouteNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class TradeRouteRepositoryImpl extends BaseRepositoryImpl<TradeRoute> implements TradeRouteRepository {

    public TradeRouteRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected TradeRoute translate(Node node) {
        return new TradeRouteNode(node);
    }

    @Override
    protected void deleteObject(TradeRoute object) {
        ((TradeRouteNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(TradeRoute object) {
        Node node = ((TradeRouteNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }

}
