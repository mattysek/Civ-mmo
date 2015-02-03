package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.TileDto;
import org.civmmo.contracts.services.persistence.TileService;
import org.civmmo.model.Tile;
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
        return translate(repository.getById(id),START_LEVEL);
    }
    
    public List<TileDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());
    }
    
    @Override
    public List<TileDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());     
    }

    @Override
    public TileDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL); 
    }

    @Override
    public boolean isRiver(long tileId) {
        Tile tile = repository.getById(tileId);
        return tile.isRiver();
    }

    @Override
    public List<TileDto> getUnusedTilesOfRegion(long regionId) {
        return repository.getUnusedTilesOfRegion(regionId).stream().map(t -> translate(t,START_LEVEL)).collect(Collectors.toList());
    }

    @Override
    public List<TileDto> getvisibleTilesOfRegionforCiv(long regionId, long civId) {
        return repository.getvisibleTilesOfRegionforCiv(regionId,civId).stream().map(t -> translate(t,START_LEVEL)).collect(Collectors.toList());
    }
}
