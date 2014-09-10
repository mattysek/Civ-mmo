package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.TerrainFeatureDto;
import org.civmmo.contracts.services.persistence.TerrainFeatureService;
import org.civmmo.persistence.model.TerrainFeature;
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
        return translate(repository.getById(id));
    }
    
    public List<TerrainFeatureDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
    
    @Override
    public List<TerrainFeatureDto> getAllSQL() {
        return repository.getAllUsingSQL().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<TerrainFeatureDto> getAllMongo() {
        return repository.getAllUsingMongo().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<TerrainFeatureDto> getAllNeo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public TerrainFeatureDto getByIdSQL(long id) {
        return translate(repository.getByIdUsingSQL(id));
    }

    @Override
    public TerrainFeatureDto getByIdMongo(long id) {
        return translate(repository.getByIdUsingMongo(id));
    }

    @Override
    public TerrainFeatureDto getByIdNeo(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TerrainFeatureDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public TerrainFeatureDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }
}
