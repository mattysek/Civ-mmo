package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.PolicyDto;
import org.civmmo.contracts.services.persistence.PolicyService;
import org.civmmo.model.Policy;
import org.civmmo.persistence.repository.PolicyRepository;
import org.civmmo.persistence.repository.impl.PolicyRepositoryImpl;

@Stateless
public class PolicyServiceImpl extends BaseService implements PolicyService {
    
    private final PolicyRepository repository = new PolicyRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(PolicyDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(PolicyDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(PolicyDto dto) {
        runInTransaction(() -> {
            Policy action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public PolicyDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id)));
    }
    
    @Override
    public List<PolicyDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList()));
    }

    @Override
    public List<PolicyDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e)).collect(Collectors.toList()));     
    }

    @Override
    public PolicyDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query))); 
    }
}
