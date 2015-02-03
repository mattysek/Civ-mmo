/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.persistence.model.neospecific;

/**
 *
 * @author Mattysek
 */
public enum RelationshipType implements org.neo4j.graphdb.RelationshipType {
    ACTION_COMBAT_MODIFIER, // modifier of action
    ACTION_UNIT_TYPE,
    BUILDING_TECHNOLOGY,
    BUILDING_RESOURCE,
    BUILDING_CITY, //worked by
    BUILDING_CITY_2, //CURRENTLY CONSTRUCTED
    BUILDING_CITY_3, // constructed
    CITY_TILE, // CENTER
    CITY_TILE_2, // visible tiles
    CITY_TILE_3, //controlled tiles
    CITY_TILE_4, // worked tiles
    CITY_CIVILIZATION, //OWNED BY
    CITY_UNIT, //CURRENTLY CONSTRUCTED
    CITY_UNIT_2, //ATTACKED BY
    CITY_TRADE_ROUTE, //from
    CITY_TRADE_ROUTE_2, //to
    CIVILIZATION_SOCIAL_POLICY, //current cosial policy
    CIVILIZATION_SOCIAL_POLICY_1, // available social policies
    CIVILIZATION_TECHNOLOGY, //currently studied
    CIVILIZATION_CIVILIZATION, //enemies
    CIVILIZATION_CIVILIZATION_1, //allies
    CIVILIZATION_POLICY, //unlocked policies
    CIVILIZATION_TECHNOLOGY_1, //known technologies
    CIVILIZATION_UNIT, //units of civilization
    IMPROVEMENT_TILE, //improvement of tile
    POLICY_SOCIAL_POLICY, //social policy of policy
    PROMOTION_UNIT, //promoted units
    PROMOTION_UNIT_TYPE, //unit type afected by promotion
    PROMOTION_TECHNOLOGY, //prerequisity
    REGION_TILE, //tiles of region
    RESOURCE_IMPROVEMENT, //needed improvement
    RESOURCE_TECHNOLOGY, //revealed by
    RESOURCE_UNIT, //required by unit
    RESOURCE_TILE, //can be found on
    RIVER_TILE, //tile of river
    TECHNOLOGY_UNIT_TYPE, //technology revealing unit type
    TECHNOLOGY_TECHNOLOGY, //prerequisity
    TERRAIN_FEATURE_COMBAT_MODIFIER, //
    TERRAIN_FEATURE_TILE, //feature of tile
    TERRAIN_TYPE_COMBAT_MODIFIER,
    TERRAIN_TYPE_TILE,
    TILE_UNIT, //military unit
    TILE_UNIT_1, //civil unit
    TILE_TRADE_ROUTE,
    TILE_UNIT_2, //visible for units
    TILE_UNIT_3, //controlled by unit
    UNIT_UNIT_TYPE,
    UNIT_UNIT,//attacked by
}
