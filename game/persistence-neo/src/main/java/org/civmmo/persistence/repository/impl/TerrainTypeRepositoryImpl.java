package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.TerrainTypeRepository;
import org.civmmo.model.TerrainType;
import org.civmmo.persistence.model.TerrainTypeNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class TerrainTypeRepositoryImpl extends BaseRepositoryImpl<TerrainType> implements TerrainTypeRepository {

    public TerrainTypeRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected TerrainType translate(Node node) {
        return new TerrainTypeNode(node);
    }

    @Override
    protected void deleteObject(TerrainType object) {
        ((TerrainTypeNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(TerrainType object) {
        Node node = ((TerrainTypeNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }
	
}
