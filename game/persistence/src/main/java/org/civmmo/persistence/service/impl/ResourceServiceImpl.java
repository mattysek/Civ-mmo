package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.ResourceDto;
import org.civmmo.contracts.services.persistence.ResourceService;
import org.civmmo.persistence.model.Resource;
import org.civmmo.persistence.repository.ResourceRepository;

@Stateless
public class ResourceServiceImpl extends BaseService implements ResourceService {

    @Inject
    private ResourceRepository repository;

    public void create(ResourceDto dto) {
        Resource res = translate(dto);
        repository.create(res);
        dto.setId(res.getId());

    }

    public void update(ResourceDto dto) {
        repository.update(translate(dto));

    }

    public void delete(ResourceDto dto) {
        repository.delete(translate(dto));

    }

    public ResourceDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<ResourceDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
    
    @Override
    public List<ResourceDto> getAllSQL() {
        return repository.getAllUsingSQL().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<ResourceDto> getAllMongo() {
        return repository.getAllUsingMongo().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<ResourceDto> getAllNeo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ResourceDto getByIdSQL(long id) {
        return translate(repository.getByIdUsingSQL(id));
    }

    @Override
    public ResourceDto getByIdMongo(long id) {
        return translate(repository.getByIdUsingMongo(id));
    }

    @Override
    public ResourceDto getByIdNeo(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ResourceDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public ResourceDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }
}
