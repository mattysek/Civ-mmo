package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.BuildingRepository;
import org.civmmo.model.Building;
import org.civmmo.persistence.model.BuildingNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class BuildingRepositoryImpl extends BaseRepositoryImpl<Building> implements BuildingRepository {

    public BuildingRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected Building translate(Node node) {
        return new BuildingNode(node);
    }

    @Override
    protected void deleteObject(Building object) {
        ((BuildingNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(Building object) {
        Node node = ((BuildingNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }
	
}
