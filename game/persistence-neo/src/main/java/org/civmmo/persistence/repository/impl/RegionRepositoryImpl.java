package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.RegionRepository;
import org.civmmo.model.Region;
import org.civmmo.persistence.model.RegionNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class RegionRepositoryImpl extends BaseRepositoryImpl<Region> implements RegionRepository {

    public RegionRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected Region translate(Node node) {
        return new RegionNode(node);
    }

    @Override
    protected void deleteObject(Region object) {
        ((RegionNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(Region object) {
        Node node = ((RegionNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }

}