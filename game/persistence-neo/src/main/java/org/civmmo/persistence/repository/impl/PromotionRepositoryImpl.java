package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.PromotionRepository;
import org.civmmo.model.Promotion;
import org.civmmo.persistence.model.PromotionNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class PromotionRepositoryImpl extends BaseRepositoryImpl<Promotion> implements PromotionRepository {

    public PromotionRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected Promotion translate(Node node) {
        return new PromotionNode(node);
    }

    @Override
    protected void deleteObject(Promotion object) {
        ((PromotionNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(Promotion object) {
        Node node = ((PromotionNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }

}
