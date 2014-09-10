package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.SocialPolicyDto;
import org.civmmo.contracts.services.persistence.SocialPolicyService;
import org.civmmo.persistence.model.SocialPolicy;
import org.civmmo.persistence.repository.SocialPolicyRepository;

@Stateless
public class SocialPolicyServiceImpl extends BaseService implements SocialPolicyService {

    @Inject
    private SocialPolicyRepository repository;

    public void create(SocialPolicyDto dto) {
        SocialPolicy policy = translate(dto);
        repository.create(policy);
        dto.setId(policy.getId());

    }

    public void update(SocialPolicyDto dto) {
        repository.update(translate(dto));

    }

    public void delete(SocialPolicyDto dto) {
        repository.delete(translate(dto));

    }

    public SocialPolicyDto getById(Long id) {
        return translate(repository.getById(id));
    }
    
    public List<SocialPolicyDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
    
    @Override
    public List<SocialPolicyDto> getAllSQL() {
        return repository.getAllUsingSQL().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<SocialPolicyDto> getAllMongo() {
        return repository.getAllUsingMongo().stream().map(e -> translate(e)).collect(Collectors.toList());
    }

    @Override
    public List<SocialPolicyDto> getAllNeo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public SocialPolicyDto getByIdSQL(long id) {
        return translate(repository.getByIdUsingSQL(id));
    }

    @Override
    public SocialPolicyDto getByIdMongo(long id) {
        return translate(repository.getByIdUsingMongo(id));
    }

    @Override
    public SocialPolicyDto getByIdNeo(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SocialPolicyDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList());     
    }

    @Override
    public SocialPolicyDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query)); 
    }
}
