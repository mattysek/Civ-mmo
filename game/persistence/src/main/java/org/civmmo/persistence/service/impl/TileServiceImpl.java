package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.TileDto;
import org.civmmo.contracts.services.persistence.TileService;
import org.civmmo.persistence.model.Tile;
import org.civmmo.persistence.repository.TileRepository;

@Stateless
public class TileServiceImpl extends BaseService implements TileService {
    
    @Inject
    private TileRepository repository;
    
    public void create(TileDto dto) {
        Tile tile = translate(dto);
        repository.create(tile);
        dto.setId(tile.getId());
        
    }
    
    public void update(TileDto dto) {
        repository.update(translate(dto));
        
    }
    
    public void delete(TileDto dto) {
        repository.delete(translate(dto));
        
    }
    
    public TileDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<TileDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
    
    @Override
    public List<TileDto> getAllSQL() {
        return repository.getAllUsingSQL().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<TileDto> getAllMongo() {
        return repository.getAllUsingMongo().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<TileDto> getAllNeo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public TileDto getByIdSQL(long id) {
        return translate(repository.getByIdUsingSQL(id));
    }

    @Override
    public TileDto getByIdMongo(long id) {
        return translate(repository.getByIdUsingMongo(id));
    }

    @Override
    public TileDto getByIdNeo(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TileDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public TileDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }
}
