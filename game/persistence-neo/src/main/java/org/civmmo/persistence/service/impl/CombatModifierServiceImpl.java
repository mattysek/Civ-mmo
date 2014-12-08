package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.CombatModifierDto;
import org.civmmo.contracts.services.persistence.CombatModifierService;
import org.civmmo.model.CombatModifier;
import org.civmmo.persistence.repository.CombatModifierRepository;
import org.civmmo.persistence.repository.impl.CombatModifierRepositoryImpl;

@Stateless
public class CombatModifierServiceImpl extends BaseService implements CombatModifierService {

    private final CombatModifierRepository repository = new CombatModifierRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(CombatModifierDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(CombatModifierDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(CombatModifierDto dto) {
        runInTransaction(() -> {
            CombatModifier action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public CombatModifierDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id),0));
    }
    
    @Override
    public List<CombatModifierDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e,0)).collect(Collectors.toList()));
    }

    @Override
    public List<CombatModifierDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,0)).collect(Collectors.toList()));     
    }

    @Override
    public CombatModifierDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query),0)); 
    }
}
