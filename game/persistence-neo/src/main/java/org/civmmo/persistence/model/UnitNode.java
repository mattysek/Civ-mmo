/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import java.util.List;
import org.civmmo.model.City;
import org.civmmo.model.Civilization;
import org.civmmo.model.Promotion;
import org.civmmo.model.Tile;
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
public class UnitNode extends Unit{
    private final Node node;
    
    public UnitNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("Unit"));
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
        return o instanceof UnitNode &&
                this.node.equals( ( (UnitNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "Unit[" + this.getId() + "]";
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
    public int getMovementPoints() {
        return NodeHelper.getProperty(node,"movementpoints");
    }

    @Override
    public void setMovementPoints(int movementPoints) {
        NodeHelper.setProperty(node,"movementpoints", movementPoints);
    }

    @Override
    public int getCombatStrength() {
        return NodeHelper.getProperty(node,"combatstrength");
    }

    @Override
    public void setCombatStrength(int combatStrength) {
        NodeHelper.setProperty(node,"combatstrength", combatStrength);
    }

    @Override
    public int getRangedCombatStrength() {
        return NodeHelper.getProperty(node,"rangedcombatstrength");
    }

    @Override
    public void setRangedCombatStrength(int rangedCombatStrength) {
        NodeHelper.setProperty(node,"rangedcombatstrength", rangedCombatStrength);
    }

    @Override
    public int getRange() {
        return NodeHelper.getProperty(node,"range");
    }

    @Override
    public void setRange(int range) {
        NodeHelper.setProperty(node,"range",range);
    }

    @Override
    public int getHitPoints() {
        return NodeHelper.getProperty(node,"hitpoints");
    }

    @Override
    public void setHitPoints(int hitPoints) {
        NodeHelper.setProperty(node,"hitpoints",hitPoints);
    }

    @Override
    public int getExperience() {
        return NodeHelper.getProperty(node,"experience");
    }

    @Override
    public void setExperience(int experience) {
        NodeHelper.setProperty(node,"experience", experience);
    }

    @Override
    public Tile getPosition() {
        return NodeHelper.getSingleRelationship(node,RelationshipType.TILE_UNIT,e -> new TileNode(e));
    }

    @Override
    public void setPosition(Tile position) {
        NodeHelper.setSingleRelationship(node,position,RelationshipType.TILE_UNIT, e -> ((TileNode)e).getUnderlyingNode());
    }

    @Override
    public List<UnitType> getTypes() {
        return NodeHelper.getRelationship(node,RelationshipType.UNIT_UNIT_TYPE,e -> new UnitTypeNode(e));
    }

    @Override
    public void setTypes(List<UnitType> types) {
        NodeHelper.setRelationship(node,types,RelationshipType.UNIT_UNIT_TYPE, e -> ((UnitTypeNode)e).getUnderlyingNode());
    }

    @Override
    public List<Promotion> getPromotions() {
        return NodeHelper.getRelationship(node,RelationshipType.PROMOTION_UNIT,e -> new PromotionNode(e));
    }

    @Override
    public void setPromotions(List<Promotion> promotions) {
        NodeHelper.setRelationship(node,promotions,RelationshipType.PROMOTION_UNIT, e -> ((PromotionNode)e).getUnderlyingNode());
    }

    @Override
    public List<City> getCurrentlyConstructedBy() {
        return NodeHelper.getRelationship(node,RelationshipType.CITY_UNIT,e -> new CityNode(e));
    }

    @Override
    public void setCurrentlyConstructedBy(List<City> currentlyConstructedBy) {
        NodeHelper.setRelationship(node,currentlyConstructedBy,RelationshipType.CITY_UNIT, e -> ((CityNode)e).getUnderlyingNode());
    }

    @Override
    public Civilization getOwnedBy() {
        return NodeHelper.getSingleRelationship(node,RelationshipType.CIVILIZATION_UNIT,e -> new CivilizationNode(e));
    }

    @Override
    public void setOwnedBy(Civilization ownedBy) {
        NodeHelper.setSingleRelationship(node,ownedBy,RelationshipType.CIVILIZATION_UNIT, e -> ((CivilizationNode)e).getUnderlyingNode());
    }

    @Override
    public List<Tile> getVisibleTiles() {
        return NodeHelper.getRelationship(node,RelationshipType.TILE_UNIT_2,e -> new TileNode(e));
    }

    @Override
    public void setVisibleTiles(List<Tile> visibleTiles) {
        NodeHelper.setRelationship(node,visibleTiles,RelationshipType.TILE_UNIT_2, e -> ((TileNode)e).getUnderlyingNode());
    }

    @Override
    public List<Tile> getControledTiles() {
        return NodeHelper.getRelationship(node,RelationshipType.TILE_UNIT_3,e -> new TileNode(e));
    }

    @Override
    public void setControledTiles(List<Tile> controledTiles) {
        NodeHelper.setRelationship(node,controledTiles,RelationshipType.TILE_UNIT_3, e -> ((TileNode)e).getUnderlyingNode());
    }
    
    @Override
    public List<Unit> getAttackedBy() {
        return NodeHelper.getRelationship(node,RelationshipType.UNIT_UNIT,e -> new UnitNode(e));
    }

    @Override
    public void setAttackedBy(List<Unit> units) {
        NodeHelper.setRelationship(node,units,RelationshipType.UNIT_UNIT, e -> ((UnitNode)e).getUnderlyingNode());
    }
}
