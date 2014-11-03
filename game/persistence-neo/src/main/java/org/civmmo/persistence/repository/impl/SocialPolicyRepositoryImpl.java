package org.civmmo.persistence.repository.impl;

import org.civmmo.persistence.repository.SocialPolicyRepository;
import org.civmmo.model.SocialPolicy;
import org.civmmo.persistence.model.SocialPolicyNode;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

public class SocialPolicyRepositoryImpl extends BaseRepositoryImpl<SocialPolicy> implements SocialPolicyRepository {

    public SocialPolicyRepositoryImpl(GraphDatabaseService graphDb) {
        super(graphDb);
    }

    @Override
    protected SocialPolicy translate(Node node) {
        return new SocialPolicyNode(node);
    }

    @Override
    protected void deleteObject(SocialPolicy object) {
        ((SocialPolicyNode)object).getUnderlyingNode().delete();
    }
    
    @Override
    protected void createObject(SocialPolicy object) {
        Node node = ((SocialPolicyNode)object).getUnderlyingNode();
        object.setId(node.getId());
    }

}
