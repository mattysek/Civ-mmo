package org.civmmo.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.civmmo.contracts.services.persistence.*;
import org.civmmo.rest.utils.Query;

//@Path("/")
public class QueryTesting {
    
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
    @POST
    @Path("/testquerylist/action")
    @Produces("application/json")
    @Consumes("application/json")
    public Response actionGetListNative(Query query) {
        try
        {
            return Response.ok(actionService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/action")
    @Produces("application/json")
    @Consumes("application/json")
    public Response actionGetSingleNative(Query query) {
        try
        {
            return Response.ok(actionService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="building">
    @POST
    @Path("/testquerylist/building")
    @Produces("application/json")
    @Consumes("application/json")
    public Response buildingGetListNative(Query query) {
        try
        {
            return Response.ok(buildingService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/building")
    @Produces("application/json")
    @Consumes("application/json")
    public Response buildingGetSingleNative(Query query) {
        try
        {
            return Response.ok(buildingService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="city">
    @POST
    @Path("/testquerylist/city")
    @Produces("application/json")
    @Consumes("application/json")
    public Response cityGetListNative(Query query) {
        try
        {
            return Response.ok(cityService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/city")
    @Produces("application/json")
    @Consumes("application/json")
    public Response cityGetSingleNative(Query query) {
        try
        {
            return Response.ok(cityService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="civilization">
    @POST
    @Path("/testquerylist/civilization")
    @Produces("application/json")
    @Consumes("application/json")
    public Response civilizationGetListNative(Query query) {
        try
        {
            return Response.ok(civilizationService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/civilization")
    @Produces("application/json")
    @Consumes("application/json")
    public Response civilizationGetSingleNative(Query query) {
        try
        {
            return Response.ok(civilizationService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="combatmodifier">
    @POST
    @Path("/testquerylist/combatmodifier")
    @Produces("application/json")
    @Consumes("application/json")
    public Response combatmodifierGetListNative(Query query) {
        try
        {
            return Response.ok(combatModifierService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/combatmodifier")
    @Produces("application/json")
    @Consumes("application/json")
    public Response combatmodifierGetSingleNative(Query query) {
        try
        {
            return Response.ok(combatModifierService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="improvement">
    @POST
    @Path("/testquerylist/improvement")
    @Produces("application/json")
    @Consumes("application/json")
    public Response improvementGetListNative(Query query) {
        try
        {
            return Response.ok(improvementService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/improvement")
    @Produces("application/json")
    @Consumes("application/json")
    public Response improvementGetSingleNative(Query query) {
        try
        {
            return Response.ok(improvementService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="policy">
    @POST
    @Path("/testquerylist/policy")
    @Produces("application/json")
    @Consumes("application/json")
    public Response policyGetListNative(Query query) {
        try
        {
            return Response.ok(policyService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/policy")
    @Produces("application/json")
    @Consumes("application/json")
    public Response policyGetSingleNative(Query query) {
        try
        {
            return Response.ok(policyService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="promotion">
    @POST
    @Path("/testquerylist/promotion")
    @Produces("application/json")
    @Consumes("application/json")
    public Response promotionGetListNative(Query query) {
        try
        {
            return Response.ok(promotionService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/promotion")
    @Produces("application/json")
    @Consumes("application/json")
    public Response promotionGetSingleNative(Query query) {
        try
        {
            return Response.ok(promotionService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="region">
    @POST
    @Path("/testquerylist/region")
    @Produces("application/json")
    @Consumes("application/json")
    public Response regionGetListNative(Query query) {
        try
        {
            return Response.ok(regionService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/region")
    @Produces("application/json")
    @Consumes("application/json")
    public Response regionGetSingleNative(Query query) {
        try
        {
            return Response.ok(regionService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="resource">
    @POST
    @Path("/testquerylist/resource")
    @Produces("application/json")
    @Consumes("application/json")
    public Response resourceGetListNative(Query query) {
        try
        {
            return Response.ok(resourceService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/resource")
    @Produces("application/json")
    @Consumes("application/json")
    public Response resourceGetSingleNative(Query query) {
        try
        {
            return Response.ok(resourceService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="river">
    @POST
    @Path("/testquerylist/river")
    @Produces("application/json")
    @Consumes("application/json")
    public Response riverGetListNative(Query query) {
        try
        {
            return Response.ok(riverService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/river")
    @Produces("application/json")
    @Consumes("application/json")
    public Response riverGetSingleNative(Query query) {
        try
        {
            return Response.ok(riverService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="socialpolicy">
    @POST
    @Path("/testquerylist/socialpolicy")
    @Produces("application/json")
    @Consumes("application/json")
    public Response socialpolicyGetListNative(Query query) {
        try
        {
            return Response.ok(socialPolicyService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/socialpolicy")
    @Produces("application/json")
    @Consumes("application/json")
    public Response socialolicyGetSingleNative(Query query) {
        try
        {
            return Response.ok(socialPolicyService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="technology">
    @POST
    @Path("/testquerylist/technology")
    @Produces("application/json")
    @Consumes("application/json")
    public Response technologyGetListNative(Query query) {
        try
        {
            return Response.ok(technologyService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/technology")
    @Produces("application/json")
    @Consumes("application/json")
    public Response technologyGetSingleNative(Query query) {
        try
        {
            return Response.ok(technologyService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="terrainfeature">
    @POST
    @Path("/testquerylist/terrainfeature")
    @Produces("application/json")
    @Consumes("application/json")
    public Response terrainfeatureGetListNative(Query query) {
        try
        {
            return Response.ok(terrainFeatureService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/terrainfeature")
    @Produces("application/json")
    @Consumes("application/json")
    public Response terrainfeatureGetSingleNative(Query query) {
        try
        {
            return Response.ok(terrainFeatureService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="terraintype">
    @POST
    @Path("/testquerylist/terraintype")
    @Produces("application/json")
    @Consumes("application/json")
    public Response terraintypeGetListNative(Query query) {
        try
        {
            return Response.ok(terrainTypeService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/terraintype")
    @Produces("application/json")
    @Consumes("application/json")
    public Response terraintypeGetSingleNative(Query query) {
        try
        {
            return Response.ok(terrainTypeService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="tile">
    @POST
    @Path("/testquerylist/tile")
    @Produces("application/json")
    @Consumes("application/json")
    public Response tileGetListNative(Query query) {
        try
        {
            return Response.ok(tileService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/tile")
    @Produces("application/json")
    @Consumes("application/json")
    public Response tileGetSingleNative(Query query) {
        try
        {
            return Response.ok(tileService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="traderoute">
    @POST
    @Path("/testquerylist/traderoute")
    @Produces("application/json")
    @Consumes("application/json")
    public Response traderouteGetListNative(Query query) {
        try
        {
            return Response.ok(tradeRouteService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/traderoute")
    @Produces("application/json")
    @Consumes("application/json")
    public Response traderouteGetSingleNative(Query query) {
        try
        {
            return Response.ok(tradeRouteService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="unit">
    @POST
    @Path("/testquerylist/unit")
    @Produces("application/json")
    @Consumes("application/json")
    public Response unitGetListNative(Query query) {
        try
        {
            return Response.ok(unitService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/unit")
    @Produces("application/json")
    @Consumes("application/json")
    public Response unitGetSingleNative(Query query) {
        try
        {
            return Response.ok(unitService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="unittype">
    @POST
    @Path("/testquerylist/unittype")
    @Produces("application/json")
    @Consumes("application/json")
    public Response unittypeGetListNative(Query query) {
        try
        {
            return Response.ok(unitTypeService.testGetListNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @POST
    @Path("/testquerysingle/unittype")
    @Produces("application/json")
    @Consumes("application/json")
    public Response unittypeGetSingleNative(Query query) {
        try
        {
            return Response.ok(unitTypeService.testGetSingleNativeQuery(query.getQuery())).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    // </editor-fold>
}
