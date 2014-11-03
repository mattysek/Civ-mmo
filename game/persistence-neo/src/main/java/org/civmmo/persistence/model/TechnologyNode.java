/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import java.util.List;
import org.civmmo.model.Building;
import org.civmmo.model.Civilization;
import org.civmmo.model.Resource;
import org.civmmo.model.Technology;
import org.civmmo.model.UnitType;
import org.civmmo.persistence.model.neospecific.NodeHelper;
import org.civmmo.persistence.model.neospecific.RelationshipType;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Mattysek
 */
public class TechnologyNode extends Technology {
    private final Node node;
    
    public TechnologyNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("Technology"));
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
        return o instanceof TechnologyNode &&
                this.node.equals( ( (TechnologyNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "Technology[" + this.getId() + "]";
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
    public long getCost() {
        return NodeHelper.getProperty(node,"cost");
    }

    @Override
    public void setCost(long cost) {
        NodeHelper.setProperty(node,"cost", cost);
    }

    @Override
    public List<Resource> getRevealsResources() {
        return NodeHelper.getRelationship(node,RelationshipType.RESOURCE_TECHNOLOGY,e -> new ResourceNode(e));
    }

    @Override
    public void setRevealsResources(List<Resource> revealsResources) {
        NodeHelper.setRelationship(node,revealsResources,RelationshipType.RESOURCE_TECHNOLOGY, e -> ((ResourceNode)e).getUnderlyingNode());
    }

    @Override
    public List<Building> getRevealsBuildings() {
        return NodeHelper.getRelationship(node,RelationshipType.BUILDING_TECHNOLOGY,e -> new BuildingNode(e));
    }

    @Override
    public void setRevealsBuildings(List<Building> revealsBuildings) {
        NodeHelper.setRelationship(node,revealsBuildings,RelationshipType.BUILDING_TECHNOLOGY, e -> ((BuildingNode)e).getUnderlyingNode());
    }

    @Override
    public List<UnitType> getRevealsUnits() {
        return NodeHelper.getRelationship(node,RelationshipType.TECHNOLOGY_UNIT_TYPE,e -> new UnitTypeNode(e));
    }

    @Override
    public void setRevealsUnits(List<UnitType> revealsUnits) {
        NodeHelper.setRelationship(node,revealsUnits,RelationshipType.TECHNOLOGY_UNIT_TYPE, e -> ((UnitTypeNode)e).getUnderlyingNode());
    }

    @Override
    public List<Technology> getPrerequisities() {
        return NodeHelper.getRelationship(node,RelationshipType.TECHNOLOGY_TECHNOLOGY,e -> new TechnologyNode(e));
    }

    @Override
    public void setPrerequisities(List<Technology> prerequisities) {
        NodeHelper.setRelationship(node,prerequisities,RelationshipType.TECHNOLOGY_TECHNOLOGY, e -> ((TechnologyNode)e).getUnderlyingNode());
    }

    @Override
    public List<Civilization> getKnownBy() {
        return NodeHelper.getRelationship(node,RelationshipType.CIVILIZATION_TECHNOLOGY,e -> new CivilizationNode(e));
    }

    @Override
    public void setKnownBy(List<Civilization> knownBy) {
        NodeHelper.setRelationship(node,knownBy,RelationshipType.CIVILIZATION_TECHNOLOGY, e -> ((CivilizationNode)e).getUnderlyingNode());
    }
}
