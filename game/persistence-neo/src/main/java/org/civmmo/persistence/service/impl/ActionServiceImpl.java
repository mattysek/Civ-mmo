package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.ActionDto;
import org.civmmo.contracts.services.persistence.ActionService;
import org.civmmo.model.Action;
import org.civmmo.persistence.repository.ActionRepository;
import org.civmmo.persistence.repository.impl.ActionRepositoryImpl;

@Stateless
public class ActionServiceImpl extends BaseService implements ActionService {

    private final ActionRepository repository = new ActionRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
        
    @Override
    public void create(ActionDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(ActionDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(ActionDto dto) {
        runInTransaction(() -> {
            Action action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public ActionDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id)));
    }
    
    @Override
    public List<ActionDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList()));
    }

    @Override
    public List<ActionDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList()));     
    }

    @Override
    public ActionDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query))); 
    }
}
