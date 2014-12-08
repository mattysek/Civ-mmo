package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.RiverDto;
import org.civmmo.contracts.services.persistence.RiverService;
import org.civmmo.model.River;
import org.civmmo.persistence.repository.RiverRepository;
import org.civmmo.persistence.repository.impl.RiverRepositoryImpl;

@Stateless
public class RiverServiceImpl extends BaseService implements RiverService {

    private final RiverRepository repository = new RiverRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(RiverDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(RiverDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(RiverDto dto) {
        runInTransaction(() -> {
            River action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public RiverDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id),START_LEVEL));
    }
    
    @Override
    public List<RiverDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));
    }

    @Override
    public List<RiverDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));     
    }

    @Override
    public RiverDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL)); 
    }

}
