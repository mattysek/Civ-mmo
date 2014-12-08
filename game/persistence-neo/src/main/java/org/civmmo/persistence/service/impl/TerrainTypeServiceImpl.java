package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.TerrainTypeDto;
import org.civmmo.contracts.services.persistence.TerrainTypeService;
import org.civmmo.model.TerrainType;
import org.civmmo.persistence.repository.TerrainTypeRepository;
import org.civmmo.persistence.repository.impl.TerrainTypeRepositoryImpl;

@Stateless
public class TerrainTypeServiceImpl extends BaseService implements TerrainTypeService {
    
    private final TerrainTypeRepository repository = new TerrainTypeRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(TerrainTypeDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(TerrainTypeDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(TerrainTypeDto dto) {
        runInTransaction(() -> {
            TerrainType action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public TerrainTypeDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id),START_LEVEL));
    }
    
    @Override
    public List<TerrainTypeDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));
    }

    @Override
    public List<TerrainTypeDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));     
    }

    @Override
    public TerrainTypeDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL)); 
    }
}
