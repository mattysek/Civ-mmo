/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import org.civmmo.model.Action;
import org.civmmo.model.CombatModifier;
import org.civmmo.persistence.model.neospecific.NodeHelper;
import org.civmmo.persistence.model.neospecific.RelationshipType;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Mattysek
 */
public class CombatModifierNode extends CombatModifier {
    private final Node node;
    
    public CombatModifierNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("CombatModifier"));
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
        return o instanceof CombatModifierNode &&
                this.node.equals( ( (CombatModifierNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "CombatModifier[" + this.getId() + "]";
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
    public double getValue() {
        return NodeHelper.getProperty(node,"value");
    }

    @Override
    public void setValue(double value) {
        NodeHelper.setProperty(node,"value",value);
    }

    @Override
    public Action getAfectedAction() {
        return NodeHelper.getSingleRelationship(node, RelationshipType.ACTION_COMBAT_MODIFIER, e -> new ActionNode(e));
    }

    @Override
    public void setAfectedAction(Action afectedAction) {
        NodeHelper.setSingleRelationship(node, afectedAction, RelationshipType.ACTION_COMBAT_MODIFIER, e -> ((ActionNode)e).getUnderlyingNode());
    }
}
