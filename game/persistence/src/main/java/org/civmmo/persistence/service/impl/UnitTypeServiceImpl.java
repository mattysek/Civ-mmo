package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.UnitTypeDto;
import org.civmmo.contracts.services.persistence.UnitTypeService;
import org.civmmo.model.UnitType;
import org.civmmo.persistence.repository.UnitTypeRepository;

@Stateless
public class UnitTypeServiceImpl extends BaseService implements UnitTypeService {

    @Inject
    private UnitTypeRepository repository;

    public void create(UnitTypeDto dto) {
        UnitType type = translate(dto);
        repository.create(type);
        dto.setId(type.getId());

    }

    public void update(UnitTypeDto dto) {
        repository.update(translate(dto));

    }

    public void delete(UnitTypeDto dto) {
        repository.delete(translate(dto));

    }

    public UnitTypeDto getById(Long id) {
        return translate(repository.getById(id),START_LEVEL);
    }
    
    public List<UnitTypeDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());
    }
    
    @Override
    public List<UnitTypeDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());     
    }

    @Override
    public UnitTypeDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL); 
    }

}
