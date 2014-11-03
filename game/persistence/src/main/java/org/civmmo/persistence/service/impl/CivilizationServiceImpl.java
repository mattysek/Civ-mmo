package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.CityDto;
import org.civmmo.contracts.model.CivilizationDto;
import org.civmmo.contracts.model.PolicyDto;
import org.civmmo.contracts.model.RegionDto;
import org.civmmo.contracts.model.ResourceDto;
import org.civmmo.contracts.model.SocialPolicyDto;
import org.civmmo.contracts.model.TechnologyDto;
import org.civmmo.contracts.model.TileDto;
import org.civmmo.contracts.services.persistence.CivilizationService;
import org.civmmo.model.Civilization;
import org.civmmo.persistence.repository.CivilizationRepository;

@Stateless
public class CivilizationServiceImpl extends BaseService implements CivilizationService {

    @Inject
    private CivilizationRepository repository;

    public void create(CivilizationDto dto) {
        Civilization civ = translate(dto);
        repository.create(civ);
        dto.setId(civ.getId());
    }

    public void update(CivilizationDto dto) {
        repository.update(translate(dto));

    }

    public void delete(CivilizationDto dto) {
        repository.delete(translate(dto));

    }

    public CivilizationDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<CivilizationDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
    
    @Override
    public List<CivilizationDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public CivilizationDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }

    @Override
    public void unlockPolicy(long civilizationId, PolicyDto policy) {
        Civilization civilization = repository.getById(civilizationId);
        civilization.unlockPolicy(translate(policy));
        repository.update(civilization);
    }

    @Override
    public void useSocialPolicy(long civilizationId, SocialPolicyDto socialPolicy) {
        Civilization civilization = repository.getById(civilizationId);
        civilization.useSocialPolicy(translate(socialPolicy));
        repository.update(civilization);
    }

    @Override
    public void ownSocialPolicy(long civilizationId, SocialPolicyDto socialPolicy) {
        Civilization civilization = repository.getById(civilizationId);
        civilization.ownSocialPolicy(translate(socialPolicy));
        repository.update(civilization);
    }

    @Override
    public void declareWarBetween(long civilizationId, long civilization2Id) {
        Civilization civilization = repository.getById(civilizationId);
        Civilization civilization2 = repository.getById(civilization2Id);
        civilization.declareWarBetween(civilization2);
        repository.update(civilization);
        repository.update(civilization2);
    }

    @Override
    public void declarePeaceBetween(long civilizationId, long civilization2Id) {
        Civilization civilization = repository.getById(civilizationId);
        Civilization civilization2 = repository.getById(civilization2Id);
        civilization.declarePeaceBetween(civilization2);
        repository.update(civilization);
        repository.update(civilization2);
    }

    @Override
    public void ownCity(long civilizationId, CityDto city) {
        Civilization civilization = repository.getById(civilizationId);
        civilization.ownCity(translate(city));
        repository.update(civilization);
    }

    @Override
    public void studyTechnology(long civilizationId, TechnologyDto technology) {
        Civilization civilization = repository.getById(civilizationId);
        civilization.studyTechnology(translate(technology));
        repository.update(civilization);
    }

    @Override
    public void knowTechnology(long civilizationId, TechnologyDto technology) {
        Civilization civilization = repository.getById(civilizationId);
        civilization.knowTechnology(translate(technology));
        repository.update(civilization);
    }

    @Override
    public List<ResourceDto> getVisibleResources(long civilizationId) {
        Civilization civilization = repository.getById(civilizationId);
        return civilization.getVisibleResources().stream()
                           .map(r -> translate(r))
                           .collect(Collectors.toList());
    }

    @Override
    public List<TileDto> getVisibleTilesFromRegion(long civilizationId, RegionDto region) {
        Civilization civilization = repository.getById(civilizationId);
        return civilization.getVisibleTilesFromRegion(translate(region)).stream()
                           .map(r -> translate(r))
                           .collect(Collectors.toList());
    }

    @Override
    public void computeWealthChange(long civlilizationId) {
        Civilization civilization = repository.getById(civlilizationId);
        civilization.computeWealthChange();
        repository.update(civilization);
    }
}
