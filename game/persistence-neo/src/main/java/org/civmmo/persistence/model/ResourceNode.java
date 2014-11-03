/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import java.util.List;
import org.civmmo.model.Building;
import org.civmmo.model.Improvement;
import org.civmmo.model.Resource;
import org.civmmo.model.Technology;
import org.civmmo.model.Tile;
import org.civmmo.model.Unit;
import org.civmmo.persistence.model.neospecific.NodeHelper;
import org.civmmo.persistence.model.neospecific.RelationshipType;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Mattysek
 */
public class ResourceNode extends Resource {
    private final Node node;
    
    public ResourceNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("Resource"));
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
        return o instanceof ResourceNode &&
                this.node.equals( ( (ResourceNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "Resource[" + this.getId() + "]";
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
    public int getFood() {
        return NodeHelper.getProperty(node,"food");
    }

    @Override
    public void setFood(int food) {
        NodeHelper.setProperty(node,"food",food);
    }

    @Override
    public int getProduction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setProduction(int production) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getGold() {
        return NodeHelper.getProperty(node,"gold");
    }

    @Override
    public void setGold(int gold) {
        NodeHelper.setProperty(node,"gold",gold);
    }

    @Override
    public double getHappiness() {
        return NodeHelper.getProperty(node,"happiness");
    }

    @Override
    public void setHappiness(double happiness) {
        NodeHelper.setProperty(node,"happiness",happiness);
    }

    @Override
    public Improvement getImprovement() {
        return NodeHelper.getSingleRelationship(node, RelationshipType.RESOURCE_IMPROVEMENT, e -> new ImprovementNode(e));
    }

    @Override
    public void setImprovement(Improvement improvement) {
        NodeHelper.setSingleRelationship(node, improvement, RelationshipType.RESOURCE_IMPROVEMENT, e -> ((ImprovementNode)e).getUnderlyingNode());
    }

    @Override
    public Technology getRevealedBy() {
        return NodeHelper.getSingleRelationship(node, RelationshipType.RESOURCE_TECHNOLOGY, e -> new TechnologyNode(e));
    }

    @Override
    public void setRevealedBy(Technology revealedBy) {
        NodeHelper.setSingleRelationship(node, revealedBy, RelationshipType.RESOURCE_TECHNOLOGY, e -> ((TechnologyNode)e).getUnderlyingNode());
    }

    @Override
    public List<Building> getRequiredByBuildings() {
        return NodeHelper.getRelationship(node, RelationshipType.BUILDING_RESOURCE, e -> new BuildingNode(e));
    }

    @Override
    public void setRequiredByBuildings(List<Building> requiredByBuildings) {
        NodeHelper.setRelationship(node, requiredByBuildings, RelationshipType.BUILDING_RESOURCE, e -> ((BuildingNode)e).getUnderlyingNode());
    }

    @Override
    public List<Unit> getRequiredByUnits() {
        return NodeHelper.getRelationship(node, RelationshipType.RESOURCE_UNIT, e -> new UnitNode(e));
    }

    @Override
    public void setRequiredByUnits(List<Unit> requiredByUnits) {
        NodeHelper.setRelationship(node, requiredByUnits, RelationshipType.RESOURCE_UNIT, e -> ((UnitNode)e).getUnderlyingNode());
    }

    @Override
    public List<Tile> getCanBeFoundOnTiles() {
        return NodeHelper.getRelationship(node, RelationshipType.RESOURCE_TILE, e -> new TileNode(e));
    }

    @Override
    public void setCanBeFoundOnTiles(List<Tile> canBeFoundOnTiles) {
        NodeHelper.setRelationship(node, canBeFoundOnTiles, RelationshipType.RESOURCE_TILE, e -> ((TileNode)e).getUnderlyingNode());
    }
}
