package org.civmmo.contracts.services.persistence;

import org.civmmo.contracts.model.*;

public interface CityService extends CRUDService<CityDto>,QueryableService<CityDto> {

  void constructBuilding(long cityId, BuildingDto building);
  void workBuilding(long cityId, BuildingDto building);
  void constructUnit(long cityId, UnitDto unit);
  boolean hasTradeRouteWith(long cityId, long city2Id);
  void controlTile(long cityId, TileDto tile);
  void workTile(long cityId, TileDto tile);
  void attackUnit(long cityId, UnitDto unit);
  CityDto computeWealthGrowth(long cityId);

}
