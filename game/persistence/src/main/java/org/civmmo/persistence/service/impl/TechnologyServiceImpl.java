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
    
    @Override
    public List<TechnologyDto> getAllSQL() {
        return repository.getAllUsingSQL().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<TechnologyDto> getAllMongo() {
        return repository.getAllUsingMongo().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<TechnologyDto> getAllNeo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public TechnologyDto getByIdSQL(long id) {
        return translate(repository.getByIdUsingSQL(id));
    }

    @Override
    public TechnologyDto getByIdMongo(long id) {
        return translate(repository.getByIdUsingMongo(id));
    }

    @Override
    public TechnologyDto getByIdNeo(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TechnologyDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public TechnologyDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }
}
