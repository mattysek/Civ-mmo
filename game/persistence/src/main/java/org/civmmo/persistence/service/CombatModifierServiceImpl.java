package org.civmmo.persistence.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.CombatModifierDto;
import org.civmmo.contracts.services.persistence.CombatModifierService;
import org.civmmo.persistence.model.CombatModifier;
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
        return translate(repository.getById(id));
    }
    
    public List<CombatModifierDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
}
