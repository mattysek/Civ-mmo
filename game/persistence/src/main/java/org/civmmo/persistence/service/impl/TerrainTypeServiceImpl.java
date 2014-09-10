package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.TerrainTypeDto;
import org.civmmo.contracts.services.persistence.TerrainTypeService;
import org.civmmo.persistence.model.TerrainType;
import org.civmmo.persistence.repository.TerrainTypeRepository;

@Stateless
public class TerrainTypeServiceImpl extends BaseService implements TerrainTypeService {
    
    @Inject
    private TerrainTypeRepository repository;
    
    public void create(TerrainTypeDto dto) {
        TerrainType tt = translate(dto);
        repository.create(tt);
        dto.setId(tt.getId());
        
    }
    
    public void update(TerrainTypeDto dto) {
        repository.update(translate(dto));
        
    }
    
    public void delete(TerrainTypeDto dto) {
        repository.delete(translate(dto));
        
    }
    
    public TerrainTypeDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<TerrainTypeDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
    
    @Override
    public List<TerrainTypeDto> getAllSQL() {
        return repository.getAllUsingSQL().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<TerrainTypeDto> getAllMongo() {
        return repository.getAllUsingMongo().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<TerrainTypeDto> getAllNeo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public TerrainTypeDto getByIdSQL(long id) {
        return translate(repository.getByIdUsingSQL(id));
    }

    @Override
    public TerrainTypeDto getByIdMongo(long id) {
        return translate(repository.getByIdUsingMongo(id));
    }

    @Override
    public TerrainTypeDto getByIdNeo(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TerrainTypeDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public TerrainTypeDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }
}
