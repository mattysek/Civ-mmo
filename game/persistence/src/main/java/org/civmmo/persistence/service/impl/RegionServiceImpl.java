package org.civmmo.persistence.service.impl;

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
    
    @Override
    public List<RegionDto> getAllSQL() {
        return repository.getAllUsingSQL().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<RegionDto> getAllMongo() {
        return repository.getAllUsingMongo().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<RegionDto> getAllNeo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public RegionDto getByIdSQL(long id) {
        return translate(repository.getByIdUsingSQL(id));
    }

    @Override
    public RegionDto getByIdMongo(long id) {
        return translate(repository.getByIdUsingMongo(id));
    }

    @Override
    public RegionDto getByIdNeo(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RegionDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public RegionDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }

}
