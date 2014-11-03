package org.civmmo.contracts.services.persistence;

import java.util.List;
import org.civmmo.contracts.model.*;

public interface RegionService extends CRUDService<RegionDto>,QueryableService<RegionDto> {

     void generateNewRegion(long regionId,
                            long x,
                            long y,
                            List<TerrainTypeDto> types, 
                            List<TerrainFeatureDto> features,
                            List<ResourceDto> resources);
}
