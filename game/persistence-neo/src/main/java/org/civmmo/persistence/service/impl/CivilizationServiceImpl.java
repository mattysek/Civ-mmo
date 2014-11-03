package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
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
import org.civmmo.persistence.repository.impl.CivilizationRepositoryImpl;

@Stateless
public class CivilizationServiceImpl extends BaseService implements CivilizationService {

    private final CivilizationRepository repository = new CivilizationRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(CivilizationDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(CivilizationDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(CivilizationDto dto) {
        runInTransaction(() -> {
            Civilization action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public CivilizationDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id)));
    }
    
    @Override
    public List<CivilizationDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList()));
    }

    @Override
    public List<CivilizationDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList()));     
    }

    @Override
    public CivilizationDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query))); 
    }

    @Override
    public void unlockPolicy(long civilizationId, PolicyDto policy) {
        runInTransaction(() -> {
            Civilization civilization = repository.getById(civilizationId);
            civilization.unlockPolicy(translate(policy,TranslateOption.GetById));
        });
    }

    @Override
    public void useSocialPolicy(long civilizationId, SocialPolicyDto socialPolicy) {
        runInTransaction(() -> {
            Civilization civilization = repository.getById(civilizationId);
            civilization.useSocialPolicy(translate(socialPolicy,TranslateOption.GetById));
        });
    }

    @Override
    public void ownSocialPolicy(long civilizationId, SocialPolicyDto socialPolicy) {
        runInTransaction(() -> {
            Civilization civilization = repository.getById(civilizationId);
            civilization.ownSocialPolicy(translate(socialPolicy,TranslateOption.GetById));
        });
    }

    @Override
    public void declareWarBetween(long civilizationId, long civilization2Id) {
        runInTransaction(() -> {
            Civilization civilization = repository.getById(civilizationId);
            Civilization civilization2 = repository.getById(civilization2Id);
            civilization.declareWarBetween(civilization2);
        });
    }

    @Override
    public void declarePeaceBetween(long civilizationId, long civilization2Id) {
        runInTransaction(() -> {
            Civilization civilization = repository.getById(civilizationId);
            Civilization civilization2 = repository.getById(civilization2Id);
            civilization.declarePeaceBetween(civilization2);
        });
    }

    @Override
    public void ownCity(long civilizationId, CityDto city) {
        runInTransaction(() -> {
            Civilization civilization = repository.getById(civilizationId);
            civilization.ownCity(translate(city,TranslateOption.GetById));
        });
    }

    @Override
    public void studyTechnology(long civilizationId, TechnologyDto technology) {
        runInTransaction(() -> {
            Civilization civilization = repository.getById(civilizationId);
            civilization.studyTechnology(translate(technology,TranslateOption.GetById));
        });
    }

    @Override
    public void knowTechnology(long civilizationId, TechnologyDto technology) {
        runInTransaction(() -> {
            Civilization civilization = repository.getById(civilizationId);
            civilization.knowTechnology(translate(technology,TranslateOption.GetById));
        });
    }

    @Override
    public List<ResourceDto> getVisibleResources(long civilizationId) {
        return runInTransaction(() -> {
            Civilization civilization = repository.getById(civilizationId);
            return civilization.getVisibleResources().stream()
                               .map(r -> translate(r))
                               .collect(Collectors.toList());
        });
    }

    @Override
    public List<TileDto> getVisibleTilesFromRegion(long civilizationId, RegionDto region) {
        return runInTransaction(() -> {
            Civilization civilization = repository.getById(civilizationId);
            return civilization.getVisibleTilesFromRegion(translate(region,TranslateOption.GetById)).stream()
                               .map(r -> translate(r))
                               .collect(Collectors.toList());
        });
    }

    @Override
    public void computeWealthChange(long civlilizationId) {
        runInTransaction(() -> {
            Civilization civilization = repository.getById(civlilizationId);
            civilization.computeWealthChange();
        });
    }
}
