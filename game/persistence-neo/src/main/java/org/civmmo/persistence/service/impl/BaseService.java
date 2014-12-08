package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.civmmo.contracts.model.*;
import org.civmmo.model.*;
import org.civmmo.persistence.model.*;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

public abstract class BaseService {
    
    //@EJB
    //protected GraphDatabaseServiceBean graphDb;
    
    protected static final int MAX_LEVEL = 2;
    protected static final int START_LEVEL = 0;
            
    protected void runInTransaction(Runnable runnable)
    {
        try(Transaction tx = GraphDatabaseServiceBean.getGraphDb().beginTx())
        {
            runnable.run();
            tx.success();
        }
        catch(Exception ex)
        {
            System.out.print(ex);
        }
    }
    
    protected <T> T runInTransaction(Callable<T> callable)
    {
        T result = null;
        try(Transaction tx = GraphDatabaseServiceBean.getGraphDb().beginTx())
        {
            result = callable.call();
            tx.success();
        }
        catch(Exception ex)
        {
            System.out.print(ex);
        }
        return result;
    }
        
    protected <T, S> void set(Consumer<List<T>> consumer, Supplier<List<S>> supplier, Function<S, T> translator) {
        List<S> value = supplier.get();
        if (value != null) {
            consumer.accept(value.stream()
                    .map(translator)
                    .collect(Collectors.toList()));
        }
    }
    
    private Node getNode(TranslateOption option, long id)
    {
        Node result = null;
        if (option.equals(TranslateOption.GetById))
        {
            try
            {
                result = GraphDatabaseServiceBean.getGraphDb().getNodeById(id);
            }
            catch(Exception ex){}
        }
        else
        {
            result = GraphDatabaseServiceBean.getGraphDb().createNode();
        }
        return result;
    }

    protected Action translate(ActionDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }
        
        Action result = new ActionNode(getNode(option, object.getId()));
        
        result.setId(object.getId());
        result.setName(object.getName());

        set(result::setCombatModifiers,
                object::getCombatModifiers,
                e -> translate(e, option));
        
        set(result::setAplicableTo,
                object::getAplicableTo,
                e -> translate(e, option));
        
