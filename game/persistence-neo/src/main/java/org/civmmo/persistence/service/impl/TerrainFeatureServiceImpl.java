package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.TerrainFeatureDto;
import org.civmmo.contracts.services.persistence.TerrainFeatureService;
import org.civmmo.model.TerrainFeature;
import org.civmmo.persistence.repository.TerrainFeatureRepository;
import org.civmmo.persistence.repository.impl.TerrainFeatureRepositoryImpl;

@Stateless
public class TerrainFeatureServiceImpl extends BaseService implements TerrainFeatureService {
    
    private final TerrainFeatureRepository repository = new TerrainFeatureRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(TerrainFeatureDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(TerrainFeatureDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(TerrainFeatureDto dto) {
        runInTransaction(() -> {
            TerrainFeature action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public TerrainFeatureDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id)));
    }
    
    @Override
    public List<TerrainFeatureDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList()));
    }

    @Override
    public List<TerrainFeatureDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList()));     
    }

    @Override
    public TerrainFeatureDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query))); 
    }
}
