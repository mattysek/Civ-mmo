package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.SocialPolicyDto;
import org.civmmo.contracts.services.persistence.SocialPolicyService;
import org.civmmo.model.SocialPolicy;
import org.civmmo.persistence.repository.SocialPolicyRepository;
import org.civmmo.persistence.repository.impl.SocialPolicyRepositoryImpl;

@Stateless
public class SocialPolicyServiceImpl extends BaseService implements SocialPolicyService {

    private final SocialPolicyRepository repository = new SocialPolicyRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(SocialPolicyDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(SocialPolicyDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(SocialPolicyDto dto) {
        runInTransaction(() -> {
            SocialPolicy action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public SocialPolicyDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id),START_LEVEL));
    }
    
    @Override
    public List<SocialPolicyDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));
    }

    @Override
    public List<SocialPolicyDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));     
    }

    @Override
    public SocialPolicyDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL)); 
    }
}
