package org.civmmo.persistence.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.TradeRouteDto;
import org.civmmo.contracts.services.persistence.TradeRouteService;
import org.civmmo.persistence.model.TradeRoute;
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
        return translate(repository.getById(id));
    }
    
    public List<TradeRouteDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e)).collect(Collectors.toList());
    }
}
