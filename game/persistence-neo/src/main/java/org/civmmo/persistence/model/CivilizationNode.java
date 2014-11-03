/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model;

import java.util.List;
import org.civmmo.model.City;
import org.civmmo.model.Civilization;
import org.civmmo.model.Policy;
import org.civmmo.model.SocialPolicy;
import org.civmmo.model.Technology;
import org.civmmo.model.Unit;
import org.civmmo.persistence.model.neospecific.NodeHelper;
import org.civmmo.persistence.model.neospecific.RelationshipType;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Node;

/**
 *
 * @author Mattysek
 */
public class CivilizationNode extends Civilization {
    private final Node node;
    
    public CivilizationNode(Node node)
    {
        this.node = node;
        this.node.addLabel(DynamicLabel.label("Civilization"));
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
        return o instanceof CivilizationNode &&
                this.node.equals( ( (CivilizationNode)o ).getUnderlyingNode() );
    }

    @Override
    public String toString()
    {
        return "Civilization[" + this.getId() + "]";
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
    public long getGold() {
        return NodeHelper.getProperty(node,"gold");
    }

    @Override
    public void setGold(long gold) {
        NodeHelper.setProperty(node,"gold",gold);
    }

    @Override
    public long getCulture() {
        return NodeHelper.getProperty(node,"culture");
    }

    @Override
    public void setCulture(long culture) {
        NodeHelper.setProperty(node,"culture",culture);
    }

    @Override
    public long getScience() {
        return NodeHelper.getProperty(node,"science");
    }

    @Override
    public void setScience(long science) {
        NodeHelper.setProperty(node,"science",science);
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
    public SocialPolicy getCurrentPolicy() {
        return NodeHelper.getSingleRelationship(node, RelationshipType.CIVILIZATION_SOCIAL_POLICY, e -> new SocialPolicyNode(e));
    }

    @Override
    public void setCurrentPolicy(SocialPolicy currentPolicy) {
        NodeHelper.setSingleRelationship(node, currentPolicy, RelationshipType.CIVILIZATION_SOCIAL_POLICY, e -> ((SocialPolicyNode)e).getUnderlyingNode());
    }

    @Override
    public Technology getCurrentlyStudiedTechnology() {
        return NodeHelper.getSingleRelationship(node, RelationshipType.CIVILIZATION_TECHNOLOGY, e -> new TechnologyNode(e));
    }

    @Override
    public void setCurrentlyStudiedTechnology(Technology currentlyStudiedTechnology) {
        NodeHelper.setSingleRelationship(node, currentlyStudiedTechnology, RelationshipType.CIVILIZATION_TECHNOLOGY, e -> ((TechnologyNode)e).getUnderlyingNode());
    }

    @Override
    public List<Civilization> getEnemies() {
        return NodeHelper.getRelationship(node,RelationshipType.CIVILIZATION_CIVILIZATION,e -> new CivilizationNode(e));
    }

    @Override
    public void setEnemies(List<Civilization> enemies) {
        NodeHelper.setRelationship(node,enemies,RelationshipType.CIVILIZATION_CIVILIZATION, e -> ((CivilizationNode)e).getUnderlyingNode());
    }

    @Override
    public List<Civilization> getAllies() {
        return NodeHelper.getRelationship(node,RelationshipType.CIVILIZATION_CIVILIZATION_1,e -> new CivilizationNode(e));
    }

    @Override
    public void setAllies(List<Civilization> allies) {
        NodeHelper.setRelationship(node,allies,RelationshipType.CIVILIZATION_CIVILIZATION_1, e -> ((CivilizationNode)e).getUnderlyingNode());
    }

    @Override
    public List<SocialPolicy> getAvailableSocialPolicies() {
        return NodeHelper.getRelationship(node,RelationshipType.CIVILIZATION_SOCIAL_POLICY_1,e -> new SocialPolicyNode(e));
    }

    @Override
    public void setAvailableSocialPolicies(List<SocialPolicy> availableSocialPolicies) {
        NodeHelper.setRelationship(node,availableSocialPolicies,RelationshipType.CIVILIZATION_SOCIAL_POLICY_1, e -> ((SocialPolicyNode)e).getUnderlyingNode());
    }

    @Override
    public List<Policy> getUnlockedPolicies() {
        return NodeHelper.getRelationship(node,RelationshipType.CIVILIZATION_POLICY,e -> new PolicyNode(e));
    }

    @Override
    public void setUnlockedPolicies(List<Policy> unlockedPolicies) {
        NodeHelper.setRelationship(node,unlockedPolicies,RelationshipType.CIVILIZATION_POLICY, e -> ((PolicyNode)e).getUnderlyingNode());
    }

    @Override
    public List<Technology> getKnownTechnologies() {
        return NodeHelper.getRelationship(node,RelationshipType.CIVILIZATION_TECHNOLOGY_1,e -> new TechnologyNode(e));
    }

    @Override
    public void setKnownTechnologies(List<Technology> knownTechnologies) {
        NodeHelper.setRelationship(node,knownTechnologies,RelationshipType.CIVILIZATION_TECHNOLOGY_1, e -> ((TechnologyNode)e).getUnderlyingNode());
    }

    @Override
    public List<City> getCities() {
        return NodeHelper.getRelationship(node,RelationshipType.CITY_CIVILIZATION,e -> new CityNode(e));
    }

    @Override
    public void setCities(List<City> cities) {
        NodeHelper.setRelationship(node,cities,RelationshipType.CITY_CIVILIZATION, e -> ((CityNode)e).getUnderlyingNode());
    }

    @Override
    public List<Unit> getUnits() {
        return NodeHelper.getRelationship(node,RelationshipType.CIVILIZATION_UNIT,e -> new UnitNode(e));
    }

    @Override
    public void setUnits(List<Unit> units) {
        NodeHelper.setRelationship(node,units,RelationshipType.CIVILIZATION_UNIT, e -> ((UnitNode)e).getUnderlyingNode());
    }
}
