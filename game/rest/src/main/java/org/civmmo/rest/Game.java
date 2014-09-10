package org.civmmo.rest;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.civmmo.contracts.model.*;
import org.civmmo.contracts.services.persistence.*;

public class Game {
    
    @Inject
    private CivilizationService civilizationService;
    @Inject
    private SocialPolicyService socialPolicyService;
    @Inject
    private TechnologyService technologyService;
    @Inject
    private CityService cityService;
    
    @GET
    @Path("/game/civilization/{id}/declarewarto/{id2}")
    @Produces("application/json")
    public Response getCivilizationEnemies(@PathParam("id") long id,@PathParam("id2") long id2) {
        try
        {
            CivilizationDto civ = civilizationService.getById(id);
            CivilizationDto civ2 = civilizationService.getById(id2);
            
            if(civ.getAllies().contains(civ2))
            {
                civ.getAllies().remove(civ2);
            }
            if(!civ.getEnemies().contains(civ2))
            {
                civ.getEnemies().add(civ2);
            }
            
            civilizationService.update(civ);
            
            return Response.ok(civ.getEnemies()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/game/civilization/{id}/declarepeacewith/{id2}")
    @Produces("application/json")
    public Response getCivilizationAllies(@PathParam("id") long id,@PathParam("id2") long id2) {
        try
        {
            CivilizationDto civ = civilizationService.getById(id);
            CivilizationDto civ2 = civilizationService.getById(id2);
            
            if(!civ.getAllies().contains(civ2))
            {
                civ.getAllies().add(civ2);
            }
            if(civ.getEnemies().contains(civ2))
            {
                civ.getEnemies().remove(civ2);
            }
            
            civilizationService.update(civ);
            
            return Response.ok(civ.getEnemies()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/game/civilization/{id}/usepolicy/{id2}")
    @Produces("application/json")
    public Response setUasageOfPolicy(@PathParam("id") long id,@PathParam("id2") long id2) {
        try
        {
            CivilizationDto civ = civilizationService.getById(id);
            SocialPolicyDto policy = socialPolicyService.getById(id2);
            
            civ.setCurrentPolicy(policy);
            civilizationService.update(civ);
            
            if(!policy.getCurrentlyUsedBy().contains(civ))
            {
                policy.getCurrentlyUsedBy().add(civ);
                socialPolicyService.update(policy);
            }
            
            return Response.ok(civ.getCurrentPolicy()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/game/civilization/{id}/studytech/{id2}")
    @Produces("application/json")
    public Response setStudyOfTechnology(@PathParam("id") long id,@PathParam("id2") long id2) {
        try
        {
            CivilizationDto civ = civilizationService.getById(id);
            TechnologyDto technology = technologyService.getById(id2);
            
            civ.setCurrentlyStudiedTechnology(technology);
            civilizationService.update(civ);
            
            return Response.ok(civ.getCurrentlyStudiedTechnology()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/game/civilization/{id}/knowtech/{id2}")
    @Produces("application/json")
    public Response setKnowledgeOfTechnology(@PathParam("id") long id,@PathParam("id2") long id2) {
        try
        {
            CivilizationDto civ = civilizationService.getById(id);
            TechnologyDto technology = technologyService.getById(id2);
            
            if(!civ.getKnownTechnologies().contains(technology))
            {
                civ.getKnownTechnologies().add(technology);
                civilizationService.update(civ);
            }
            
            if(!technology.getKnownBy().contains(civ))
            {
                technology.getKnownBy().add(civ);
                technologyService.update(technology);
            }
            
            return Response.ok(civ.getKnownTechnologies()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
    
    @GET
    @Path("/game/civilization/{id}/owncity/{id2}")
    @Produces("application/json")
    public Response setOwnageOfCity(@PathParam("id") long id,@PathParam("id2") long id2) {
        try
        {
            CivilizationDto civ = civilizationService.getById(id);
            TechnologyDto technology = technologyService.getById(id2);
            
            if(!civ.getKnownTechnologies().contains(technology))
            {
                civ.getKnownTechnologies().add(technology);
                civilizationService.update(civ);
            }
            
            if(!technology.getKnownBy().contains(civ))
            {
                technology.getKnownBy().add(civ);
                technologyService.update(technology);
            }
            
            return Response.ok(civ.getKnownTechnologies()).build();
        }
        catch(Exception ex)
        {
            return Response.serverError().entity(ex).build();
        }
    }
}
