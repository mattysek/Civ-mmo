package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.RegionDto;
import org.civmmo.contracts.model.ResourceDto;
import org.civmmo.contracts.model.TerrainFeatureDto;
import org.civmmo.contracts.model.TerrainTypeDto;
import org.civmmo.contracts.services.persistence.RegionService;
import org.civmmo.model.Region;
import org.civmmo.persistence.repository.RegionRepository;

@Stateless
public class RegionServiceImpl extends BaseService implements RegionService {

    @Inject
    private RegionRepository repository;

    public void create(RegionDto dto) {
        Region region = translate(dto);
        repository.create(region);
        dto.setId(region.getId());

    }

    public void update(RegionDto dto) {
        repository.update(translate(dto));

    }

    public void delete(RegionDto dto) {
        repository.delete(translate(dto));

    }

    public RegionDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<RegionDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
    
    @Override
    public List<RegionDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public RegionDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }

    @Override
    public void generateNewRegion(long regionId,long x, long y, List<TerrainTypeDto> types, List<TerrainFeatureDto> features, List<ResourceDto> resources) {
        Region region = repository.getById(regionId);
        region.generateNewRegion(x,y,
                                 types.stream()
                                      .map(t -> translate(t))
                                      .collect(Collectors.toList()),
                                 features.stream()
                                      .map(t -> translate(t))
                                      .collect(Collectors.toList()),
                                 resources.stream()
                                      .map(t -> translate(t))
                                      .collect(Collectors.toList()));
        repository.update(region);
    }


}
