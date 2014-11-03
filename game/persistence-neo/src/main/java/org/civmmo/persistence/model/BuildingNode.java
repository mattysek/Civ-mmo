/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import java.util.List;
import org.civmmo.model.Building;
import org.civmmo.model.City;
import org.civmmo.model.Resource;
import org.civmmo.model.Technology;
import org.civmmo.persistence.model.neospecific.NodeHelper;
import org.civmmo.persistence.model.neospecific.RelationshipType;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Mattysek
 */
public class BuildingNode extends Building {
    
    private final Node node;
    
    public BuildingNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("Building"));
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
        return o instanceof BuildingNode &&
                this.node.equals( ( (BuildingNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "Building[" + this.getId() + "]";
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
        NodeHelper.setProperty(node,"name",name);
    }

    @Override
    public int getCost() {
        return NodeHelper.getProperty(node,"cost");
    }

    @Override
    public void setCost(int cost) {
        NodeHelper.setProperty(node,"cost",cost);
    }

    @Override
    public int getMaintenence() {
        return NodeHelper.getProperty(node,"maintenence");
    }

    @Override
    public void setMaintenence(int maintenence) {
        NodeHelper.setProperty(node,"maintenence",maintenence);
    }

    @Override
    public int getSpecialistsSlots() {
        return NodeHelper.getProperty(node,"specialists");
    }

    @Override
    public void setSpecialistsSlots(int specialistsSlots) {
        NodeHelper.setProperty(node,"specialists",specialistsSlots);
    }

    @Override
    public List<Technology> getRequiredTechnologies() {
        return NodeHelper.getRelationship(node,RelationshipType.BUILDING_TECHNOLOGY,e -> new TechnologyNode(e));
    }

    @Override
    public void setRequiredTechnologies(List<Technology> requiredTechnologies) {
        NodeHelper.setRelationship(node,requiredTechnologies,RelationshipType.BUILDING_TECHNOLOGY, e -> ((TechnologyNode)e).getUnderlyingNode());
    }

    @Override
    public List<Resource> getRequiredResources() {
        return NodeHelper.getRelationship(node,RelationshipType.BUILDING_RESOURCE,e -> new ResourceNode(e));
    }

    @Override
    public void setRequiredResources(List<Resource> requiredResources) {
        NodeHelper.setRelationship(node,requiredResources,RelationshipType.BUILDING_RESOURCE, e -> ((ResourceNode)e).getUnderlyingNode());
    }

    @Override
    public List<City> getWorkedBy() {
        return NodeHelper.getRelationship(node,RelationshipType.BUILDING_CITY,e -> new CityNode(e));
    }

    @Override
    public void setWorkedBy(List<City> workedBy) {
        NodeHelper.setRelationship(node,workedBy,RelationshipType.BUILDING_CITY, e -> ((CityNode)e).getUnderlyingNode());
    }

    @Override
    public List<City> getCurrentlyConstructedBy() {
        return NodeHelper.getRelationship(node,RelationshipType.BUILDING_CITY_2,e -> new CityNode(e));
    }

    @Override
    public void setCurrentlyConstructedBy(List<City> currentlyConstructedBy) {
        NodeHelper.setRelationship(node,currentlyConstructedBy,RelationshipType.BUILDING_CITY_2, e -> ((CityNode)e).getUnderlyingNode());
    }
}
