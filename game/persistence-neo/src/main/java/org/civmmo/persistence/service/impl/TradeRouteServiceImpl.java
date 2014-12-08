package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import org.civmmo.contracts.model.TradeRouteDto;
import org.civmmo.contracts.services.persistence.TradeRouteService;
import org.civmmo.model.TradeRoute;
import org.civmmo.persistence.repository.TradeRouteRepository;
import org.civmmo.persistence.repository.impl.TradeRouteRepositoryImpl;

@Stateless
public class TradeRouteServiceImpl extends BaseService implements TradeRouteService {
    
    private final TradeRouteRepository repository = new TradeRouteRepositoryImpl(GraphDatabaseServiceBean.getGraphDb());
    
    @Override
    public void create(TradeRouteDto dto) {
        runInTransaction(() -> repository.create(translate(dto,TranslateOption.New)));
    }
    
    @Override
    public void update(TradeRouteDto dto) {
        runInTransaction(() -> translate(dto, TranslateOption.GetById));
    }

    @Override
    public void delete(TradeRouteDto dto) {
        runInTransaction(() -> {
            TradeRoute action = repository.getById(dto.getId());
            repository.delete(action);
        });
    }

    @Override
    public TradeRouteDto getById(Long id) {
        return runInTransaction(() -> translate(repository.getById(id),START_LEVEL));
    }
    
    @Override
    public List<TradeRouteDto> getAll() {
        return runInTransaction(() -> repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));
    }

    @Override
    public List<TradeRouteDto> testGetListNativeQuery(String query) {
        return runInTransaction(() -> repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList()));     
    }

    @Override
    public TradeRouteDto testGetSingleNativeQuery(String query) {
        return runInTransaction(() -> translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL)); 
    }
}
