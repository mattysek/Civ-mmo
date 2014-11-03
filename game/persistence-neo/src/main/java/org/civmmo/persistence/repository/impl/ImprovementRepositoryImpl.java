package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.ImprovementRepository;
import org.civmmo.model.Improvement;
import org.civmmo.persistence.model.ImprovementNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class ImprovementRepositoryImpl extends BaseRepositoryImpl<Improvement> implements ImprovementRepository {

    public ImprovementRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected Improvement translate(Node node) {
        return new ImprovementNode(node);
    }

    @Override
    protected void deleteObject(Improvement object) {
        ((ImprovementNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(Improvement object) {
        Node node = ((ImprovementNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }

}
