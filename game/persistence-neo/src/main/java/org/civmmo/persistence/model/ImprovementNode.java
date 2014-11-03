/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import java.util.List;
import org.civmmo.model.Improvement;
import org.civmmo.model.Tile;
import org.civmmo.persistence.model.neospecific.NodeHelper;
import org.civmmo.persistence.model.neospecific.RelationshipType;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Mattysek
 */
public class ImprovementNode extends Improvement{
    private final Node node;
    
    public ImprovementNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("Improvement"));
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
        return o instanceof ImprovementNode &&
                this.node.equals( ( (ImprovementNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "Improvement[" + this.getId() + "]";
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
    public List<Tile> getOfTiles() {
        return NodeHelper.getRelationship(node,RelationshipType.IMPROVEMENT_TILE,e -> new TileNode(e));
    }

    @Override
    public void setOfTiles(List<Tile> ofTiles) {
        NodeHelper.setRelationship(node,ofTiles,RelationshipType.IMPROVEMENT_TILE, e -> ((TileNode)e).getUnderlyingNode());
    }
}
