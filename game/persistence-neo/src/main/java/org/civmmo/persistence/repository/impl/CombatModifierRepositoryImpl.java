package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.CombatModifierRepository;
import org.civmmo.model.CombatModifier;
import org.civmmo.persistence.model.CombatModifierNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class CombatModifierRepositoryImpl extends BaseRepositoryImpl<CombatModifier> implements CombatModifierRepository{

    public CombatModifierRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected CombatModifier translate(Node node) {
        return new CombatModifierNode(node);
    }

    @Override
    protected void deleteObject(CombatModifier object) {
        ((CombatModifierNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(CombatModifier object) {
        Node node = ((CombatModifierNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }

}
