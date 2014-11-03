package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.ActionRepository;
import org.civmmo.model.Action;
import org.civmmo.persistence.model.ActionNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class ActionRepositoryImpl extends BaseRepositoryImpl<Action> implements ActionRepository {

    public ActionRepositoryImpl(GraphDatabaseService graphDb)
    {
        super(graphDb);
    }

    @Override
    protected Action translate(Node node) {
        return new ActionNode(node);
    }

    @Override
    protected void deleteObject(Action object) {
        ((ActionNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(Action object) {
        Node node = ((ActionNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }

}
