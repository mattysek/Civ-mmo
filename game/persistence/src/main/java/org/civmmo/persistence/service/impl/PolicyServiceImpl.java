package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.PolicyDto;
import org.civmmo.contracts.services.persistence.PolicyService;
import org.civmmo.persistence.model.Policy;
import org.civmmo.persistence.repository.PolicyRepository;

@Stateless
public class PolicyServiceImpl extends BaseService implements PolicyService {
    
    @Inject
    private PolicyRepository repository;
    
    public void create(PolicyDto dto) {
        Policy policy = translate(dto);
        repository.create(policy);
        dto.setId(policy.getId());
        
    }
    
    public void update(PolicyDto dto) {
        repository.update(translate(dto));
        
    }
    
    public void delete(PolicyDto dto) {
        repository.delete(translate(dto));
        
    }
    
    public PolicyDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<PolicyDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
    
    @Override
    public List<PolicyDto> getAllSQL() {
        return repository.getAllUsingSQL().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<PolicyDto> getAllMongo() {
        return repository.getAllUsingMongo().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<PolicyDto> getAllNeo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public PolicyDto getByIdSQL(long id) {
        return translate(repository.getByIdUsingSQL(id));
    }

    @Override
    public PolicyDto getByIdMongo(long id) {
        return translate(repository.getByIdUsingMongo(id));
    }

    @Override
    public PolicyDto getByIdNeo(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PolicyDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public PolicyDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }
}
