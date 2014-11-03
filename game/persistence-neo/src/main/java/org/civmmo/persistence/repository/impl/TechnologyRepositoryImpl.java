package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.TechnologyRepository;
import org.civmmo.model.Technology;
import org.civmmo.persistence.model.TechnologyNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class TechnologyRepositoryImpl extends BaseRepositoryImpl<Technology> implements TechnologyRepository {

    public TechnologyRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected Technology translate(Node node) {
        return new TechnologyNode(node);
    }

    @Override
    protected void deleteObject(Technology object) {
        ((TechnologyNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(Technology object) {
        Node node = ((TechnologyNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }

}
