package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.ResourceDto;
import org.civmmo.contracts.services.persistence.ResourceService;
import org.civmmo.model.Resource;
import org.civmmo.persistence.repository.ResourceRepository;
import org.civmmo.persistence.repository.impl.ResourceRepositoryImpl;

@Stateless
public class ResourceServiceImpl extends BaseService implements ResourceService {

    private final ResourceRepository repository = new ResourceRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(ResourceDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(ResourceDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(ResourceDto dto) {
        runInTransaction(() -> {
            Resource action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public ResourceDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id),START_LEVEL));
    }
    
    @Override
    public List<ResourceDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));
    }

    @Override
    public List<ResourceDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));     
    }

    @Override
    public ResourceDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL)); 
    }
}
