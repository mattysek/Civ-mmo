package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.BuildingDto;
import org.civmmo.contracts.services.persistence.BuildingService;
import org.civmmo.model.Building;
import org.civmmo.persistence.repository.BuildingRepository;

@Stateless
public class BuildingServiceImpl extends BaseService implements BuildingService {

    @Inject
    private BuildingRepository repository;

    public void create(BuildingDto dto) {
        Building building = translate(dto);
        repository.create(building);
        dto.setId(building.getId());

    }

    public void update(BuildingDto dto) {
        repository.update(translate(dto));

    }

    public void delete(BuildingDto dto) {
        repository.delete(translate(dto));

    }

    public BuildingDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<BuildingDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
    
    @Override
    public List<BuildingDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public BuildingDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }
}
