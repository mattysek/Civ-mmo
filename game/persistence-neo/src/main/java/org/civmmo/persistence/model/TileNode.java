/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import java.util.List;
import org.civmmo.model.City;
import org.civmmo.model.Improvement;
import org.civmmo.model.Region;
import org.civmmo.model.Resource;
import org.civmmo.model.River;
import org.civmmo.model.TerrainFeature;
import org.civmmo.model.TerrainType;
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
public class TileNode extends Tile{
    private final Node node;
    
    public TileNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("Tile"));
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
        return o instanceof TileNode &&
                this.node.equals( ( (TileNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "Tile[" + this.getId() + "]";
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
    public long getX() {
        return NodeHelper.getProperty(node,"x");
    }

    @Override
    public void setX(long x) {
        NodeHelper.setProperty(node,"x",x);
    }

    @Override
    public long getY() {
        return NodeHelper.getProperty(node,"y");
    }

    @Override
    public void setY(long y) {
        NodeHelper.setProperty(node,"y",y);
    }

    @Override
    public Region getRegion() {
        return NodeHelper.getSingleRelationship(node,RelationshipType.REGION_TILE,e -> new RegionNode(e));
    }

    @Override
    public void setRegion(Region region) {
        NodeHelper.setSingleRelationship(node,region,RelationshipType.REGION_TILE, e -> ((RegionNode)e).getUnderlyingNode());
    }

    @Override
    public City getCity() {
        return NodeHelper.getSingleRelationship(node,RelationshipType.CITY_TILE,e -> new CityNode(e));
    }

    @Override
    public void setCity(City city) {
        NodeHelper.setSingleRelationship(node,city,RelationshipType.CITY_TILE, e -> ((CityNode)e).getUnderlyingNode());
    }

    @Override
    public Unit getMilitaryUnit() {
        return NodeHelper.getSingleRelationship(node,RelationshipType.TILE_UNIT,e -> new UnitNode(e));
    }

    @Override
    public void setMilitaryUnit(Unit militaryUnit) {
        NodeHelper.setSingleRelationship(node,militaryUnit,RelationshipType.TILE_UNIT, e -> ((UnitNode)e).getUnderlyingNode());
    }

    @Override
    public Unit getCivilUnit() {
        return NodeHelper.getSingleRelationship(node,RelationshipType.TILE_UNIT_1,e -> new UnitNode(e));
    }

    @Override
    public void setCivilUnit(Unit civilUnit) {
        NodeHelper.setSingleRelationship(node,civilUnit,RelationshipType.TILE_UNIT_1, e -> ((UnitNode)e).getUnderlyingNode());
    }

    @Override
    public TerrainFeature getTerrainFeature() {
        return NodeHelper.getSingleRelationship(node,RelationshipType.TERRAIN_FEATURE_TILE,e -> new TerrainFeatureNode(e));
    }

    @Override
    public void setTerrainFeature(TerrainFeature terrainFeature) {
        NodeHelper.setSingleRelationship(node,terrainFeature,RelationshipType.TERRAIN_FEATURE_TILE, e -> ((TerrainFeatureNode)e).getUnderlyingNode());
    }

    @Override
    public TerrainType getTerrainType() {
        return NodeHelper.getSingleRelationship(node,RelationshipType.TERRAIN_TYPE_TILE,e -> new TerrainTypeNode(e));
    }

    @Override
    public void setTerrainType(TerrainType terrainType) {
        NodeHelper.setSingleRelationship(node,terrainType,RelationshipType.TERRAIN_TYPE_TILE, e -> ((TerrainTypeNode)e).getUnderlyingNode());
    }

    @Override
    public Improvement getImprovement() {
        return NodeHelper.getSingleRelationship(node,RelationshipType.IMPROVEMENT_TILE,e -> new ImprovementNode(e));
    }

    @Override
    public void setImprovement(Improvement improvement) {
        NodeHelper.setSingleRelationship(node,improvement,RelationshipType.IMPROVEMENT_TILE, e -> ((ImprovementNode)e).getUnderlyingNode());
    }

    @Override
    public Resource getResource() {
        return NodeHelper.getSingleRelationship(node,RelationshipType.RESOURCE_TILE,e -> new ResourceNode(e));
    }

    @Override
    public void setResource(Resource resource) {
        NodeHelper.setSingleRelationship(node,resource,RelationshipType.RESOURCE_TILE, e -> ((ResourceNode)e).getUnderlyingNode());
    }

    @Override
    public List<TradeRoute> getTradeRoutes() {
        return NodeHelper.getRelationship(node,RelationshipType.TILE_TRADE_ROUTE,e -> new TradeRouteNode(e));
    }

    @Override
    public void setTradeRoutes(List<TradeRoute> tradeRoutes) {
        NodeHelper.setRelationship(node,tradeRoutes,RelationshipType.TILE_TRADE_ROUTE, e -> ((TradeRouteNode)e).getUnderlyingNode());
    }

    @Override
    public List<River> getRivers() {
        return NodeHelper.getRelationship(node,RelationshipType.RIVER_TILE,e -> new RiverNode(e));
    }

    @Override
    public void setRivers(List<River> rivers) {
        NodeHelper.setRelationship(node,rivers,RelationshipType.RIVER_TILE, e -> ((RiverNode)e).getUnderlyingNode());
    }

    @Override
    public List<City> getVisibleForCities() {
        return NodeHelper.getRelationship(node,RelationshipType.CITY_TILE_2,e -> new CityNode(e));
    }

    @Override
    public void setVisibleForCities(List<City> visibleForCities) {
        NodeHelper.setRelationship(node,visibleForCities,RelationshipType.CITY_TILE_2, e -> ((CityNode)e).getUnderlyingNode());
    }

    @Override
    public List<Unit> getVisibleForUnits() {
        return NodeHelper.getRelationship(node,RelationshipType.TILE_UNIT_2,e -> new UnitNode(e));
    }

    @Override
    public void setVisibleForUnits(List<Unit> visibleForUnits) {
        NodeHelper.setRelationship(node,visibleForUnits,RelationshipType.TILE_UNIT_2, e -> ((UnitNode)e).getUnderlyingNode());
    }

    @Override
    public List<City> getControledByCity() {
        return NodeHelper.getRelationship(node,RelationshipType.CITY_TILE_3,e -> new CityNode(e));
    }

    @Override
    public void setControledByCity(List<City> controledByCity) {
        NodeHelper.setRelationship(node,controledByCity,RelationshipType.CITY_TILE_3, e -> ((CityNode)e).getUnderlyingNode());
    }

    @Override
    public List<Unit> getControledByUnit() {
        return NodeHelper.getRelationship(node,RelationshipType.TILE_UNIT_3,e -> new UnitNode(e));
    }

    @Override
    public void setControledByUnit(List<Unit> controledByUnit) {
        NodeHelper.setRelationship(node,controledByUnit,RelationshipType.TILE_UNIT_3, e -> ((UnitNode)e).getUnderlyingNode());
    }

    @Override
    public List<City> getWorkedBy() {
        return NodeHelper.getRelationship(node,RelationshipType.CITY_TILE_4,e -> new CityNode(e));
    }

    @Override
    public void setWorkedBy(List<City> workedBy) {
        NodeHelper.setRelationship(node,workedBy,RelationshipType.CITY_TILE_4, e -> ((CityNode)e).getUnderlyingNode());
    }
}
