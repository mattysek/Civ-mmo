/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import java.util.List;
import org.civmmo.model.Promotion;
import org.civmmo.model.Technology;
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
public class PromotionNode extends Promotion{
    private final Node node;
    
    public PromotionNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("Promotion"));
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
        return o instanceof PromotionNode &&
                this.node.equals( ( (PromotionNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "Promotion[" + this.getId() + "]";
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
    public List<UnitType> getAffectedBy() {
        return NodeHelper.getRelationship(node,RelationshipType.PROMOTION_UNIT_TYPE,e -> new UnitTypeNode(e));
    }

    @Override
    public void setAffectedBy(List<UnitType> affectedBy) {
        NodeHelper.setRelationship(node,affectedBy,RelationshipType.PROMOTION_UNIT_TYPE, e -> ((UnitTypeNode)e).getUnderlyingNode());
    }

    @Override
    public List<Unit> getUnits() {
        return NodeHelper.getRelationship(node,RelationshipType.PROMOTION_UNIT,e -> new UnitNode(e));
    }

    @Override
    public void setUnits(List<Unit> units) {
        NodeHelper.setRelationship(node,units,RelationshipType.PROMOTION_UNIT, e -> ((UnitNode)e).getUnderlyingNode());
    }

    @Override
    public List<Technology> getPrerequisities() {
        return NodeHelper.getRelationship(node,RelationshipType.PROMOTION_TECHNOLOGY,e -> new TechnologyNode(e));
    }

    @Override
    public void setPrerequisities(List<Technology> prerequisities) {
        NodeHelper.setRelationship(node,prerequisities,RelationshipType.PROMOTION_TECHNOLOGY, e -> ((TechnologyNode)e).getUnderlyingNode());
    }
}
