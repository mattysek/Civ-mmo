package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.UnitTypeRepository;
import org.civmmo.model.UnitType;
import org.civmmo.persistence.model.UnitTypeNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class UnitTypeRepositoryImpl extends BaseRepositoryImpl<UnitType> implements UnitTypeRepository {

    public UnitTypeRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected UnitType translate(Node node) {
        return new UnitTypeNode(node);
    }

    @Override
    protected void deleteObject(UnitType object) {
        ((UnitTypeNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(UnitType object) {
        Node node = ((UnitTypeNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }

}
