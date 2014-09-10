package org.civmmo.rest;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.civmmo.contracts.model.*;
import org.civmmo.contracts.services.persistence.*;

@Path("/")
public class CRUD {
    
    // <editor-fold defaultstate="collapsed" desc="services">
    @Inject
    private ActionService actionService;
    @Inject
    private BuildingService buildingService;
    @Inject
    private CityService cityService;
    @Inject
    private CivilizationService civilizationService;
    @Inject
    private CombatModifierService combatModifierService;
    @Inject
    private ImprovementService improvementService;
    @Inject
    private PolicyService policyService;
    @Inject
    private PromotionService promotionService;
    @Inject
    private RegionService regionService;
    @Inject
    private ResourceService resourceService;
    @Inject
    private RiverService riverService;
    @Inject
    private SocialPolicyService socialPolicyService;
    @Inject
    private TechnologyService technologyService;
    @Inject
    private TerrainFeatureService terrainFeatureService;
    @Inject
    private TerrainTypeService terrainTypeService;
    @Inject
    private TileService tileService;
    @Inject
    private TradeRouteService tradeRouteService;
    @Inject
    private UnitService unitService;
    @Inject
    private UnitTypeService unitTypeService;
    // </editor-fold>
                    
    // <editor-fold defaultstate="collapsed" desc="action">
    @GET
    @Path("/action")
    @Produces("application/json")
    public Response getAllActions() {
        try
        {
            List<ActionDto> result = actionService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/action/{id}")
    @Produces("application/json")
    public Response getActionByid(@PathParam("id") long id) {
        try
        {
            ActionDto result = actionService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/action/{id}")
    @Produces("application/json")
    public Response deleteAction(@PathParam("id") long id) {
        try
        {
            ActionDto result = actionService.getById(id);
            actionService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/action")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createAction(ActionDto action) {
        try
        {
            actionService.create(action);
            return Response.ok(action).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/action/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateAction(@PathParam("id") long id, ActionDto action) {
        try
        {
            action.setId(id);
            actionService.update(action);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="building">
    @GET
    @Path("/building")
    @Produces("application/json")
    public Response getAllBuildings() {
        try
        {
            List<BuildingDto> result = buildingService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/building/{id}")
    @Produces("application/json")
    public Response getBuildingByid(@PathParam("id") long id) {
        try
        {
            BuildingDto result = buildingService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/building/{id}")
    @Produces("application/json")
    public Response deleteBuilding(@PathParam("id") long id) {
        try
        {
            BuildingDto result = buildingService.getById(id);
            buildingService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/building")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createBuilding(BuildingDto building) {
        try
        {
            buildingService.create(building);
            return Response.ok(building).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/building/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateBuilding(@PathParam("id") long id, BuildingDto building) {
        try
        {
            building.setId(id);
            buildingService.update(building);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="city">
    @GET
    @Path("/city")
    @Produces("application/json")
    public Response getAllCities() {
        try
        {
            List<CityDto> result = cityService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/city/{id}")
    @Produces("application/json")
    public Response getCityByid(@PathParam("id") long id) {
        try
        {
            CityDto result = cityService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/city/{id}")
    @Produces("application/json")
    public Response deleteCity(@PathParam("id") long id) {
        try
        {
            CityDto result = cityService.getById(id);
            cityService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/city")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createCity(CityDto city) {
        try
        {
            cityService.create(city);
            return Response.ok(city).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/city/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateCity(@PathParam("id") long id, CityDto city) {
        try
        {
            city.setId(id);
            cityService.update(city);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="civilization">
    @GET
    @Path("/civilization")
    @Produces("application/json")
    public Response getAllCivilizations() {
        try
        {
            List<CivilizationDto> result = civilizationService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/civilization/{id}")
    @Produces("application/json")
    public Response getCivilizationByid(@PathParam("id") long id) {
        try
        {
            CivilizationDto result = civilizationService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/civilization/{id}")
    @Produces("application/json")
    public Response deleteCivilization(@PathParam("id") long id) {
        try
        {
            CivilizationDto result = civilizationService.getById(id);
            civilizationService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/civilization")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createCivilization(CivilizationDto civilization) {
        try
        {
            civilizationService.create(civilization);
            return Response.ok(civilization).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/civilization/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateCivilization(@PathParam("id") long id, CivilizationDto civilization) {
        try
        {
            civilization.setId(id);
            civilizationService.update(civilization);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="combatmodifier">
    @GET
    @Path("/combatmodifier")
    @Produces("application/json")
    public Response getAllCombatModifiers() {
        try
        {
            List<CombatModifierDto> result = combatModifierService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/combatmodifier/{id}")
    @Produces("application/json")
    public Response getCombatModifierByid(@PathParam("id") long id) {
        try
        {
            CombatModifierDto result = combatModifierService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/combatmodifier/{id}")
    @Produces("application/json")
    public Response deleteCombatModifier(@PathParam("id") long id) {
        try
        {
            CombatModifierDto result = combatModifierService.getById(id);
            combatModifierService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/combatmodifier")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createCombatModifier(CombatModifierDto combatmodifier) {
        try
        {
            combatModifierService.create(combatmodifier);
            return Response.ok(combatmodifier).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/combatmodifier/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateCombatModifier(@PathParam("id") long id, CombatModifierDto combatmodifier) {
        try
        {
            combatmodifier.setId(id);
            combatModifierService.update(combatmodifier);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="improvement">
    @GET
    @Path("/improvement")
    @Produces("application/json")
    public Response getAllImprovements() {
        try
        {
            List<ImprovementDto> result = improvementService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/improvement/{id}")
    @Produces("application/json")
    public Response getImprovementByid(@PathParam("id") long id) {
        try
        {
            ImprovementDto result = improvementService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/improvement/{id}")
    @Produces("application/json")
    public Response deleteImprovement(@PathParam("id") long id) {
        try
        {
            ImprovementDto result = improvementService.getById(id);
            improvementService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/improvement")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createImprovement(ImprovementDto improvement) {
        try
        {
            improvementService.create(improvement);
            return Response.ok(improvement).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/improvement/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateImprovement(@PathParam("id") long id, ImprovementDto improvement) {
        try
        {
            improvement.setId(id);
            improvementService.update(improvement);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="policy">
    @GET
    @Path("/policy")
    @Produces("application/json")
    public Response getAllPolicies() {
        try
        {
            List<PolicyDto> result = policyService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/policy/{id}")
    @Produces("application/json")
    public Response getPolicyByid(@PathParam("id") long id) {
        try
        {
            PolicyDto result = policyService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/policy/{id}")
    @Produces("application/json")
    public Response deletePolicy(@PathParam("id") long id) {
        try
        {
            PolicyDto result = policyService.getById(id);
            policyService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/policy")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createPolicy(PolicyDto policy) {
        try
        {
            policyService.create(policy);
            return Response.ok(policy).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/policy/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updatePolicy(@PathParam("id") long id, PolicyDto policy) {
        try
        {
            policy.setId(id);
            policyService.update(policy);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="promotion">
    @GET
    @Path("/promotion")
    @Produces("application/json")
    public Response getAllPromotions() {
        try
        {
            List<PromotionDto> result = promotionService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/promotion/{id}")
    @Produces("application/json")
    public Response getPromotionByid(@PathParam("id") long id) {
        try
        {
            PromotionDto result = promotionService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/promotion/{id}")
    @Produces("application/json")
    public Response deletePromotion(@PathParam("id") long id) {
        try
        {
            PromotionDto result = promotionService.getById(id);
            promotionService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/promotion")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createPromotion(PromotionDto promotion) {
        try
        {
            promotionService.create(promotion);
            return Response.ok(promotion).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/promotion/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updatePromotion(@PathParam("id") long id, PromotionDto promotion) {
        try
        {
            promotion.setId(id);
            promotionService.update(promotion);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="region">
    @GET
    @Path("/region")
    @Produces("application/json")
    public Response getAllRegions() {
        try
        {
            List<RegionDto> result = regionService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/region/{id}")
    @Produces("application/json")
    public Response getRegionByid(@PathParam("id") long id) {
        try
        {
            RegionDto result = regionService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/region/{id}")
    @Produces("application/json")
    public Response deleteRegion(@PathParam("id") long id) {
        try
        {
            RegionDto result = regionService.getById(id);
            regionService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/region")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createRegion(RegionDto region) {
        try
        {
            regionService.create(region);
            return Response.ok(region).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/region/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateRegion(@PathParam("id") long id, RegionDto region) {
        try
        {
            region.setId(id);
            regionService.update(region);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="resource">
    @GET
    @Path("/resource")
    @Produces("application/json")
    public Response getAllResources() {
        try
        {
            List<ResourceDto> result = resourceService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/resource/{id}")
    @Produces("application/json")
    public Response getResourceByid(@PathParam("id") long id) {
        try
        {
            ResourceDto result = resourceService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/resource/{id}")
    @Produces("application/json")
    public Response deleteResource(@PathParam("id") long id) {
        try
        {
            ResourceDto result = resourceService.getById(id);
            resourceService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/resource")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createResource(ResourceDto resource) {
        try
        {
            resourceService.create(resource);
            return Response.ok(resource).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/resource/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateResource(@PathParam("id") long id, ResourceDto resource) {
        try
        {
            resource.setId(id);
            resourceService.update(resource);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="river">
    @GET
    @Path("/river")
    @Produces("application/json")
    public Response getAllRivers() {
        try
        {
            List<RiverDto> result = riverService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/river/{id}")
    @Produces("application/json")
    public Response getRiverByid(@PathParam("id") long id) {
        try
        {
            RiverDto result = riverService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/river/{id}")
    @Produces("application/json")
    public Response deleteRiver(@PathParam("id") long id) {
        try
        {
            RiverDto result = riverService.getById(id);
            riverService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/river")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createRiver(RiverDto river) {
        try
        {
            riverService.create(river);
            return Response.ok(river).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/river/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateRiver(@PathParam("id") long id, RiverDto river) {
        try
        {
            river.setId(id);
            riverService.update(river);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="socialpolicy">
    @GET
    @Path("/socialpolicy")
    @Produces("application/json")
    public Response getAllSocialPolicies() {
        try
        {
            List<SocialPolicyDto> result = socialPolicyService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/socialpolicy/{id}")
    @Produces("application/json")
    public Response getSocialPolicyByid(@PathParam("id") long id) {
        try
        {
            SocialPolicyDto result = socialPolicyService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/socialpolicy/{id}")
    @Produces("application/json")
    public Response deleteSocialPolicy(@PathParam("id") long id) {
        try
        {
            SocialPolicyDto result = socialPolicyService.getById(id);
            socialPolicyService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/socialpolicy")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createSocialPolicy(SocialPolicyDto socialpolicy) {
        try
        {
            socialPolicyService.create(socialpolicy);
            return Response.ok(socialpolicy).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/socialpolicy/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateSocialPolicy(@PathParam("id") long id, SocialPolicyDto socialpolicy) {
        try
        {
            socialpolicy.setId(id);
            socialPolicyService.update(socialpolicy);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="technology">
    @GET
    @Path("/technology")
    @Produces("application/json")
    public Response getAllTechnologies() {
        try
        {
            List<TechnologyDto> result = technologyService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/technology/{id}")
    @Produces("application/json")
    public Response getTechnologyByid(@PathParam("id") long id) {
        try
        {
            TechnologyDto result = technologyService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/technology/{id}")
    @Produces("application/json")
    public Response deleteTechnology(@PathParam("id") long id) {
        try
        {
            TechnologyDto result = technologyService.getById(id);
            technologyService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/technology")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createTechnology(TechnologyDto technology) {
        try
        {
            technologyService.create(technology);
            return Response.ok(technology).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/technology/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateTechnology(@PathParam("id") long id, TechnologyDto technology) {
        try
        {
            technology.setId(id);
            technologyService.update(technology);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="terrainfeature">
    @GET
    @Path("/terrainfeature")
    @Produces("application/json")
    public Response getAllTerrainFeatures() {
        try
        {
            List<TerrainFeatureDto> result = terrainFeatureService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/terrainfeature/{id}")
    @Produces("application/json")
    public Response getTerrainFeatureByid(@PathParam("id") long id) {
        try
        {
            TerrainFeatureDto result = terrainFeatureService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/terrainfeature/{id}")
    @Produces("application/json")
    public Response deleteTerrainFeature(@PathParam("id") long id) {
        try
        {
            TerrainFeatureDto result = terrainFeatureService.getById(id);
            terrainFeatureService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/terrainfeature")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createTerrainFeature(TerrainFeatureDto terrainfeature) {
        try
        {
            terrainFeatureService.create(terrainfeature);
            return Response.ok(terrainfeature).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/terrainfeature/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateTerrainFeature(@PathParam("id") long id, TerrainFeatureDto terrainfeature) {
        try
        {
            terrainfeature.setId(id);
            terrainFeatureService.update(terrainfeature);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="terraintype">
    @GET
    @Path("/terraintype")
    @Produces("application/json")
    public Response getAllTerrainTypes() {
        try
        {
            List<TerrainTypeDto> result = terrainTypeService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/terraintype/{id}")
    @Produces("application/json")
    public Response getTerrainTypeByid(@PathParam("id") long id) {
        try
        {
            TerrainTypeDto result = terrainTypeService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/terraintype/{id}")
    @Produces("application/json")
    public Response deleteTerrainType(@PathParam("id") long id) {
        try
        {
            TerrainTypeDto result = terrainTypeService.getById(id);
            terrainTypeService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/terraintype")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createTerrainType(TerrainTypeDto terraintype) {
        try
        {
            terrainTypeService.create(terraintype);
            return Response.ok(terraintype).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/terraintype/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateTerrainType(@PathParam("id") long id, TerrainTypeDto terraintype) {
        try
        {
            terraintype.setId(id);
            terrainTypeService.update(terraintype);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="tile">
    @GET
    @Path("/tile")
    @Produces("application/json")
    public Response getAllTiles() {
        try
        {
            List<TileDto> result = tileService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/tile/{id}")
    @Produces("application/json")
    public Response getTileByid(@PathParam("id") long id) {
        try
        {
            TileDto result = tileService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/tile/{id}")
    @Produces("application/json")
    public Response deleteTile(@PathParam("id") long id) {
        try
        {
            TileDto result = tileService.getById(id);
            tileService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/tile")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createTile(TileDto tile) {
        try
        {
            tileService.create(tile);
            return Response.ok(tile).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/tile/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateTile(@PathParam("id") long id, TileDto tile) {
        try
        {
            tile.setId(id);
            tileService.update(tile);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="traderoute">
    @GET
    @Path("/traderoute")
    @Produces("application/json")
    public Response getAllTradeRoutes() {
        try
        {
            List<TradeRouteDto> result = tradeRouteService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/traderoute/{id}")
    @Produces("application/json")
    public Response getTradeRouteByid(@PathParam("id") long id) {
        try
        {
            TradeRouteDto result = tradeRouteService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/traderoute/{id}")
    @Produces("application/json")
    public Response deleteTradeRoute(@PathParam("id") long id) {
        try
        {
            TradeRouteDto result = tradeRouteService.getById(id);
            tradeRouteService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/traderoute")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createTradeRoute(TradeRouteDto traderoute) {
        try
        {
            tradeRouteService.create(traderoute);
            return Response.ok(traderoute).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/traderoute/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateTradeRoute(@PathParam("id") long id, TradeRouteDto traderoute) {
        try
        {
            traderoute.setId(id);
            tradeRouteService.update(traderoute);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="unit">
    @GET
    @Path("/unit")
    @Produces("application/json")
    public Response getAllUnits() {
        try
        {
            List<UnitDto> result = unitService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/unit/{id}")
    @Produces("application/json")
    public Response getUnitByid(@PathParam("id") long id) {
        try
        {
            UnitDto result = unitService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/unit/{id}")
    @Produces("application/json")
    public Response deleteUnit(@PathParam("id") long id) {
        try
        {
            UnitDto result = unitService.getById(id);
            unitService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/unit")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createUnit(UnitDto unit) {
        try
        {
            unitService.create(unit);
            return Response.ok(unit).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/unit/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateUnit(@PathParam("id") long id, UnitDto unit) {
        try
        {
            unit.setId(id);
            unitService.update(unit);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="unittype">
    @GET
    @Path("/unittype")
    @Produces("application/json")
    public Response getAllUnitTypes() {
        try
        {
            List<UnitTypeDto> result = unitTypeService.getAll();
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/unittype/{id}")
    @Produces("application/json")
    public Response getUnitTypeByid(@PathParam("id") long id) {
        try
        {
            UnitTypeDto result = unitTypeService.getById(id);
            return Response.ok(result).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @DELETE
    @Path("/unittype/{id}")
    @Produces("application/json")
    public Response deleteUnitType(@PathParam("id") long id) {
        try
        {
            UnitTypeDto result = unitTypeService.getById(id);
            unitTypeService.delete(result);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @PUT
    @Path("/unittype")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createUnitType(UnitTypeDto unittype) {
        try
        {
            unitTypeService.create(unittype);
            return Response.ok(unittype).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/unittype/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateUnitType(@PathParam("id") long id, UnitTypeDto unittype) {
        try
        {
            unittype.setId(id);
            unitTypeService.update(unittype);
            return Response.ok().build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
}
