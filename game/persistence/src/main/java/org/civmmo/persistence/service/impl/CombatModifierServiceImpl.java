package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.CombatModifierDto;
import org.civmmo.contracts.services.persistence.CombatModifierService;
import org.civmmo.model.CombatModifier;
import org.civmmo.persistence.repository.CombatModifierRepository;

@Stateless
public class CombatModifierServiceImpl extends BaseService implements CombatModifierService {

    @Inject
    private CombatModifierRepository repository;

    public void create(CombatModifierDto dto) {
        CombatModifier modifier = translate(dto);
        repository.create(modifier);
        dto.setId(modifier.getId());

    }

    public void update(CombatModifierDto dto) {
        repository.update(translate(dto));

    }

    public void delete(CombatModifierDto dto) {
        repository.delete(translate(dto));

    }

    public CombatModifierDto getById(Long id) {
        return translate(repository.getById(id),START_LEVEL);
    }
    
    public List<CombatModifierDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());
    }
    
    @Override
    public List<CombatModifierDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());     
    }

    @Override
    public CombatModifierDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL); 
    }
}
