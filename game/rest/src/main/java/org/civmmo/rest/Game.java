package org.civmmo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.civmmo.contracts.model.*;
import org.civmmo.contracts.services.persistence.*;

@Path("/")
public class Game {

    @Inject
    private CivilizationService civilizationService;
    @Inject
    private SocialPolicyService socialPolicyService;
    @Inject
    private TechnologyService technologyService;
    @Inject
    private CityService cityService;
    @Inject
    private UnitService unitService;
    @Inject
    private RegionService regionService;
    @Inject
    private TerrainTypeService terrainTypeService;
    @Inject
    private TerrainFeatureService terrainFeatureService;
    @Inject
    private TileService tileService;
    @Inject
    private ResourceService resourceService;
    @Inject
    private BuildingService buildingService;

    @GET
    @Path("/game/admin/createregion/{id}/{x}/{y}")
    @Produces("application/json")
    public Response generateNewRegion(@PathParam("id") long regionId, @PathParam("x") long x, @PathParam("y") long y) {
        try {
            regionService.generateNewRegion(regionId, x, y,
                    terrainTypeService.getAll(),
                    terrainFeatureService.getAll(),
                    resourceService.getAll());
            return Response.ok(regionService.getById(regionId)).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    @GET
    @Path("/game/admin/computewealthchange/{id}")
    @Produces("application/json")
    public Response computeWealthChange(@PathParam("id") long civId) {
        try {
            civilizationService.computeWealthChange(civId);
            return Response.ok(civilizationService.getById(civId)).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    @GET
    @Path("/game/admin/computeattacks")
    @Produces("application/json")
    public Response computeAttacks() {
       /* try {
            unitService.getAll().stream().forEach(u -> {
                u.getAttackedBy().forEach(u2 -> {
                    unitService.attackUnit(u.getId(), u2.getId());
                });
                u.getAttackedBy().clear();
                unitService.update(u);
                UnitDto u3 = unitService.getById(u.getId());
                if (u3.getHitPoints() < 1) {
                    unitService.delete(u3);
                }
            });

            cityService.getAll().stream().forEach(c -> {
                c.getAttackedBy().forEach(u -> {
                    cityService.attackUnit(c.getId(), u);
                    UnitDto u3 = unitService.getById(u.getId());
                    if (u3.getHitPoints() < 1) {
                        c.getAttackedBy().remove(u);
                        unitService.delete(u3);
                    } else {
                        cityService.getAttackedByUnit(c.getId(), u);
                        cityService.update(c);
                        CityDto c2 = cityService.getById(c.getId());
                        if (c2.getHitPoints() < 1) {
                            CivilizationDto civ = civilizationService.getByCityId(c2.getId());
                            civilizationService.ownCity(
                                    civ.getId(),
                                    c2);
                            cityService.update(c2);
                            civilizationService.update(civ);
                        }
                    }
                });
            });

            return Response.ok().build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }*/
        return null;
    }

    @GET
    @Path("/game/admin/newciv/{id}")
    @Produces("application/json")
    public Response newCiv(@PathParam("id") long regionId) {
        try {
            CivilizationDto newCiv = new CivilizationDto();
            newCiv.setGold(50);
            newCiv.setCities(new ArrayList<CityDto>());
            CityDto newCity = new CityDto();
            newCity.setCitizens(1);
            Random r = new Random();
            List<TileDto> tiles = tileService.getUnusedTilesOfRegion(regionId);
            newCity.setCenter(tiles.get(r.nextInt(tiles.size() - 1)));
            newCiv.getCities().add(newCity);
            civilizationService.create(newCiv);
            return Response.ok(newCiv).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    @GET
    @Path("/game/player/viewabletiles/{id}/{id2}")
    @Produces("application/json")
    public Response viewableTiles(@PathParam("id") long regionId, @PathParam("id2") long civId) {
        try {
            return Response.ok(tileService.getvisibleTilesOfRegionforCiv(regionId, civId)).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    @GET
    @Path("/game/player/civilization/{id}/declarewarto/{id2}")
    @Produces("application/json")
    public Response getCivilizationEnemies(@PathParam("id") long id, @PathParam("id2") long id2) {
        try {
            CivilizationDto civ = civilizationService.getById(id);
            CivilizationDto civ2 = civilizationService.getById(id2);

            if (civ.getAllies().contains(civ2)) {
                civ.getAllies().remove(civ2);
            }
            if (!civ.getEnemies().contains(civ2)) {
                civ.getEnemies().add(civ2);
            }

            civilizationService.update(civ);

            return Response.ok(civ.getEnemies()).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    @GET
    @Path("/game/player/civilization/{id}/declarepeacewith/{id2}")
    @Produces("application/json")
    public Response getCivilizationAllies(@PathParam("id") long id, @PathParam("id2") long id2) {
        try {
            CivilizationDto civ = civilizationService.getById(id);
            CivilizationDto civ2 = civilizationService.getById(id2);

            if (!civ.getAllies().contains(civ2)) {
                civ.getAllies().add(civ2);
            }
            if (civ.getEnemies().contains(civ2)) {
                civ.getEnemies().remove(civ2);
            }

            civilizationService.update(civ);

            return Response.ok(civ.getEnemies()).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    @GET
    @Path("/game/player/civilization/{id}/usepolicy/{id2}")
    @Produces("application/json")
    public Response setUasageOfPolicy(@PathParam("id") long id, @PathParam("id2") long id2) {
        try {
            CivilizationDto civ = civilizationService.getById(id);
            SocialPolicyDto policy = socialPolicyService.getById(id2);

            civ.setCurrentPolicy(policy);
            civilizationService.update(civ);

            if (!policy.getCurrentlyUsedBy().contains(civ)) {
                policy.getCurrentlyUsedBy().add(civ);
                socialPolicyService.update(policy);
            }

            return Response.ok(civ.getCurrentPolicy()).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    @GET
    @Path("/game/player/civilization/{id}/studytech/{id2}")
    @Produces("application/json")
    public Response setStudyOfTechnology(@PathParam("id") long id, @PathParam("id2") long id2) {
        try {
            CivilizationDto civ = civilizationService.getById(id);
            TechnologyDto technology = technologyService.getById(id2);

            civ.setCurrentlyStudiedTechnology(technology);
            civilizationService.update(civ);

            return Response.ok(civ.getCurrentlyStudiedTechnology()).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    @GET
    @Path("/game/player/civilization/{id}/knowtech/{id2}")
    @Produces("application/json")
    public Response setKnowledgeOfTechnology(@PathParam("id") long id, @PathParam("id2") long id2) {
        try {
            CivilizationDto civ = civilizationService.getById(id);
            TechnologyDto technology = technologyService.getById(id2);

            if (!civ.getKnownTechnologies().contains(technology)) {
                civ.getKnownTechnologies().add(technology);
                civilizationService.update(civ);
            }

            if (!technology.getKnownBy().contains(civ)) {
                technology.getKnownBy().add(civ);
                technologyService.update(technology);
            }

            return Response.ok(civ.getKnownTechnologies()).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    @GET
    @Path("/game/player/civilization/{id}/owncity/{id2}")
    @Produces("application/json")
    public Response setOwnageOfCity(@PathParam("id") long id, @PathParam("id2") long id2) {
        try {
            CivilizationDto civ = civilizationService.getById(id);
            CityDto technology = cityService.getById(id2);

            if (!civ.getCities().contains(technology)) {
                civ.getCities().add(technology);
                civilizationService.update(civ);
            }

            if (technology.getOwnedBy() != civ) {
                technology.setOwnedBy(civ);
                cityService.update(technology);
            }

            return Response.ok(civ.getCities()).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    @GET
    @Path("/game/player/city/{id}/build/{id2}")
    @Produces("application/json")
    public Response buildBuildinginACity(@PathParam("id") long id, @PathParam("id2") long id2) {
        try {
            CityDto civ = cityService.getById(id);
            BuildingDto technology = buildingService.getById(id2);

            civ.setCurrentlyConstructedBuilding(technology);

            cityService.update(civ);

            return Response.ok(civ.getCurrentlyConstructedBuilding()).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    @GET
    @Path("/game/player/city/{id}/train/{id2}")
    @Produces("application/json")
    public Response buildunitinACity(@PathParam("id") long id, @PathParam("id2") long id2) {
        try {
            CityDto civ = cityService.getById(id);
            UnitDto technology = unitService.getById(id2);

            civ.setCurrentlyConstructedUnit(technology);

            cityService.update(civ);

            return Response.ok(civ.getCurrentlyConstructedUnit()).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    @GET
    @Path("/game/player/unit/{id}/move/{id2}")
    @Produces("application/json")
    public Response moveUnit(@PathParam("id") long id, @PathParam("id2") long id2) {
        try {
            UnitDto unit = unitService.getById(id);
            TileDto tile = tileService.getById(id2);

            unit.setPosition(tile);

            unitService.update(unit);

            return Response.ok(unit.getPosition()).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    @GET
    @Path("/game/player/unit/{id}/attackunit/{id2}")
    @Produces("application/json")
    public Response attackUnit(@PathParam("id") long id, @PathParam("id2") long id2) {
        try {
            UnitDto unit = unitService.getById(id);
            UnitDto unit2 = unitService.getById(id2);

            unit2.getAttackedBy().add(unit);

            unitService.update(unit2);

            return Response.ok(unit2.getAttackedBy()).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }
    }

    @GET
    @Path("/game/player/unit/{id}/attackcity/{id2}")
    @Produces("application/json")
    public Response attackCity(@PathParam("id") long id, @PathParam("id2") long id2) {
        try {
            UnitDto unit = unitService.getById(id);
            CityDto unit2 = cityService.getById(id2);

            unit2.getAttackedBy().add(unit);

            cityService.update(unit2);

            return Response.ok(unit2.getAttackedBy()).build();
        } catch (Exception ex) {
            return Response.serverError().entity(ex).build();
        }
    }
}
