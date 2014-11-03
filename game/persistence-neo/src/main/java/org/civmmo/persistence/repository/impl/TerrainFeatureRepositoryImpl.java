package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.TerrainFeatureRepository;
import org.civmmo.model.TerrainFeature;
import org.civmmo.persistence.model.TerrainFeatureNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class TerrainFeatureRepositoryImpl extends BaseRepositoryImpl<TerrainFeature> implements TerrainFeatureRepository {

    public TerrainFeatureRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected TerrainFeature translate(Node node) {
        return new TerrainFeatureNode(node);
    }

    @Override
    protected void deleteObject(TerrainFeature object) {
        ((TerrainFeatureNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(TerrainFeature object) {
        Node node = ((TerrainFeatureNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }

}
