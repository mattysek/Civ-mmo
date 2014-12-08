package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.RegionDto;
import org.civmmo.contracts.model.ResourceDto;
import org.civmmo.contracts.model.TerrainFeatureDto;
import org.civmmo.contracts.model.TerrainTypeDto;
import org.civmmo.contracts.services.persistence.RegionService;
import org.civmmo.model.Region;
import org.civmmo.persistence.repository.RegionRepository;
import org.civmmo.persistence.repository.impl.RegionRepositoryImpl;

@Stateless
public class RegionServiceImpl extends BaseService implements RegionService {

    private final RegionRepository repository = new RegionRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(RegionDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(RegionDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(RegionDto dto) {
        runInTransaction(() -> {
            Region action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public RegionDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id),START_LEVEL));
    }
    
    @Override
    public List<RegionDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));
    }

    @Override
    public List<RegionDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));     
    }

    @Override
    public RegionDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL)); 
    }

    @Override
    public void generateNewRegion(long regionId,long x, long y, List<TerrainTypeDto> types, List<TerrainFeatureDto> features, List<ResourceDto> resources) {
        runInTransaction(() -> {
            Region region = repository.getById(regionId);
            region.generateNewRegion(x,y,
                                     types.stream()
                                          .map(t -> translate(t,TranslateOption.GetById))
                                          .collect(Collectors.toList()),
                                     features.stream()
                                          .map(t -> translate(t,TranslateOption.GetById))
                                          .collect(Collectors.toList()),
                                     resources.stream()
                                          .map(t -> translate(t,TranslateOption.GetById))
                                          .collect(Collectors.toList()));
        });
    }


}
