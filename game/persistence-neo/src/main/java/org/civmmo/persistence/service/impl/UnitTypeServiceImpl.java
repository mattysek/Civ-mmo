package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.UnitTypeDto;
import org.civmmo.contracts.services.persistence.UnitTypeService;
import org.civmmo.model.UnitType;
import org.civmmo.persistence.repository.UnitTypeRepository;
import org.civmmo.persistence.repository.impl.UnitTypeRepositoryImpl;

@Stateless
public class UnitTypeServiceImpl extends BaseService implements UnitTypeService {

    private final UnitTypeRepository repository = new UnitTypeRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(UnitTypeDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(UnitTypeDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(UnitTypeDto dto) {
        runInTransaction(() -> {
            UnitType action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public UnitTypeDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id)));
    }
    
    @Override
    public List<UnitTypeDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList()));
    }

    @Override
    public List<UnitTypeDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList()));     
    }

    @Override
    public UnitTypeDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query))); 
    }
}
