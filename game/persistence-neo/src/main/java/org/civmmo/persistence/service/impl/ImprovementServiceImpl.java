package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.ImprovementDto;
import org.civmmo.contracts.services.persistence.ImprovementService;
import org.civmmo.model.Improvement;
import org.civmmo.persistence.repository.ImprovementRepository;
import org.civmmo.persistence.repository.impl.ImprovementRepositoryImpl;

@Stateless
public class ImprovementServiceImpl extends BaseService implements ImprovementService {
    
    private final ImprovementRepository repository = new ImprovementRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(ImprovementDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(ImprovementDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(ImprovementDto dto) {
        runInTransaction(() -> {
            Improvement action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public ImprovementDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id),START_LEVEL));
    }
    
    @Override
    public List<ImprovementDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));
    }

    @Override
    public List<ImprovementDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));     
    }

    @Override
    public ImprovementDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL)); 
    }
}
