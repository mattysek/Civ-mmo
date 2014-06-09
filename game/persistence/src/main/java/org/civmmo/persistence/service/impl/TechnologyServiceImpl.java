package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.TechnologyDto;
import org.civmmo.contracts.services.persistence.TechnologyService;
import org.civmmo.persistence.model.Technology;
import org.civmmo.persistence.repository.TechnologyRepository;

@Stateless
public class TechnologyServiceImpl extends BaseService implements TechnologyService {

    @Inject
    private TechnologyRepository repository;

    public void create(TechnologyDto dto) {
        Technology tech = translate(dto);
        repository.create(tech);
        dto.setId(tech.getId());

    }

    public void update(TechnologyDto dto) {
        repository.update(translate(dto));

    }

    public void delete(TechnologyDto dto) {
        repository.delete(translate(dto));

    }

    public TechnologyDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<TechnologyDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
}
