package org.civmmo.persistence.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.UnitDto;
import org.civmmo.contracts.services.persistence.UnitService;
import org.civmmo.persistence.model.Unit;
import org.civmmo.persistence.repository.UnitRepository;

@Stateless
public class UnitServiceImpl extends BaseService implements UnitService {

    @Inject
    private UnitRepository repository;

    public void create(UnitDto dto) {
        Unit unit = translate(dto);
        repository.create(unit);
        dto.setId(unit.getId());

    }

    public void update(UnitDto dto) {
        repository.update(translate(dto));

    }

    public void delete(UnitDto dto) {
        repository.delete(translate(dto));

    }

    public UnitDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<UnitDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

}
