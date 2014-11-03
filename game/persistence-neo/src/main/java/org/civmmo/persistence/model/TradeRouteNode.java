/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import java.util.List;
import org.civmmo.model.City;
import org.civmmo.model.Tile;
import org.civmmo.model.TradeRoute;
import org.civmmo.persistence.model.neospecific.NodeHelper;
import org.civmmo.persistence.model.neospecific.RelationshipType;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Mattysek
 */
public class TradeRouteNode extends TradeRoute{
    private final Node node;
    
    public TradeRouteNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("TradeRoute"));
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
        return o instanceof TradeRouteNode &&
                this.node.equals( ( (TradeRouteNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "TradeRoute[" + this.getId() + "]";
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
    public City getFrom() {
        return NodeHelper.getSingleRelationship(node,RelationshipType.CITY_TRADE_ROUTE,e -> new CityNode(e));
    }

    @Override
    public void setFrom(City from) {
        NodeHelper.setSingleRelationship(node,from,RelationshipType.CITY_TRADE_ROUTE, e -> ((CityNode)e).getUnderlyingNode());
    }

    @Override
    public City getTo() {
        return NodeHelper.getSingleRelationship(node,RelationshipType.CITY_TRADE_ROUTE_2,e -> new CityNode(e));
    }

    @Override
    public void setTo(City to) {
        NodeHelper.setSingleRelationship(node,to,RelationshipType.CITY_TRADE_ROUTE_2, e -> ((CityNode)e).getUnderlyingNode());
    }

    @Override
    public List<Tile> getTiles() {
        return NodeHelper.getRelationship(node,RelationshipType.TILE_TRADE_ROUTE,e -> new TileNode(e));
    }

    @Override
    public void setTiles(List<Tile> tiles) {
        NodeHelper.setSingleRelationship(node,tiles,RelationshipType.TILE_TRADE_ROUTE, e -> ((TileNode)e).getUnderlyingNode());
    }
}
