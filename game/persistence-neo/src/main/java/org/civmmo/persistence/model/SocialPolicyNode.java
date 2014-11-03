/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import java.util.List;
import org.civmmo.model.Civilization;
import org.civmmo.model.Policy;
import org.civmmo.model.SocialPolicy;
import org.civmmo.persistence.model.neospecific.NodeHelper;
import org.civmmo.persistence.model.neospecific.RelationshipType;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Mattysek
 */
public class SocialPolicyNode extends SocialPolicy {
    private final Node node;
    
    public SocialPolicyNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("SocialPolicy"));
    }
    
    public Node getUnderlyingNode()
    {
        return this.node;
    }
    
    @Override
    public int hashCode()
    {
        return this.node.hashCode();
    }

    @Override
    public boolean equals( Object o )
    {
        return o instanceof SocialPolicyNode &&
                this.node.equals( ( (SocialPolicyNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "SocialPolicy[" + this.getId() + "]";
    }

    @Override
    public String getName() {
        return NodeHelper.getProperty(node,"name");
    }

    @Override
    public void setName(String name) {
        NodeHelper.setProperty(node,"name", name);
    }

    @Override
    public int getBaseCost() {
        return NodeHelper.getProperty(node,"basecost");
    }

    @Override
    public void setBaseCost(int baseCost) {
        NodeHelper.setProperty(node,"basecost", baseCost);
    }

    @Override
    public long getId() {
        return NodeHelper.getProperty(node,"id");
    }

    @Override
    public void setId(long id) {
        NodeHelper.setProperty(node,"id",id);
    }

    @Override
    public List<Civilization> getCurrentlyUsedBy() {
        return NodeHelper.getRelationship(node,RelationshipType.CIVILIZATION_SOCIAL_POLICY,e -> new CivilizationNode(e));
    }

    @Override
    public void setCurrentlyUsedBy(List<Civilization> currentlyUsedBy) {
        NodeHelper.setRelationship(node,currentlyUsedBy,RelationshipType.CIVILIZATION_SOCIAL_POLICY, e -> ((CivilizationNode)e).getUnderlyingNode());
    }

    @Override
    public List<Policy> getPolicies() {
        return NodeHelper.getRelationship(node,RelationshipType.POLICY_SOCIAL_POLICY,e -> new PolicyNode(e));
    }

    @Override
    public void setPolicies(List<Policy> policies) {
        NodeHelper.setRelationship(node,policies,RelationshipType.POLICY_SOCIAL_POLICY, e -> ((PolicyNode)e).getUnderlyingNode());
    }
}
