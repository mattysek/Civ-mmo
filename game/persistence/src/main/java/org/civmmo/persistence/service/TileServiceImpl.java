package org.civmmo.persistence.service;

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
}
