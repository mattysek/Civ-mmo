package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.PolicyRepository;
import org.civmmo.model.Policy;
import org.civmmo.persistence.model.PolicyNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class PolicyRepositoryImpl extends BaseRepositoryImpl<Policy> implements PolicyRepository {

    public PolicyRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected Policy translate(Node node) {
        return new PolicyNode(node);
    }

    @Override
    protected void deleteObject(Policy object) {
        ((PolicyNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(Policy object) {
        Node node = ((PolicyNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }
}
