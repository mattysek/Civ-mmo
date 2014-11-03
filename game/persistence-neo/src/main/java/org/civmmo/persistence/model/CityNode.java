/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import java.util.List;
import org.civmmo.model.Building;
import org.civmmo.model.City;
import org.civmmo.model.Civilization;
import org.civmmo.model.Tile;
import org.civmmo.model.TradeRoute;
import org.civmmo.model.Unit;
import org.civmmo.persistence.model.neospecific.NodeHelper;
import org.civmmo.persistence.model.neospecific.RelationshipType;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Mattysek
 */
public class CityNode extends City {

    private final Node node;
    
    public CityNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("City"));
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
        return o instanceof CityNode &&
                this.node.equals( ( (CityNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "City[" + this.getId() + "]";
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
    public int getRange() {
        return NodeHelper.getProperty(node,"range");
    }

    @Override
    public void setRange(int range) {
        NodeHelper.setProperty(node,"range",range);
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
        return NodeHelper.getProperty(node,"production");
    }

    @Override
    public void setProduction(int production) {
        NodeHelper.setProperty(node,"production",production);
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
    public int getScience() {
        return NodeHelper.getProperty(node,"science");
    }

    @Override
    public void setScience(int science) {
        NodeHelper.setProperty(node,"science",science);
    }

    @Override
    public int getCulture() {
        return NodeHelper.getProperty(node,"culture");
    }

    @Override
    public void setCulture(int culture) {
        NodeHelper.setProperty(node,"culture",culture);
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
    public int getCitizens() {
        return NodeHelper.getProperty(node,"citizens");
    }

    @Override
    public void setCitizens(int citizens) {
        NodeHelper.setProperty(node,"citizens",citizens);
    }

    @Override
    public Tile getCenter() {
        return NodeHelper.getSingleRelationship(node, RelationshipType.CITY_TILE, e -> new TileNode(e));
    }

    @Override
    public void setCenter(Tile center) {
        NodeHelper.setSingleRelationship(node, center, RelationshipType.CITY_TILE, e -> ((TileNode)e).getUnderlyingNode());
    }

    @Override
    public Civilization getOwnedBy() {
        return NodeHelper.getSingleRelationship(node, RelationshipType.CITY_CIVILIZATION, e -> new CivilizationNode(e));
    }

    @Override
    public void setOwnedBy(Civilization ownedBy) {
        NodeHelper.setSingleRelationship(node, ownedBy, RelationshipType.CITY_CIVILIZATION, e -> ((CivilizationNode)e).getUnderlyingNode());
    }

    @Override
    public Building getCurrentlyConstructedBuilding() {
        return NodeHelper.getSingleRelationship(node, RelationshipType.BUILDING_CITY_2, e -> new BuildingNode(e));
    }

    @Override
    public void setCurrentlyConstructedBuilding(Building currentlyConstructedBuilding) {
        NodeHelper.setSingleRelationship(node, currentlyConstructedBuilding, RelationshipType.BUILDING_CITY_2, e -> ((BuildingNode)e).getUnderlyingNode());
    }

    @Override
    public List<Building> getConstructedBuildings() {
        return NodeHelper.getRelationship(node,RelationshipType.BUILDING_CITY_3,e -> new BuildingNode(e));
    }

    @Override
    public void setConstructedBuildings(List<Building> constructedBuildings) {
        NodeHelper.setRelationship(node,constructedBuildings,RelationshipType.BUILDING_CITY_3, e -> ((BuildingNode)e).getUnderlyingNode());
    }

    @Override
    public List<Building> getWorkedBuildings() {
        return NodeHelper.getRelationship(node,RelationshipType.BUILDING_CITY,e -> new BuildingNode(e));
    }

    @Override
    public void setWorkedBuildings(List<Building> workedBuildings) {
        NodeHelper.setRelationship(node,workedBuildings,RelationshipType.BUILDING_CITY, e -> ((BuildingNode)e).getUnderlyingNode());
    }

    @Override
    public List<TradeRoute> getTradeRoutesFrom() {
        return NodeHelper.getRelationship(node,RelationshipType.CITY_TRADE_ROUTE,e -> new TradeRouteNode(e));
    }

    @Override
    public void setTradeRoutesFrom(List<TradeRoute> tradeRoutesFrom) {
        NodeHelper.setRelationship(node,tradeRoutesFrom,RelationshipType.CITY_TRADE_ROUTE, e -> ((TradeRouteNode)e).getUnderlyingNode());
    }

    @Override
    public List<TradeRoute> getTradeRoutesTo() {
        return NodeHelper.getRelationship(node,RelationshipType.CITY_TRADE_ROUTE_2,e -> new TradeRouteNode(e));
    }

    @Override
    public void setTradeRoutesTo(List<TradeRoute> tradeRoutesTo) {
        NodeHelper.setRelationship(node,tradeRoutesTo,RelationshipType.CITY_TRADE_ROUTE_2, e -> ((TradeRouteNode)e).getUnderlyingNode());
    }

    @Override
    public List<Tile> getVisibleTiles() {
        return NodeHelper.getRelationship(node,RelationshipType.CITY_TILE_2,e -> new TileNode(e));
    }

    @Override
    public void setVisibleTiles(List<Tile> visibleTiles) {
        NodeHelper.setRelationship(node,visibleTiles,RelationshipType.CITY_TILE_2, e -> ((TileNode)e).getUnderlyingNode());
    }

    @Override
    public List<Tile> getControledTiles() {
        return NodeHelper.getRelationship(node,RelationshipType.CITY_TILE_3,e -> new TileNode(e));
    }

    @Override
    public void setControledTiles(List<Tile> controledTiles) {
        NodeHelper.setRelationship(node,controledTiles,RelationshipType.CITY_TILE_3, e -> ((TileNode)e).getUnderlyingNode());
    }

    @Override
    public List<Tile> getWorkedTiles() {
        return NodeHelper.getRelationship(node,RelationshipType.CITY_TILE_4,e -> new TileNode(e));
    }

    @Override
    public void setWorkedTiles(List<Tile> workedTiles) {
        NodeHelper.setRelationship(node,workedTiles,RelationshipType.CITY_TILE_4, e -> ((TileNode)e).getUnderlyingNode());
    }

    @Override
    public Unit getCurrentlyConstructedUnit() {
        return NodeHelper.getSingleRelationship(node, RelationshipType.CITY_UNIT, e -> new UnitNode(e));
    }

    @Override
    public void setCurrentlyConstructedUnit(Unit currentlyConstructedUnit) {
        NodeHelper.setSingleRelationship(node, currentlyConstructedUnit, RelationshipType.CITY_UNIT, e -> ((UnitNode)e).getUnderlyingNode());
    }
}
