package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.ActionDto;
import org.civmmo.contracts.services.persistence.ActionService;
import org.civmmo.model.Action;
import org.civmmo.persistence.repository.ActionRepository;

@Stateless
public class ActionServiceImpl extends BaseService implements ActionService {
    
    @Inject
    private ActionRepository repository;
    
    public void create(ActionDto dto) {
        Action action = translate(dto);
        repository.create(action);
        dto.setId(action.getId());
    }

    public void update(ActionDto dto) {
        repository.update(translate(dto));
    }

    public void delete(ActionDto dto) {
        repository.delete(translate(dto));
    }

    public ActionDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<ActionDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<ActionDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public ActionDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }
}
