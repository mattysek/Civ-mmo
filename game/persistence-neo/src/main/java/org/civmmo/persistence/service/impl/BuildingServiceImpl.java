package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.BuildingDto;
import org.civmmo.contracts.services.persistence.BuildingService;
import org.civmmo.model.Building;
import org.civmmo.persistence.repository.BuildingRepository;
import org.civmmo.persistence.repository.impl.BuildingRepositoryImpl;

@Stateless
public class BuildingServiceImpl extends BaseService implements BuildingService {

    private final BuildingRepository repository = new BuildingRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(BuildingDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(BuildingDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(BuildingDto dto) {
        runInTransaction(() -> {
            Building action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public BuildingDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id)));
    }
    
    @Override
    public List<BuildingDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList()));
    }

    @Override
    public List<BuildingDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList()));     
    }

    @Override
    public BuildingDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query))); 
    }
}
