package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.TerrainFeatureDto;
import org.civmmo.contracts.services.persistence.TerrainFeatureService;
import org.civmmo.model.TerrainFeature;
import org.civmmo.persistence.repository.TerrainFeatureRepository;

@Stateless
public class TerrainFeatureServiceImpl extends BaseService implements TerrainFeatureService {
    
    @Inject
    private TerrainFeatureRepository repository;
    
    public void create(TerrainFeatureDto dto) {
        TerrainFeature tf = translate(dto);
        repository.create(tf);
        dto.setId(tf.getId());
        
    }
    
    public void update(TerrainFeatureDto dto) {
        repository.update(translate(dto));
        
    }
    
    public void delete(TerrainFeatureDto dto) {
        repository.delete(translate(dto));
        
    }
    
    public TerrainFeatureDto getById(Long id) {
        return translate(repository.getById(id),START_LEVEL);
    }
    
    public List<TerrainFeatureDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());
    }
    
    @Override
    public List<TerrainFeatureDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());     
    }

    @Override
    public TerrainFeatureDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL); 
    }
}
