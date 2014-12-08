package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.TileDto;
import org.civmmo.contracts.services.persistence.TileService;
import org.civmmo.model.Tile;
import org.civmmo.persistence.repository.TileRepository;
import org.civmmo.persistence.repository.impl.TileRepositoryImpl;

@Stateless
public class TileServiceImpl extends BaseService implements TileService {
    
    private final TileRepository repository = new TileRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(TileDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(TileDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(TileDto dto) {
        runInTransaction(() -> {
            Tile action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public TileDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id),START_LEVEL));
    }
    
    @Override
    public List<TileDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));
    }

    @Override
    public List<TileDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));     
    }

    @Override
    public TileDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL)); 
    }

    @Override
    public boolean isRiver(long tileId) {
        return runInTransaction(() -> {
            Tile tile = repository.getById(tileId);
            return tile.isRiver();
        });
    }
}
