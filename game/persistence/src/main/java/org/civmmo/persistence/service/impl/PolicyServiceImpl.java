package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.PolicyDto;
import org.civmmo.contracts.services.persistence.PolicyService;
import org.civmmo.model.Policy;
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
        return translate(repository.getById(id),START_LEVEL);
    }
    
    public List<PolicyDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());
    }
    
    @Override
    public List<PolicyDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());     
    }

    @Override
    public PolicyDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL); 
    }
}
