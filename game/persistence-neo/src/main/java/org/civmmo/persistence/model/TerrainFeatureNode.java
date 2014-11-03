/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import java.util.List;
import org.civmmo.model.CombatModifier;
import org.civmmo.model.TerrainFeature;
import org.civmmo.model.Tile;
import org.civmmo.persistence.model.neospecific.NodeHelper;
import org.civmmo.persistence.model.neospecific.RelationshipType;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Mattysek
 */
public class TerrainFeatureNode extends TerrainFeature {
    private final Node node;
    
    public TerrainFeatureNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("TerrainFeature"));
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
        return o instanceof TerrainFeatureNode &&
                this.node.equals( ( (TerrainFeatureNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "TerrainFeature[" + this.getId() + "]";
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
    public int getMovementCost() {
        return NodeHelper.getProperty(node,"movementcost");
    }

    @Override
    public void setMovementCost(int movementCost) {
        NodeHelper.setProperty(node,"movementcost",movementCost);
    }

    @Override
    public CombatModifier getCombatModifier() {
        return NodeHelper.getSingleRelationship(node,RelationshipType.TERRAIN_FEATURE_COMBAT_MODIFIER,e -> new CombatModifierNode(e));
    }

    @Override
    public void setCombatModifier(CombatModifier combatModifier) {
        NodeHelper.setSingleRelationship(node,combatModifier,RelationshipType.TERRAIN_FEATURE_COMBAT_MODIFIER, e -> ((CombatModifierNode)e).getUnderlyingNode());
    }

    @Override
    public List<Tile> getOfTiles() {
        return NodeHelper.getRelationship(node,RelationshipType.TERRAIN_FEATURE_TILE,e -> new TileNode(e));
    }

    @Override
    public void setOfTiles(List<Tile> ofTiles) {
        NodeHelper.setSingleRelationship(node,ofTiles,RelationshipType.TERRAIN_FEATURE_TILE, e -> ((TileNode)e).getUnderlyingNode());
    }
}
