package org.civmmo.persistence.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.civmmo.persistence.repository.TileRepository;
import org.civmmo.model.Tile;
import org.civmmo.persistence.model.TileNode;
import org.civmmo.persistence.model.neospecific.RelationshipType;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterable;

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

    @Override
    public List<Tile> getUnusedTilesOfRegion(long regionId) {
        ResourceIterable<Node> result = graphDb.findNodesByLabelAndProperty(DynamicLabel.label("Region"), "id", regionId);
        Optional<Node> node = StreamSupport.stream(result.spliterator(), true).findFirst();
        if(node.isPresent())
        {
            return StreamSupport.stream(node.get().getRelationships(RelationshipType.REGION_TILE)
                                     .spliterator(), true)
                         .filter(t -> !t.getOtherNode(node.get()).hasRelationship(RelationshipType.CITY_TILE))
                         .map(t -> (TileNode)t.getOtherNode(node.get()))
                         .collect(Collectors.toList());
        }
        
        return new ArrayList();
    }

    @Override
    public List<Tile> getvisibleTilesOfRegionforCiv(long regionId, long civId) {
        ResourceIterable<Node> result = graphDb.findNodesByLabelAndProperty(DynamicLabel.label("Region"), "id", regionId);
        Optional<Node> node = StreamSupport.stream(result.spliterator(), true).findFirst();
        Optional<Node> civNode = StreamSupport.stream(graphDb.findNodesByLabelAndProperty(DynamicLabel.label("Civilization"), "id", civId).spliterator(), true).findFirst();
        if(node.isPresent())
        {
            return StreamSupport.stream(node.get().getRelationships(RelationshipType.REGION_TILE)
                                     .spliterator(), true)
                         .filter(t -> t.getOtherNode(node.get()).hasRelationship(RelationshipType.CITY_TILE_2, RelationshipType.TILE_UNIT_2))
//                         .filter(t ->  StreamSupport.stream(t.getOtherNode(node.get()).getRelationships(RelationshipType.CITY_TILE_2, RelationshipType.TILE_UNIT_2)
//                                                                .spliterator(),true)
//                                                    .filter(x -> x.getOtherNode(t.getOtherNode(node.get()).getRe)))
                         .map(t -> (TileNode)t.getOtherNode(node.get()))
                         .collect(Collectors.toList());
        }
        
        return new ArrayList();
    }

}
