package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.PromotionDto;
import org.civmmo.contracts.services.persistence.PromotionService;
import org.civmmo.model.Promotion;
import org.civmmo.persistence.repository.PromotionRepository;
import org.civmmo.persistence.repository.impl.PromotionRepositoryImpl;

@Stateless
public class PromotionServiceImpl extends BaseService implements PromotionService {
    
    private final PromotionRepository repository = new PromotionRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(PromotionDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(PromotionDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(PromotionDto dto) {
        runInTransaction(() -> {
            Promotion action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public PromotionDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id),START_LEVEL));
    }
    
    @Override
    public List<PromotionDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));
    }

    @Override
    public List<PromotionDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));     
    }

    @Override
    public PromotionDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL)); 
    }
}
