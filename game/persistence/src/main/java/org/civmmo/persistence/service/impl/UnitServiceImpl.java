package org.civmmo.persistence.service.impl;

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
    
    @Override
    public List<UnitDto> getAllSQL() {
        return repository.getAllUsingSQL().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<UnitDto> getAllMongo() {
        return repository.getAllUsingMongo().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<UnitDto> getAllNeo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public UnitDto getByIdSQL(long id) {
        return translate(repository.getByIdUsingSQL(id));
    }

    @Override
    public UnitDto getByIdMongo(long id) {
        return translate(repository.getByIdUsingMongo(id));
    }

    @Override
    public UnitDto getByIdNeo(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UnitDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public UnitDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }

}
