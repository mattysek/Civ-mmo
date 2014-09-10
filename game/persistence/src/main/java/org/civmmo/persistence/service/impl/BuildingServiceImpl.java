package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.BuildingDto;
import org.civmmo.contracts.services.persistence.BuildingService;
import org.civmmo.persistence.model.Building;
import org.civmmo.persistence.repository.BuildingRepository;

@Stateless
public class BuildingServiceImpl extends BaseService implements BuildingService {

    @Inject
    private BuildingRepository repository;

    public void create(BuildingDto dto) {
        Building building = translate(dto);
        repository.create(building);
        dto.setId(building.getId());

    }

    public void update(BuildingDto dto) {
        repository.update(translate(dto));

    }

    public void delete(BuildingDto dto) {
        repository.delete(translate(dto));

    }

    public BuildingDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<BuildingDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
    
    @Override
    public List<BuildingDto> getAllSQL() {
        return repository.getAllUsingSQL().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<BuildingDto> getAllMongo() {
        return repository.getAllUsingMongo().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<BuildingDto> getAllNeo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public BuildingDto getByIdSQL(long id) {
        return translate(repository.getByIdUsingSQL(id));
    }

    @Override
    public BuildingDto getByIdMongo(long id) {
        return translate(repository.getByIdUsingMongo(id));
    }

    @Override
    public BuildingDto getByIdNeo(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BuildingDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public BuildingDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }
}
