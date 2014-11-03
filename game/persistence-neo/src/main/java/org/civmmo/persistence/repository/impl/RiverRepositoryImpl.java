package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.RiverRepository;
import org.civmmo.model.River;
import org.civmmo.persistence.model.RiverNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class RiverRepositoryImpl extends BaseRepositoryImpl<River> implements RiverRepository {

    public RiverRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected River translate(Node node) {
        return new RiverNode(node);
    }

    @Override
    protected void deleteObject(River object) {
        ((RiverNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(River object) {
        Node node = ((RiverNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }

}
