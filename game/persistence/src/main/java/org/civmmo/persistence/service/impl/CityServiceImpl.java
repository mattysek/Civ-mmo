package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.CityDto;
import org.civmmo.contracts.services.persistence.CityService;
import org.civmmo.persistence.model.City;
import org.civmmo.persistence.repository.CityRepository;

@Stateless
public class CityServiceImpl extends BaseService implements CityService {
    
    @Inject
    private CityRepository repository;
    
    public void create(CityDto dto) {
        City city = translate(dto);
        repository.create(city);
        dto.setId(city.getId());
        
    }
    
    public void update(CityDto dto) {
        repository.update(translate(dto));
        
    }
    
    public void delete(CityDto dto) {
        repository.delete(translate(dto));
        
    }
    
    public CityDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<CityDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
}
