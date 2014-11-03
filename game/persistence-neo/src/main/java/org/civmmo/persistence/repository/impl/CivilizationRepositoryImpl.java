package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.CivilizationRepository;
import org.civmmo.model.Civilization;
import org.civmmo.persistence.model.CivilizationNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

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

}
