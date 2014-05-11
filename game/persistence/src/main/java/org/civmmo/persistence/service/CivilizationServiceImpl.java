package org.civmmo.persistence.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.CivilizationDto;
import org.civmmo.contracts.services.persistence.CivilizationService;
import org.civmmo.persistence.model.Civilization;
import org.civmmo.persistence.repository.CivilizationRepository;

@Stateless
public class CivilizationServiceImpl extends BaseService implements CivilizationService {

    @Inject
    private CivilizationRepository repository;

    public void create(CivilizationDto dto) {
        Civilization civ = translate(dto);
        repository.create(civ);
        dto.setId(civ.getId());
    }

    public void update(CivilizationDto dto) {
        repository.update(translate(dto));

    }

    public void delete(CivilizationDto dto) {
        repository.delete(translate(dto));

    }

    public CivilizationDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<CivilizationDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
}
