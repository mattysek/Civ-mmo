/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import java.util.List;
import org.civmmo.model.Action;
import org.civmmo.model.Promotion;
import org.civmmo.model.Unit;
import org.civmmo.model.UnitType;
import org.civmmo.persistence.model.neospecific.NodeHelper;
import org.civmmo.persistence.model.neospecific.RelationshipType;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Mattysek
 */
public class UnitTypeNode extends UnitType{
    private final Node node;
    
    public UnitTypeNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("UnitType"));
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
        return o instanceof UnitTypeNode &&
                this.node.equals( ( (UnitTypeNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "UnitType[" + this.getId() + "]";
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
    public List<Unit> getUnits() {
        return NodeHelper.getRelationship(node,RelationshipType.UNIT_UNIT_TYPE,e -> new UnitNode(e));
    }

    @Override
    public void setUnits(List<Unit> units) {
        NodeHelper.setRelationship(node,units,RelationshipType.UNIT_UNIT_TYPE, e -> ((UnitNode)e).getUnderlyingNode());
    }

    @Override
    public Promotion getAffectedPromotion() {
        return NodeHelper.getSingleRelationship(node,RelationshipType.PROMOTION_UNIT_TYPE,e -> new PromotionNode(e));
    }

    @Override
    public void setAffectedPromotion(Promotion affectedPromotion) {
        NodeHelper.setSingleRelationship(node,affectedPromotion,RelationshipType.PROMOTION_UNIT_TYPE, e -> ((PromotionNode)e).getUnderlyingNode());
    }

    @Override
    public List<Action> getActions() {
        return NodeHelper.getRelationship(node,RelationshipType.ACTION_UNIT_TYPE,e -> new ActionNode(e));
    }

    @Override
    public void setActions(List<Action> actions) {
        NodeHelper.setRelationship(node,actions,RelationshipType.UNIT_UNIT_TYPE, e -> ((ActionNode)e).getUnderlyingNode());
    }
}
