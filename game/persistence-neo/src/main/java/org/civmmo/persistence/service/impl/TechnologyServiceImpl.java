package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.TechnologyDto;
import org.civmmo.contracts.services.persistence.TechnologyService;
import org.civmmo.model.Technology;
import org.civmmo.persistence.repository.TechnologyRepository;
import org.civmmo.persistence.repository.impl.TechnologyRepositoryImpl;

@Stateless
public class TechnologyServiceImpl extends BaseService implements TechnologyService {

    private final TechnologyRepository repository = new TechnologyRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(TechnologyDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(TechnologyDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(TechnologyDto dto) {
        runInTransaction(() -> {
            Technology action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public TechnologyDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id)));
    }
    
    @Override
    public List<TechnologyDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList()));
    }

    @Override
    public List<TechnologyDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList()));     
    }

    @Override
    public TechnologyDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query))); 
    }
}
