package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.RiverDto;
import org.civmmo.contracts.services.persistence.RiverService;
import org.civmmo.model.River;
import org.civmmo.persistence.repository.RiverRepository;

@Stateless
public class RiverServiceImpl extends BaseService implements RiverService {

    @Inject
    private RiverRepository repository;

    public void create(RiverDto dto) {
        River river = translate(dto);
        repository.create(river);
        dto.setId(river.getId());
    }

    public void update(RiverDto dto) {
        repository.update(translate(dto));

    }

    public void delete(RiverDto dto) {
        repository.delete(translate(dto));

    }

    public RiverDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<RiverDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
    
    @Override
    public List<RiverDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public RiverDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }

}
