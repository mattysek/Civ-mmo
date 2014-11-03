package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.UnitRepository;
import org.civmmo.model.Unit;
import org.civmmo.persistence.model.UnitNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class UnitRepositoryImpl extends BaseRepositoryImpl<Unit> implements UnitRepository {

    public UnitRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected Unit translate(Node node) {
        return new UnitNode(node);
    }

    @Override
    protected void deleteObject(Unit object) {
        ((UnitNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(Unit object) {
        Node node = ((UnitNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }

}
