/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import java.util.List;
import org.civmmo.model.Action;
import org.civmmo.model.CombatModifier;
import org.civmmo.model.UnitType;
import org.civmmo.persistence.model.neospecific.NodeHelper;
import org.civmmo.persistence.model.neospecific.RelationshipType;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Mattysek
 */

public class ActionNode extends Action {
    
    private final Node node;
    
    public ActionNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("Action"));
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
        return o instanceof ActionNode &&
                this.node.equals( ( (ActionNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "Action[" + this.getId() + "]";
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
    public List<CombatModifier> getCombatModifiers() {
        return NodeHelper.getRelationship(node,RelationshipType.ACTION_COMBAT_MODIFIER,e -> new CombatModifierNode(e));
    }

    @Override
    public void setCombatModifiers(List<CombatModifier> combatModifiers) {
        NodeHelper.setRelationship(node,combatModifiers,RelationshipType.ACTION_COMBAT_MODIFIER, e -> ((CombatModifierNode)e).getUnderlyingNode());
    }

    @Override
    public List<UnitType> getAplicableTo() {
        return NodeHelper.getRelationship(node,RelationshipType.ACTION_UNIT_TYPE,e -> new UnitTypeNode(e));
    }

    @Override
    public void setAplicableTo(List<UnitType> aplicableTo) {
        NodeHelper.setRelationship(node,aplicableTo,RelationshipType.ACTION_UNIT_TYPE, e -> ((UnitTypeNode)e).getUnderlyingNode());
    }
    
}
