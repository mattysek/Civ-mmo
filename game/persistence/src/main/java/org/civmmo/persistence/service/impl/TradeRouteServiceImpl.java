package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.TradeRouteDto;
import org.civmmo.contracts.services.persistence.TradeRouteService;
import org.civmmo.model.TradeRoute;
import org.civmmo.persistence.repository.TradeRouteRepository;

@Stateless
public class TradeRouteServiceImpl extends BaseService implements TradeRouteService {
    
    @Inject
    private TradeRouteRepository repository;
    
    public void create(TradeRouteDto dto) {
        TradeRoute route = translate(dto);
        repository.create(route);
        dto.setId(route.getId());
        
    }
    
    public void update(TradeRouteDto dto) {
        repository.update(translate(dto));
        
    }
    
    public void delete(TradeRouteDto dto) {
        repository.delete(translate(dto));
        
    }
    
    public TradeRouteDto getById(Long id) {
        return translate(repository.getById(id),START_LEVEL);
    }
    
    public List<TradeRouteDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());
    }
    
    @Override
    public List<TradeRouteDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());     
    }

    @Override
    public TradeRouteDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL); 
    }
}