        return result;
    }

    protected ActionDto translate(Action object, int level) {
        if (object == null) {
            return null;
        }

        ActionDto result = new ActionDto();

        result.setId(object.getId());
        result.setName(object.getName());

        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level,level};
            set(result::setCombatModifiers,
                object::getCombatModifiers,
                e -> translate(e,help[0]));
        
            set(result::setAplicableTo,
                    object::getAplicableTo,
                    e -> translate(e,help[1]));
        }
        return result;
    }

    protected CombatModifier translate(CombatModifierDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        CombatModifier result = new CombatModifierNode(getNode(option, object.getId()));

        result.setId(object.getId());
        result.setValue(object.getValue());
        result.setAfectedAction(translate(object.getAfectedAction(),option));

        return result;
    }

    protected CombatModifierDto translate(CombatModifier object, int level) {
        if (object == null) {
            return null;
        }

        CombatModifierDto result = new CombatModifierDto();

        result.setId(object.getId());
        result.setValue(object.getValue());
        
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level};
            result.setAfectedAction(translate(object.getAfectedAction(),help[0]));
        }
        
        return result;
    }

    protected Building translate(BuildingDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        Building result = new BuildingNode(getNode(option, object.getId()));

        result.setId(object.getId());
        result.setName(object.getName());
        result.setCost(object.getCost());
        result.setMaintenence(object.getMaintenence());
        result.setSpecialistsSlots(object.getSpecialistsSlots());

        set(result::setCurrentlyConstructedBy,
                object::getCurrentlyConstructedBy,
                e -> translate(e, option));
        set(result::setRequiredResources,
                object::getRequiredResources,
                e -> translate(e, option));
        set(result::setRequiredTechnologies,
                object::getRequiredTechnologies,
                e -> translate(e, option));
        set(result::setWorkedBy,
                object::getWorkedBy,
                e -> translate(e, option));

        return result;
    }

    protected BuildingDto translate(Building object, int level) {
        if (object == null) {
            return null;
        }

        BuildingDto result = new BuildingDto();

        result.setId(object.getId());
        result.setName(object.getName());
        result.setCost(object.getCost());
        result.setMaintenence(object.getMaintenence());
        result.setSpecialistsSlots(object.getSpecialistsSlots());

        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level,level,level,level};
        set(result::setCurrentlyConstructedBy,
                object::getCurrentlyConstructedBy,
                e -> translate(e,help[0]));
        set(result::setRequiredResources,
                object::getRequiredResources,
                e -> translate(e,help[1]));
        set(result::setRequiredTechnologies,
                object::getRequiredTechnologies,
                e -> translate(e,help[2]));
        set(result::setWorkedBy,
                object::getWorkedBy,
                e -> translate(e,help[3]));
        }
        return result;
    }

    protected City translate(CityDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        City result = new CityNode(getNode(option, object.getId()));
        result.setCenter(translate(object.getCenter(),option));
        result.setCitizens(object.getCitizens());
        set(result::setConstructedBuildings,
                object::getConstructedBuildings,
                e -> translate(e,option));
        set(result::setControledTiles,
                object::getControledTiles,
                e -> translate(e,option));
        result.setCulture(object.getCulture());
        result.setCurrentlyConstructedBuilding(translate(object.getCurrentlyConstructedBuilding(),option));
        result.setCurrentlyConstructedUnit(translate(object.getCurrentlyConstructedUnit(),option));
        result.setFood(object.getFood());
        result.setGold(object.getGold());
        result.setHitPoints(object.getHitPoints());
        result.setId(object.getId());
        result.setName(object.getName());
        result.setOwnedBy(translate(object.getOwnedBy(),option));
        result.setProduction(object.getProduction());
        result.setRange(object.getRange());
        result.setScience(object.getScience());
        set(result::setTradeRoutesFrom,
                object::getTradeRoutesFrom,
                e -> translate(e,option));
        set(result::setTradeRoutesTo,
                object::getTradeRoutesTo,
                e -> translate(e,option));
        set(result::setVisibleTiles,
                object::getVisibleTiles,
                e -> translate(e,option));
        set(result::setWorkedBuildings,
                object::getWorkedBuildings,
                e -> translate(e,option));
        set(result::setWorkedTiles,
                object::getWorkedTiles,
                e -> translate(e,option));

        return result;
    }

    protected CityDto translate(City object, int level) {
        if (object == null) {
            return null;
        }

        CityDto result = new CityDto();
        result.setCitizens(object.getCitizens());
        result.setCulture(object.getCulture());
        result.setFood(object.getFood());
        result.setGold(object.getGold());
        result.setHitPoints(object.getHitPoints());
        result.setId(object.getId());
        result.setName(object.getName());
        result.setProduction(object.getProduction());
        result.setRange(object.getRange());
        result.setScience(object.getScience());
        
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level,level,level,level,level,level,level,level,level,level,level};
        set(result::setConstructedBuildings,
                object::getConstructedBuildings,
                e -> translate(e,help[0]));
        set(result::setControledTiles,
                object::getControledTiles,
                e -> translate(e,help[1]));
        result.setCurrentlyConstructedBuilding(translate(object.getCurrentlyConstructedBuilding(),help[2]));
        result.setCurrentlyConstructedUnit(translate(object.getCurrentlyConstructedUnit(),help[3]));
        result.setOwnedBy(translate(object.getOwnedBy(),help[4]));
        set(result::setTradeRoutesFrom,
                object::getTradeRoutesFrom,
                e -> translate(e,help[5]));
        set(result::setTradeRoutesTo,
                object::getTradeRoutesTo,
                e -> translate(e,help[6]));
        set(result::setVisibleTiles,
                object::getVisibleTiles,
                e -> translate(e,help[7]));
        set(result::setWorkedBuildings,
                object::getWorkedBuildings,
                e -> translate(e,help[8]));
        set(result::setWorkedTiles,
                object::getWorkedTiles,
                e -> translate(e,help[9]));
        result.setCenter(translate(object.getCenter(),help[10]));
        }
        return result;
    }

    protected Civilization translate(CivilizationDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        Civilization result = new CivilizationNode(getNode(option, object.getId()));

        set(result::setAllies,
                object::getAllies,
                e -> translate(e,option));
        set(result::setAvailableSocialPolicies,
                object::getAvailableSocialPolicies,
                e -> translate(e,option));
        set(result::setCities,
                object::getCities,
                e -> translate(e,option));
        result.setCulture(object.getCulture());
        result.setCurrentPolicy(translate(object.getCurrentPolicy(),option));
        result.setCurrentlyStudiedTechnology(translate(object.getCurrentlyStudiedTechnology(),option));
        set(result::setEnemies,
                object::getEnemies,
                e -> translate(e,option));
        result.setGold(object.getGold());
        result.setHappiness(object.getHappiness());
        result.setId(object.getId());
        set(result::setKnownTechnologies,
                object::getKnownTechnologies,
                e -> translate(e,option));
        result.setName(object.getName());
        result.setScience(object.getScience());
        set(result::setUnits,
                object::getUnits,
                e -> translate(e,option));
        set(result::setUnlockedPolicies,
                object::getUnlockedPolicies,
                e -> translate(e,option));

        return result;
    }

    protected CivilizationDto translate(Civilization object, int level) {
        if (object == null) {
            return null;
        }

        CivilizationDto result = new CivilizationDto();

        result.setCulture(object.getCulture());
        result.setGold(object.getGold());
        result.setHappiness(object.getHappiness());
        result.setId(object.getId());
        result.setName(object.getName());
        result.setScience(object.getScience());
        
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level,level,level,level,level,level,level,level,level};
        set(result::setAllies,
                object::getAllies,
                e -> translate(e,help[0]));
        set(result::setAvailableSocialPolicies,
                object::getAvailableSocialPolicies,
                e -> translate(e,help[1]));
        set(result::setCities,
                object::getCities,
                e -> translate(e,help[2]));
        result.setCurrentPolicy(translate(object.getCurrentPolicy(),help[3]));
        result.setCurrentlyStudiedTechnology(translate(object.getCurrentlyStudiedTechnology(),help[4]));
        set(result::setEnemies,
                object::getEnemies,
                e -> translate(e,help[5]));
        set(result::setKnownTechnologies,
                object::getKnownTechnologies,
                e -> translate(e,help[6]));
        set(result::setUnits,
                object::getUnits,
                e -> translate(e,help[7]));
        set(result::setUnlockedPolicies,
                object::getUnlockedPolicies,
                e -> translate(e,help[8]));
        }
        return result;
    }

    protected Improvement translate(ImprovementDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        Improvement result = new ImprovementNode(getNode(option, object.getId()));

        result.setId(object.getId());
        result.setName(object.getName());
        set(result::setOfTiles,
                object::getOfTiles,
                e -> translate(e,option));

        return result;
    }

    protected ImprovementDto translate(Improvement object, int level) {
        if (object == null) {
            return null;
        }

        ImprovementDto result = new ImprovementDto();

        result.setId(object.getId());
        result.setName(object.getName());
        
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level};
            set(result::setOfTiles,
                    object::getOfTiles,
                    e -> translate(e,help[0]));
        }
        return result;
    }

    protected Policy translate(PolicyDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        Policy result = new PolicyNode(getNode(option, object.getId()));

        result.setCost(object.getCost());
        result.setId(object.getId());
        result.setName(object.getName());
        result.setSocialPolicy(translate(object.getSocialPolicy(),option));

        return result;
    }

    protected PolicyDto translate(Policy object, int level) {
        if (object == null) {
            return null;
        }

        PolicyDto result = new PolicyDto();

        result.setCost(object.getCost());
        result.setId(object.getId());
        result.setName(object.getName());
        
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level};
            result.setSocialPolicy(translate(object.getSocialPolicy(),help[0]));
        }

        return result;
    }

    protected Promotion translate(PromotionDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        Promotion result = new PromotionNode(getNode(option, object.getId()));

        set(result::setAffectedBy,
                object::getAffectedBy,
                e -> translate(e,option));
        result.setId(object.getId());
        result.setName(object.getName());
        set(result::setPrerequisities,
                object::getPrerequisities,
                e -> translate(e,option));
        set(result::setUnits,
                object::getUnits,
                e -> translate(e,option));

        return result;
    }

    protected PromotionDto translate(Promotion object,int level) {
        if (object == null) {
            return null;
        }

        PromotionDto result = new PromotionDto();

        result.setId(object.getId());
        result.setName(object.getName());
        
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level,level,level};
        set(result::setAffectedBy,
                object::getAffectedBy,
                e -> translate(e,help[0]));
        set(result::setPrerequisities,
                object::getPrerequisities,
                e -> translate(e,help[1]));
        set(result::setUnits,
                object::getUnits,
                e -> translate(e,help[2]));
        }
        return result;
    }

    protected Region translate(RegionDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        Region result = new RegionNode(getNode(option, object.getId()));

        result.setId(object.getId());
        set(result::setTiles,
                object::getTiles,
                e -> translate(e,option));

        return result;
    }

    protected RegionDto translate(Region object, int level) {
        if (object == null) {
            return null;
        }

        RegionDto result = new RegionDto();

        result.setId(object.getId());
        
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level};
        set(result::setTiles,
                object::getTiles,
                e -> translate(e,help[0]));
        }

        return result;
    }

    protected Resource translate(ResourceDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        Resource result = new ResourceNode(getNode(option, object.getId()));

        set(result::setCanBeFoundOnTiles,
                object::getCanBeFoundOnTiles,
                e -> translate(e,option));
        result.setFood(object.getFood());
        result.setGold(object.getGold());
        result.setHappiness(object.getHappiness());
        result.setId(object.getId());
        result.setImprovement(translate(object.getImprovement(),option));
        result.setName(object.getName());
        result.setProduction(object.getProduction());
        set(result::setRequiredByBuildings,
                object::getRequiredByBuildings,
                e -> translate(e,option));
        set(result::setRequiredByUnits,
                object::getRequiredByUnits,
                e -> translate(e,option));
        result.setRevealedBy(translate(object.getRevealedBy(),option));

        return result;
    }

    protected ResourceDto translate(Resource object, int level) {
        if (object == null) {
            return null;
        }

        ResourceDto result = new ResourceDto();

        result.setFood(object.getFood());
        result.setGold(object.getGold());
        result.setHappiness(object.getHappiness());
        result.setId(object.getId());
        result.setName(object.getName());
        result.setProduction(object.getProduction());
        
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level,level,level,level,level};
        set(result::setCanBeFoundOnTiles,
                object::getCanBeFoundOnTiles,
                e -> translate(e,help[0]));
        result.setImprovement(translate(object.getImprovement(),help[1]));
        set(result::setRequiredByBuildings,
                object::getRequiredByBuildings,
                e -> translate(e,help[2]));
        set(result::setRequiredByUnits,
                object::getRequiredByUnits,
                e -> translate(e,help[3]));
        result.setRevealedBy(translate(object.getRevealedBy(),help[4]));
        }

        return result;
    }

    protected River translate(RiverDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        River result = new RiverNode(getNode(option, object.getId()));

        result.setId(object.getId());
        set(result::setTiles,
                object::getTiles,
                e -> translate(e,option));

        return result;
    }

    protected RiverDto translate(River object, int level) {
        if (object == null) {
            return null;
        }

        RiverDto result = new RiverDto();

        result.setId(object.getId());
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level};
        set(result::setTiles,
                object::getTiles,
                e -> translate(e,help[0]));
        }

        return result;
    }

    protected SocialPolicy translate(SocialPolicyDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        SocialPolicy result = new SocialPolicyNode(getNode(option, object.getId()));

        result.setId(object.getId());
        result.setBaseCost(object.getBaseCost());
        result.setName(object.getName());
        set(result::setCurrentlyUsedBy,
                object::getCurrentlyUsedBy,
                e -> translate(e,option));
        set(result::setPolicies,
                object::getPolicies,
                e -> translate(e,option));

        return result;
    }

    protected SocialPolicyDto translate(SocialPolicy object, int level) {
        if (object == null) {
            return null;
        }

        SocialPolicyDto result = new SocialPolicyDto();

        result.setId(object.getId());
        result.setBaseCost(object.getBaseCost());
        result.setName(object.getName());
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level,level};
        set(result::setCurrentlyUsedBy,
                object::getCurrentlyUsedBy,
                e -> translate(e,help[0]));
        set(result::setPolicies,
                object::getPolicies,
                e -> translate(e,help[1]));
        }

        return result;
    }

    protected Technology translate(TechnologyDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        Technology result = new TechnologyNode(getNode(option, object.getId()));

        result.setCost(object.getCost());
        result.setId(object.getId());
        set(result::setKnownBy,
                object::getKnownBy,
                e -> translate(e,option));
        result.setName(object.getName());
        set(result::setPrerequisities,
                object::getPrerequisities,
                e -> translate(e,option));
        set(result::setRevealsBuildings,
                object::getRevealsBuildings,
                e -> translate(e,option));
        set(result::setRevealsResources,
                object::getRevealsResources,
                e -> translate(e,option));
        set(result::setRevealsUnits,
                object::getRevealsUnits,
                e -> translate(e,option));

        return result;
    }

    protected TechnologyDto translate(Technology object,int level) {
        if (object == null) {
            return null;
        }

        TechnologyDto result = new TechnologyDto();

        result.setCost(object.getCost());
        result.setId(object.getId());
        result.setName(object.getName());
        
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level,level,level,level,level};
        set(result::setKnownBy,
                object::getKnownBy,
                e -> translate(e,help[0]));
        
        set(result::setPrerequisities,
                object::getPrerequisities,
                e -> translate(e,help[1]));
        set(result::setRevealsBuildings,
                object::getRevealsBuildings,
                e -> translate(e,help[2]));
        set(result::setRevealsResources,
                object::getRevealsResources,
                e -> translate(e,help[3]));
        set(result::setRevealsUnits,
                object::getRevealsUnits,
                e -> translate(e,help[4]));
        }
        return result;
    }

    protected TerrainFeature translate(TerrainFeatureDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        TerrainFeature result = new TerrainFeatureNode(getNode(option, object.getId()));

        result.setCombatModifier(translate(object.getCombatModifier(),option));
        result.setFood(object.getFood());
        result.setGold(object.getGold());
        result.setId(object.getId());
        result.setMovementCost(object.getMovementCost());
        result.setName(object.getName());
        result.setProduction(object.getProduction());
        set(result::setOfTiles,
                object::getOfTiles,
                e -> translate(e,option));

        return result;
    }

    protected TerrainFeatureDto translate(TerrainFeature object, int level) {
        if (object == null) {
            return null;
        }

        TerrainFeatureDto result = new TerrainFeatureDto();

        result.setFood(object.getFood());
        result.setGold(object.getGold());
        result.setId(object.getId());
        result.setMovementCost(object.getMovementCost());
        result.setName(object.getName());
        result.setProduction(object.getProduction());
        
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level,level};
        result.setCombatModifier(translate(object.getCombatModifier(),help[0]));
        set(result::setOfTiles,
                object::getOfTiles,
                e -> translate(e,help[1]));
        }
        return result;
    }

    protected TerrainType translate(TerrainTypeDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        TerrainType result = new TerrainTypeNode(getNode(option, object.getId()));

        result.setCombatModifier(translate(object.getCombatModifier(),option));
        result.setFood(object.getFood());
        result.setGold(object.getGold());
        result.setId(object.getId());
        result.setMovementCost(object.getMovementCost());
        result.setName(object.getName());
        set(result::setOfTiles,
                object::getOfTiles,
                e -> translate(e,option));
        result.setProduction(object.getProduction());

        return result;
    }

    protected TerrainTypeDto translate(TerrainType object, int level) {
        if (object == null) {
            return null;
        }

        TerrainTypeDto result = new TerrainTypeDto();

        result.setFood(object.getFood());
        result.setGold(object.getGold());
        result.setId(object.getId());
        result.setMovementCost(object.getMovementCost());
        result.setName(object.getName());
        result.setProduction(object.getProduction());
        
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level,level};
        result.setCombatModifier(translate(object.getCombatModifier(),help[0]));
        set(result::setOfTiles,
                object::getOfTiles,
                e -> translate(e,help[1]));
        }

        return result;
    }

    protected Tile translate(TileDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        Tile result = new TileNode(getNode(option, object.getId()));

        result.setCity(translate(object.getCity(),option));
        result.setCivilUnit(translate(object.getCivilUnit(),option));
        set(result::setControledByCity,
                object::getControledByCity,
                e -> translate(e,option));
        set(result::setControledByUnit,
                object::getControledByUnit,
                e -> translate(e,option));
        result.setId(object.getId());
        result.setImprovement(translate(object.getImprovement(),option));
        result.setMilitaryUnit(translate(object.getMilitaryUnit(),option));
        result.setRegion(translate(object.getRegion(),option));
        result.setResource(translate(object.getResource(),option));
        set(result::setRivers,
                object::getRivers,
                e -> translate(e,option));
        result.setTerrainFeature(translate(object.getTerrainFeature(),option));
        result.setTerrainType(translate(object.getTerrainType(),option));
        set(result::setTradeRoutes,
                object::getTradeRoutes,
                e -> translate(e,option));
        set(result::setVisibleForCities,
                object::getVisibleForCities,
                e -> translate(e,option));
        set(result::setVisibleForUnits,
                object::getVisibleForUnits,
                e -> translate(e,option));
        set(result::setWorkedBy,
                object::getWorkedBy,
                e -> translate(e,option));
        result.setX(object.getX());
        result.setY(object.getY());

        return result;
    }

    protected TileDto translate(Tile object, int level) {
        if (object == null) {
            return null;
        }

        TileDto result = new TileDto();

        result.setId(object.getId());
        result.setX(object.getX());
        result.setY(object.getY());
        
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level,level,level,level,level,level,level,level,level,level,level,level,level,level,level};
        result.setCity(translate(object.getCity(),help[0]));
        result.setCivilUnit(translate(object.getCivilUnit(),help[1]));
        set(result::setControledByCity,
                object::getControledByCity,
                e -> translate(e,help[2]));
        set(result::setControledByUnit,
                object::getControledByUnit,
                e -> translate(e,help[3]));
        result.setImprovement(translate(object.getImprovement(),help[4]));
        result.setMilitaryUnit(translate(object.getMilitaryUnit(),help[5]));
        result.setRegion(translate(object.getRegion(),help[6]));
        result.setResource(translate(object.getResource(),help[7]));
        set(result::setRivers,
                object::getRivers,
                e -> translate(e,help[8]));
        result.setTerrainFeature(translate(object.getTerrainFeature(),help[9]));
        result.setTerrainType(translate(object.getTerrainType(),help[10]));
        set(result::setTradeRoutes,
                object::getTradeRoutes,
                e -> translate(e,help[11]));
        set(result::setVisibleForCities,
                object::getVisibleForCities,
                e -> translate(e,help[12]));
        set(result::setVisibleForUnits,
                object::getVisibleForUnits,
                e -> translate(e,help[13]));
        set(result::setWorkedBy,
                object::getWorkedBy,
                e -> translate(e,help[14]));
        }

        return result;
    }

    protected TradeRoute translate(TradeRouteDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        TradeRoute result = new TradeRouteNode(getNode(option, object.getId()));

        result.setFrom(translate(object.getFrom(),option));
        result.setId(object.getId());
        set(result::setTiles,
                object::getTiles,
                e -> translate(e,option));
        result.setTo(translate(object.getTo(),option));

        return result;
    }

    protected TradeRouteDto translate(TradeRoute object, int level) {
        if (object == null) {
            return null;
        }

        TradeRouteDto result = new TradeRouteDto();

        result.setId(object.getId());
        
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level,level,level};
        
        result.setFrom(translate(object.getFrom(),help[0]));
        
        set(result::setTiles,
                object::getTiles,
                e -> translate(e,help[1]));
        result.setTo(translate(object.getTo(),help[2]));

        }
        return result;
    }

    protected Unit translate(UnitDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        Unit result = new UnitNode(getNode(option, object.getId()));

        result.setCombatStrength(object.getCombatStrength());
        set(result::setControledTiles,
                object::getControledTiles,
                e -> translate(e,option));
        result.setCost(object.getCost());
        set(result::setCurrentlyConstructedBy,
                object::getCurrentlyConstructedBy,
                e -> translate(e,option));
        result.setExperience(object.getExperience());
        result.setHitPoints(object.getHitPoints());
        result.setId(object.getId());
        result.setMovementPoints(object.getMovementPoints());
        result.setName(object.getName());
        result.setOwnedBy(translate(object.getOwnedBy(),option));
        result.setPosition(translate(object.getPosition(),option));
        set(result::setPromotions,
                object::getPromotions,
                e -> translate(e,option));
        result.setRange(object.getRange());
        result.setRangedCombatStrength(object.getRangedCombatStrength());
        set(result::setTypes,
                object::getTypes,
                e -> translate(e,option));
        set(result::setVisibleTiles,
                object::getVisibleTiles,
                e -> translate(e,option));

        return result;
    }

    protected UnitDto translate(Unit object, int level) {
        if (object == null) {
            return null;
        }

        UnitDto result = new UnitDto();

        result.setCombatStrength(object.getCombatStrength());
        result.setCost(object.getCost());
        result.setExperience(object.getExperience());
        result.setHitPoints(object.getHitPoints());
        result.setId(object.getId());
        result.setMovementPoints(object.getMovementPoints());
        result.setName(object.getName());
        result.setRange(object.getRange());
        result.setRangedCombatStrength(object.getRangedCombatStrength());
        
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level,level,level,level,level,level,level};
        set(result::setControledTiles,
                object::getControledTiles,
                e -> translate(e,help[0]));
        set(result::setCurrentlyConstructedBy,
                object::getCurrentlyConstructedBy,
                e -> translate(e,help[1]));
        result.setOwnedBy(translate(object.getOwnedBy(),help[2]));
        result.setPosition(translate(object.getPosition(),help[3]));
        set(result::setPromotions,
                object::getPromotions,
                e -> translate(e,help[4]));
        set(result::setTypes,
                object::getTypes,
                e -> translate(e,help[5]));
        set(result::setVisibleTiles,
                object::getVisibleTiles,
                e -> translate(e,help[6]));
        }
        return result;
    }

    protected UnitType translate(UnitTypeDto object, TranslateOption option) {
        if (object == null) {
            return null;
        }

        UnitType result = new UnitTypeNode(getNode(option, object.getId()));

        set(result::setActions,
                object::getActions,
                e -> translate(e,option));
        result.setAffectedPromotion(translate(object.getAffectedPromotion(),option));
        result.setId(object.getId());
        result.setName(object.getName());
        set(result::setUnits,
                object::getUnits,
                e -> translate(e,option));

        return result;
    }

    protected UnitTypeDto translate(UnitType object, int level) {
        if (object == null) {
            return null;
        }

        UnitTypeDto result = new UnitTypeDto();
        
        result.setId(object.getId());
        result.setName(object.getName());
        
        if(level++ < MAX_LEVEL)
        {
            int[] help = new int[]{level,level,level};
        set(result::setActions,
                object::getActions,
                e -> translate(e,help[0]));
        result.setAffectedPromotion(translate(object.getAffectedPromotion(),help[1]));
        set(result::setUnits,
                object::getUnits,
                e -> translate(e,help[2]));
        }
        return result;
    }
}
