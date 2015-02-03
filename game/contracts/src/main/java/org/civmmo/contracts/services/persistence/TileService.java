package org.civmmo.contracts.services.persistence;

import java.util.List;
import org.civmmo.contracts.model.TileDto;

public interface TileService extends CRUDService<TileDto>,QueryableService<TileDto>  {

  boolean isRiver(long tileId);

  List<TileDto> getUnusedTilesOfRegion(long regionId);
  List<TileDto> getvisibleTilesOfRegionforCiv(long regionId, long civId);
  
}
