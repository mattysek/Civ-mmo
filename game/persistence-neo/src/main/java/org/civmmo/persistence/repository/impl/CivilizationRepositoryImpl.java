package org.civmmo.persistence.repository.impl;

import java.util.Optional;
import java.util.stream.StreamSupport;
import org.civmmo.persistence.repository.CivilizationRepository;
import org.civmmo.model.Civilization;
import org.civmmo.persistence.model.CivilizationNode;
import org.civmmo.persistence.model.neospecific.RelationshipType;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterable;

public class CivilizationRepositoryImpl extends BaseRepositoryImpl<Civilization> implements CivilizationRepository {

    public CivilizationRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected Civilization translate(Node node) {
        return new CivilizationNode(node);
    }

    @Override
    protected void deleteObject(Civilization object) {
        ((CivilizationNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(Civilization object) {
        Node node = ((CivilizationNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }

    @Override
    public Civilization getByCityId(long cityId) {
        ResourceIterable<Node> result = graphDb.findNodesByLabelAndProperty(DynamicLabel.label("City"), "id", cityId);
        Optional<Node> node = StreamSupport.stream(result.spliterator(), true).findFirst();
        if(node.isPresent())
        {
            Optional<Relationship> civNode = StreamSupport.stream(node.get().getRelationships(RelationshipType.CITY_CIVILIZATION).spliterator(), true).findFirst();
            if(civNode.isPresent())
            {
                return translate(civNode.get().getOtherNode(node.get()));
            }
        }
        return null;
    }

}
