package org.civmmo.persistence.service;

import java.util.stream.Collectors;
import org.civmmo.contracts.model.*;
import org.civmmo.persistence.model.*;

public abstract class BaseService {

    protected Action translate(ActionDto object) {
        if(object == null) return null;
        
        Action result = new Action();
        result.setId(object.getId());
        result.setName(object.getName());

        if(object.getCombatModifiers() != null)
        {
            result.setCombatModifiers(
                    object.getCombatModifiers().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        
        return result;
    }

    protected ActionDto translate(Action object) {
        if(object == null) return null;
        
        ActionDto result = new ActionDto();
        result.setId(object.getId());
        result.setName(object.getName());
            
        if(object.getCombatModifiers() != null)
        {
            result.setCombatModifiers(
                    object.getCombatModifiers().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        
        return result;
    }
    
    protected CombatModifier translate(CombatModifierDto object){
        if(object == null) return null;
        
        CombatModifier result = new CombatModifier();
        result.setId(object.getId());
        result.setValue(object.getValue());
        
        result.setAfectedAction(translate(object.getAfectedAction()));
        
        return result;
    }
    
    protected CombatModifierDto translate(CombatModifier object){
        if(object == null) return null;
        
        CombatModifierDto result = new CombatModifierDto();
        result.setId(object.getId());
        result.setValue(object.getValue());
        
        result.setAfectedAction(translate(object.getAfectedAction()));
        
        return result;
    }
    
    protected Building translate(BuildingDto object) {
        if(object == null) return null;
        
        Building result = new Building();
        result.setId(object.getId());
        result.setName(object.getName());
        result.setCost(object.getCost());
        result.setMaintenence(object.getMaintenence());
        result.setSpecialistsSlots(object.getSpecialistsSlots());
        
        if(object.getCurrentlyConstructedBy() != null)
        {
            result.setCurrentlyConstructedBy(
                    object.getCurrentlyConstructedBy().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        
        if(object.getRequiredResources() != null)
        {
            result.setRequiredResources(
                    object.getRequiredResources().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        
        if(object.getRequiredTechnologies() != null)
        {
            result.setRequiredTechnologies(
                    object.getRequiredTechnologies().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        
        if(object.getWorkedBy() != null)
        {
            result.setWorkedBy(
                object.getWorkedBy().stream()
                      .map(e -> translate(e))
                      .collect(Collectors.toList()));
        }
        
        return result;
    }
    
    protected BuildingDto translate(Building object) {
        if(object == null) return null;
        
        BuildingDto result = new BuildingDto();
        result.setId(object.getId());
        result.setName(object.getName());
        result.setCost(object.getCost());
        result.setMaintenence(object.getMaintenence());
        result.setSpecialistsSlots(object.getSpecialistsSlots());
        
        if(object.getCurrentlyConstructedBy() != null)
        {
            result.setCurrentlyConstructedBy(
                    object.getCurrentlyConstructedBy().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        
        if(object.getRequiredResources() != null)
        {
            result.setRequiredResources(
                    object.getRequiredResources().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        
        if(object.getRequiredTechnologies() != null)
        {
            result.setRequiredTechnologies(
                    object.getRequiredTechnologies().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        
        if(object.getWorkedBy() != null)
        {
            result.setWorkedBy(
                object.getWorkedBy().stream()
                      .map(e -> translate(e))
                      .collect(Collectors.toList()));
        }
        
        return result;
    }
    
    protected City translate(CityDto object) {
        if(object == null) return null;
        
        City result = new City();
        result.setCenter(translate(object.getCenter()));
        result.setCitizens(object.getCitizens());
        if(object.getConstructedBuildings() != null)
        {
            result.setConstructedBuildings(
                    object.getConstructedBuildings().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        if(object.getControledTiles() != null)
        {
            result.setControledTiles(
                    object.getControledTiles().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        result.setCulture(object.getCulture());
        result.setCurrentlyConstructedBuilding(translate(object.getCurrentlyConstructedBuilding()));
        result.setCurrentlyConstructedUnit(translate(object.getCurrentlyConstructedUnit()));
        result.setFood(object.getFood());
        result.setGold(object.getGold());
        result.setHitPoints(object.getHitPoints());
        result.setId(object.getId());
        result.setName(object.getName());
        result.setOwnedBy(translate(object.getOwnedBy()));
        result.setProduction(object.getProduction());
        result.setRange(object.getRange());
        result.setScience(object.getScience());
        if(object.getTradeRoutesFrom() != null)
        {
            result.setTradeRoutesFrom(
                    object.getTradeRoutesFrom().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        if(object.getTradeRoutesTo() != null)
        {
            result.setTradeRoutesTo(
                    object.getTradeRoutesTo().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        if(object.getVisibleTiles() != null)
        {
            result.setVisibleTiles(
                    object.getVisibleTiles().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        if(object.getWorkedBuildings() != null)
        {
            result.setWorkedBuildings(
                    object.getWorkedBuildings().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        if(object.getWorkedTiles() != null)
        {
            result.setWorkedTiles(
                    object.getWorkedTiles().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        
        return result;
    }
    
    protected CityDto translate(City object) {
        if(object == null) return null;
        
        CityDto result = new CityDto();
        result.setCenter(translate(object.getCenter()));
        result.setCitizens(object.getCitizens());
        if(object.getConstructedBuildings() != null)
        {
            result.setConstructedBuildings(
                    object.getConstructedBuildings().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        if(object.getControledTiles() != null)
        {
            result.setControledTiles(
                    object.getControledTiles().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        result.setCulture(object.getCulture());
        result.setCurrentlyConstructedBuilding(translate(object.getCurrentlyConstructedBuilding()));
        result.setCurrentlyConstructedUnit(translate(object.getCurrentlyConstructedUnit()));
        result.setFood(object.getFood());
        result.setGold(object.getGold());
        result.setHitPoints(object.getHitPoints());
        result.setId(object.getId());
        result.setName(object.getName());
        result.setOwnedBy(translate(object.getOwnedBy()));
        result.setProduction(object.getProduction());
        result.setRange(object.getRange());
        result.setScience(object.getScience());
        if(object.getTradeRoutesFrom() != null)
        {
            result.setTradeRoutesFrom(
                    object.getTradeRoutesFrom().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        if(object.getTradeRoutesTo() != null)
        {
            result.setTradeRoutesTo(
                    object.getTradeRoutesTo().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        if(object.getVisibleTiles() != null)
        {
            result.setVisibleTiles(
                    object.getVisibleTiles().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        if(object.getWorkedBuildings() != null)
        {
            result.setWorkedBuildings(
                    object.getWorkedBuildings().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        if(object.getWorkedTiles() != null)
        {
            result.setWorkedTiles(
                    object.getWorkedTiles().stream()
                          .map(e -> translate(e))
                          .collect(Collectors.toList()));
        }
        
        return result;
    }
    
    protected Civilization translate(CivilizationDto object) {
        return null;
    }
    
    protected CivilizationDto translate(Civilization object) {
        return null;
    }
    
    protected Improvement translate(ImprovementDto object) {
        return null;
    }
    
    protected ImprovementDto translate(Improvement object) {
        return null;
    }
    
    protected Policy translate(PolicyDto object) {
        return null;
    }
    
    protected PolicyDto translate(Policy object) {
        return null;
    }
    
    protected Promotion translate(PromotionDto object) {
        return null;
    }
    
    protected PromotionDto translate(Promotion object) {
        return null;
    }
    
    protected Region translate(RegionDto object) {
        return null;
    }
    
    protected RegionDto translate(Region object) {
        return null;
    }
    
    protected Resource translate(ResourceDto object) {
        return null;
    }
    
    protected ResourceDto translate(Resource object) {
        return null;
    }
    
    protected River translate(RiverDto object) {
        return null;
    }
    
    protected RiverDto translate(River object) {
        return null;
    }
    
    protected SocialPolicy translate(SocialPolicyDto object) {
        return null;
    }
    
    protected SocialPolicyDto translate(SocialPolicy object) {
        return null;
    }
    
    protected Technology translate(TechnologyDto object) {
        return null;
    }
    
    protected TechnologyDto translate(Technology object) {
        return null;
    }
    
    protected TerrainFeature translate(TerrainFeatureDto object) {
        return null;
    }
    
    protected TerrainFeatureDto translate(TerrainFeature object) {
        return null;
    }
    
    protected TerrainType translate(TerrainTypeDto object) {
        return null;
    }
    
    protected TerrainTypeDto translate(TerrainType object) {
        return null;
    }
    
    protected Tile translate(TileDto object) {
        return null;
    }
    
    protected TileDto translate(Tile object) {
        return null;
    }
    
    protected TradeRoute translate(TradeRouteDto object) {
        return null;
    }
    
    protected TradeRouteDto translate(TradeRoute object) {
        return null;
    }
    
    protected Unit translate(UnitDto object) {
        return null;
    }
    
    protected UnitDto translate(Unit object) {
        return null;
    }
    
    protected UnitType translate(UnitTypeDto object) {
        return null;
    }
    
    protected UnitTypeDto translate(UnitType object) {
        return null;
    }
}
