package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.TerrainTypeDto;
import org.civmmo.contracts.services.persistence.TerrainTypeService;
import org.civmmo.model.TerrainType;
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
        return translate(repository.getById(id),START_LEVEL);
    }
    
    public List<TerrainTypeDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());
    }
    
    @Override
    public List<TerrainTypeDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());     
    }

    @Override
    public TerrainTypeDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL); 
    }
}
