package org.civmmo.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.civmmo.contracts.services.persistence.*;

@Path("/")
public class NativeQueries {
    
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
    @Path("/mongo/action")
    @Produces("application/json")
    public Response actionGetListMongo() {
        try
        {
            return Response.ok(actionService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/action/{id}")
    @Produces("application/json")
    public Response actionGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(actionService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/action")
    @Produces("application/json")
    public Response actionGetListSQL() {
        try
        {
            return Response.ok(actionService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/action/{id}")
    @Produces("application/json")
    public Response actionGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(actionService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="building">
    @GET
    @Path("/mongo/building")
    @Produces("application/json")
    public Response buildingGetListMongo() {
        try
        {
            return Response.ok(buildingService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/building/{id}")
    @Produces("application/json")
    public Response buildingGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(buildingService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/building")
    @Produces("application/json")
    public Response buildingGetListSQL() {
        try
        {
            return Response.ok(buildingService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/building/{id}")
    @Produces("application/json")
    public Response buildingGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(buildingService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="city">
    @GET
    @Path("/mongo/city")
    @Produces("application/json")
    public Response cityGetListMongo() {
        try
        {
            return Response.ok(cityService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/city/{id}")
    @Produces("application/json")
    public Response cityGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(cityService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/city")
    @Produces("application/json")
    public Response cityGetListSQL() {
        try
        {
            return Response.ok(cityService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/city/{id}")
    @Produces("application/json")
    public Response cityGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(cityService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="civilization">
    @GET
    @Path("/mongo/civilization")
    @Produces("application/json")
    public Response civilizationGetListMongo() {
        try
        {
            return Response.ok(civilizationService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/civilization/{id}")
    @Produces("application/json")
    public Response civilizationGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(civilizationService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/civilization")
    @Produces("application/json")
    public Response civilizationGetListSQL() {
        try
        {
            return Response.ok(civilizationService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/civilization/{id}")
    @Produces("application/json")
    public Response civilizationGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(civilizationService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="combatmodifier">
    @GET
    @Path("/mongo/combatmodifier")
    @Produces("application/json")
    public Response combatmodifierGetListMongo() {
        try
        {
            return Response.ok(combatModifierService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/combatmodifier/{id}")
    @Produces("application/json")
    public Response combatmodifierGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(combatModifierService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/combatmodifier")
    @Produces("application/json")
    public Response combatmodifierGetListSQL() {
        try
        {
            return Response.ok(combatModifierService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/combatmodifier/{id}")
    @Produces("application/json")
    public Response combatmodifierGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(combatModifierService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="improvement">
    @GET
    @Path("/mongo/improvement")
    @Produces("application/json")
    public Response improvementGetListMongo() {
        try
        {
            return Response.ok(improvementService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/improvement/{id}")
    @Produces("application/json")
    public Response improvementGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(improvementService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/improvement")
    @Produces("application/json")
    public Response improvementGetListSQL() {
        try
        {
            return Response.ok(improvementService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/improvement/{id}")
    @Produces("application/json")
    public Response improvementGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(improvementService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="policy">
    @GET
    @Path("/mongo/policy")
    @Produces("application/json")
    public Response policyGetListMongo() {
        try
        {
            return Response.ok(policyService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/policy/{id}")
    @Produces("application/json")
    public Response policyGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(policyService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/policy")
    @Produces("application/json")
    public Response policyGetListSQL() {
        try
        {
            return Response.ok(policyService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/policy/{id}")
    @Produces("application/json")
    public Response policyGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(policyService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="promotion">
    @GET
    @Path("/mongo/promotion")
    @Produces("application/json")
    public Response promotionGetListMongo() {
        try
        {
            return Response.ok(promotionService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/promotion/{id}")
    @Produces("application/json")
    public Response promotionGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(promotionService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/promotion")
    @Produces("application/json")
    public Response promotionGetListSQL() {
        try
        {
            return Response.ok(promotionService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/promotion/{id}")
    @Produces("application/json")
    public Response promotionGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(promotionService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="region">
    @GET
    @Path("/mongo/region")
    @Produces("application/json")
    public Response regionGetListMongo() {
        try
        {
            return Response.ok(regionService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/region/{id}")
    @Produces("application/json")
    public Response regionGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(regionService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/region")
    @Produces("application/json")
    public Response regionGetListSQL() {
        try
        {
            return Response.ok(regionService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/region/{id}")
    @Produces("application/json")
    public Response regionGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(regionService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="resource">
    @GET
    @Path("/mongo/resource")
    @Produces("application/json")
    public Response resourceGetListMongo() {
        try
        {
            return Response.ok(resourceService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/resource/{id}")
    @Produces("application/json")
    public Response resourceGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(resourceService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/resource")
    @Produces("application/json")
    public Response resourceGetListSQL() {
        try
        {
            return Response.ok(resourceService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/resource/{id}")
    @Produces("application/json")
    public Response resourceGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(resourceService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="river">
    @GET
    @Path("/mongo/river")
    @Produces("application/json")
    public Response riverGetListMongo() {
        try
        {
            return Response.ok(riverService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/river/{id}")
    @Produces("application/json")
    public Response riverGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(riverService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/river")
    @Produces("application/json")
    public Response riverGetListSQL() {
        try
        {
            return Response.ok(riverService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/river/{id}")
    @Produces("application/json")
    public Response riverGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(riverService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="socialpolicy">
    @GET
    @Path("/mongo/socialpolicy")
    @Produces("application/json")
    public Response socialpolicyGetListMongo() {
        try
        {
            return Response.ok(socialPolicyService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/socialpolicy/{id}")
    @Produces("application/json")
    public Response socialpolicyGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(socialPolicyService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/socialpolicy")
    @Produces("application/json")
    public Response socialpolicyGetListSQL() {
        try
        {
            return Response.ok(socialPolicyService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/socialpolicy/{id}")
    @Produces("application/json")
    public Response socialpolicyGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(socialPolicyService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="technology">
    @GET
    @Path("/mongo/technology")
    @Produces("application/json")
    public Response technologyGetListMongo() {
        try
        {
            return Response.ok(technologyService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/technology/{id}")
    @Produces("application/json")
    public Response technologyGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(technologyService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/technology")
    @Produces("application/json")
    public Response technologyGetListSQL() {
        try
        {
            return Response.ok(technologyService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/technology/{id}")
    @Produces("application/json")
    public Response technologyGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(technologyService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="terrainfeature">
    @GET
    @Path("/mongo/terrainfeature")
    @Produces("application/json")
    public Response terrainfeatureGetListMongo() {
        try
        {
            return Response.ok(terrainFeatureService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/terrainfeature/{id}")
    @Produces("application/json")
    public Response terrainfeatureGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(terrainFeatureService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/terrainfeature")
    @Produces("application/json")
    public Response terrainfeatureGetListSQL() {
        try
        {
            return Response.ok(terrainFeatureService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/terrainfeature/{id}")
    @Produces("application/json")
    public Response terrainfeatureGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(terrainFeatureService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="terraintype">
    @GET
    @Path("/mongo/terraintype")
    @Produces("application/json")
    public Response terraintypeGetListMongo() {
        try
        {
            return Response.ok(terrainTypeService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/terraintype/{id}")
    @Produces("application/json")
    public Response terraintypeGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(terrainTypeService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/terraintype")
    @Produces("application/json")
    public Response terraintypeGetListSQL() {
        try
        {
            return Response.ok(terrainTypeService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/terraintype/{id}")
    @Produces("application/json")
    public Response terraintypeGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(terrainTypeService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="tile">
    @GET
    @Path("/mongo/tile")
    @Produces("application/json")
    public Response tileGetListMongo() {
        try
        {
            return Response.ok(tileService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/tile/{id}")
    @Produces("application/json")
    public Response tileGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(tileService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/tile")
    @Produces("application/json")
    public Response tileGetListSQL() {
        try
        {
            return Response.ok(tileService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/tile/{id}")
    @Produces("application/json")
    public Response tileGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(tileService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="traderoute">
    @GET
    @Path("/mongo/traderoute")
    @Produces("application/json")
    public Response traderouteGetListMongo() {
        try
        {
            return Response.ok(tradeRouteService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/traderoute/{id}")
    @Produces("application/json")
    public Response traderouteGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(tradeRouteService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/traderoute")
    @Produces("application/json")
    public Response traderouteGetListSQL() {
        try
        {
            return Response.ok(tradeRouteService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/traderoute/{id}")
    @Produces("application/json")
    public Response traderouteGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(tradeRouteService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="unit">
    @GET
    @Path("/mongo/unit")
    @Produces("application/json")
    public Response unitGetListMongo() {
        try
        {
            return Response.ok(unitService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/unit/{id}")
    @Produces("application/json")
    public Response unitGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(unitService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/unit")
    @Produces("application/json")
    public Response unitGetListSQL() {
        try
        {
            return Response.ok(unitService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/unit/{id}")
    @Produces("application/json")
    public Response unitGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(unitService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="unittype">
    @GET
    @Path("/mongo/unittype")
    @Produces("application/json")
    public Response unittypeGetListMongo() {
        try
        {
            return Response.ok(unitTypeService.getAllMongo()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/mongo/unittype/{id}")
    @Produces("application/json")
    public Response unittypeGetSingleMongo(@PathParam("id") long id) {
        try
        {
            return Response.ok(unitTypeService.getByIdMongo(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/unittype")
    @Produces("application/json")
    public Response unittypeGetListSQL() {
        try
        {
            return Response.ok(unitTypeService.getAllSQL()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/sql/unittype/{id}")
    @Produces("application/json")
    public Response unittypeGetSingleSQL(@PathParam("id") long id) {
        try
        {
            return Response.ok(unitTypeService.getByIdSQL(id)).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
}

