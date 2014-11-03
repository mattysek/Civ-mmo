/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

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
public class PolicyNode extends Policy {
    private final Node node;
    
    public PolicyNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("Policy"));
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
        return o instanceof PolicyNode &&
                this.node.equals( ( (PolicyNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "Policy[" + this.getId() + "]";
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
    public String getName() {
        return NodeHelper.getProperty(node,"name");
    }

    @Override
    public void setName(String name) {
        NodeHelper.setProperty(node,"name", name);
    }

    @Override
    public int getCost() {
        return NodeHelper.getProperty(node,"cost");
    }

    @Override
    public void setCost(int cost) {
        NodeHelper.setProperty(node,"cost", cost);
    }

    @Override
    public SocialPolicy getSocialPolicy() {
        return NodeHelper.getSingleRelationship(node, RelationshipType.POLICY_SOCIAL_POLICY, e -> new SocialPolicyNode(e));
    }

    @Override
    public void setSocialPolicy(SocialPolicy socialPolicy) {
        NodeHelper.setSingleRelationship(node, socialPolicy, RelationshipType.POLICY_SOCIAL_POLICY, e -> ((SocialPolicyNode)e).getUnderlyingNode());
    }
}
