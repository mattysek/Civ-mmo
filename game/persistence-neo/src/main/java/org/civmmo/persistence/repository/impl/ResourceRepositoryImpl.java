package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.ResourceRepository;
import org.civmmo.model.Resource;
import org.civmmo.persistence.model.ResourceNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class ResourceRepositoryImpl extends BaseRepositoryImpl<Resource> implements ResourceRepository {

    public ResourceRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected Resource translate(Node node) {
        return new ResourceNode(node);
    }

    @Override
    protected void deleteObject(Resource object) {
        ((ResourceNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(Resource object) {
        Node node = ((ResourceNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }
	
}
