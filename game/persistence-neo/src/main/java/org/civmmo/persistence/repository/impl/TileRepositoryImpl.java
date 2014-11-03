package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.TileRepository;
import org.civmmo.model.Tile;
import org.civmmo.persistence.model.TileNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class TileRepositoryImpl extends BaseRepositoryImpl<Tile> implements TileRepository {

    public TileRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected Tile translate(Node node) {
        return new TileNode(node);
    }

    @Override
    protected void deleteObject(Tile object) {
        ((TileNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(Tile object) {
        Node node = ((TileNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }

}
