package org.civmmo.contracts.services.persistence;

import org.civmmo.contracts.model.*;

public interface UnitService extends CRUDService<UnitDto>,QueryableService<UnitDto> {
  
  void attackUnit(long unitId, long unit2Id);
  void promoteUnit(long unitId, PromotionDto promotion);
  void moveUnit(long unitId, TileDto tile);
}
