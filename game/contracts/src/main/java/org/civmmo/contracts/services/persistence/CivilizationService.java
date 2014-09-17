package org.civmmo.contracts.services.persistence;

import org.civmmo.contracts.model.*;
import java.util.List;

public interface CivilizationService extends CRUDService<CivilizationDto>,QueryableService<CivilizationDto> {

  void unlockPolicy(long civilizationId, PolicyDto policyId);
  void useSocialPolicy(long civilizationId, SocialPolicyDto socialPolicyId);
  void ownSocialPolicy(long civilizationId, SocialPolicyDto socialPolicyId);
  void declareWarBetween(long civilizationId, long civilizationId);
  void declarePeaceBetween(long civilizationId, long civilization2Id);
  void ownCity(long civilizationId, CityDto city);
  void studyTechnology(long civilizationId, TechnologyDto technology);
  void knowTechnology(long civilizationId, TechnologyDto technology);
  List<ResourceDto> getVisibleResources(long civilizationId);
  List<TileDto> getVisibleTilesFromRegion(long civilizationId, RegionDto region);
  void computeWealthChange(long civlilizationId);

}
