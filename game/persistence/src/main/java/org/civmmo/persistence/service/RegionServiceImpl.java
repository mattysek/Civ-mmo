package org.civmmo.persistence.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.RegionDto;
import org.civmmo.contracts.services.persistence.RegionService;
import org.civmmo.persistence.model.Region;
import org.civmmo.persistence.repository.RegionRepository;

@Stateless
public class RegionServiceImpl extends BaseService implements RegionService {

    @Inject
    private RegionRepository repository;

    public void create(RegionDto dto) {
        Region region = translate(dto);
        repository.create(region);
        dto.setId(region.getId());

    }

    public void update(RegionDto dto) {
        repository.update(translate(dto));

    }

    public void delete(RegionDto dto) {
        repository.delete(translate(dto));

    }

    public RegionDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<RegionDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

}
