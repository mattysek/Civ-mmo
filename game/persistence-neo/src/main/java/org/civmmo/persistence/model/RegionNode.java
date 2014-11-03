/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import java.util.List;
import org.civmmo.model.Region;
import org.civmmo.model.Tile;
import org.civmmo.persistence.model.neospecific.NodeHelper;
import org.civmmo.persistence.model.neospecific.RelationshipType;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Mattysek
 */
public class RegionNode extends Region{
    private final Node node;
    
    public RegionNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("Region"));
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
        return o instanceof RegionNode &&
                this.node.equals( ( (RegionNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "Region[" + this.getId() + "]";
    }

    @Override
    public List<Tile> getTiles() {
        return NodeHelper.getRelationship(node,RelationshipType.REGION_TILE,e -> new TileNode(e));
    }

    @Override
    public void setTiles(List<Tile> tiles) {
        NodeHelper.setRelationship(node,tiles,RelationshipType.REGION_TILE, e -> ((TileNode)e).getUnderlyingNode());
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
    protected Tile createNewTile() {
        return new TileNode(this.node.getGraphDatabase().createNode());
    }
}
