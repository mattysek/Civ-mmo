package org.civmmo.contracts.services.persistence;

import org.civmmo.contracts.model.*;
import java.util.List;

public interface CivilizationService extends CRUDService<CivilizationDto>,QueryableService<CivilizationDto> {

  void unlockPolicy(long civilizationId, PolicyDto policy);
  void useSocialPolicy(long civilizationId, SocialPolicyDto socialPolicy);
  void ownSocialPolicy(long civilizationId, SocialPolicyDto socialPolicy);
  void declareWarBetween(long civilizationId, long civilization2Id);
  void declarePeaceBetween(long civilizationId, long civilization2Id);
  void ownCity(long civilizationId, CityDto city);
  void studyTechnology(long civilizationId, TechnologyDto technology);
  void knowTechnology(long civilizationId, TechnologyDto technology);
  List<ResourceDto> getVisibleResources(long civilizationId);
  List<TileDto> getVisibleTilesFromRegion(long civilizationId, RegionDto region);
  void computeWealthChange(long civlilizationId);

}
