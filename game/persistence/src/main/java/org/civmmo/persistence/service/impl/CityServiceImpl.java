package org.civmmo.persistence.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.civmmo.contracts.model.BuildingDto;
import org.civmmo.contracts.model.CityDto;
import org.civmmo.contracts.model.TileDto;
import org.civmmo.contracts.model.UnitDto;
import org.civmmo.contracts.services.persistence.CityService;
import org.civmmo.model.City;
import org.civmmo.model.Unit;
import org.civmmo.persistence.repository.CityRepository;

@Stateless
public class CityServiceImpl extends BaseService implements CityService {
    
    @Inject
    private CityRepository repository;
    
    public void create(CityDto dto) {
        City city = translate(dto);
        repository.create(city);
        dto.setId(city.getId());
        
    }
    
    public void update(CityDto dto) {
        repository.update(translate(dto));
        
    }
    
    public void delete(CityDto dto) {
        repository.delete(translate(dto));
        
    }
    
    public CityDto getById(Long id) {
        return translate(repository.getById(id),START_LEVEL);
    }
    
    public List<CityDto> getAll() {
        return repository.getAll().stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());
    }
    
    @Override
    public List<CityDto> testGetListNativeQuery(String query) {
        return repository.getResultListOfNativeQuery(query)
                         .stream().map(e -> translate(e,START_LEVEL)).collect(Collectors.toList());     
    }

    @Override
    public CityDto testGetSingleNativeQuery(String query) {
        return translate(repository.getSingleResultOfNativeQuery(query),START_LEVEL); 
    }

    @Override
    public void constructBuilding(long cityId, BuildingDto building) {
        City city = repository.getById(cityId);
        city.constructBuilding(translate(building));
        repository.update(city);
    }

    @Override
    public void workBuilding(long cityId, BuildingDto building) {
        City city = repository.getById(cityId);
        city.workBuilding(translate(building));
        repository.update(city);
    }

    @Override
    public void constructUnit(long cityId, UnitDto unit) {
        City city = repository.getById(cityId);
        city.constructUnit(translate(unit));
        repository.update(city);
    }

    @Override
    public boolean hasTradeRouteWith(long cityId, long city2Id) {
        City city = repository.getById(cityId);
        City city2 = repository.getById(city2Id);
        return city.hasTradeRouteWith(city2);
    }

    @Override
    public void controlTile(long cityId, TileDto tile) {
        City city = repository.getById(cityId);
        city.controlTile(translate(tile));
        repository.update(city);
    }

    @Override
    public void workTile(long cityId, TileDto tile) {
        City city = repository.getById(cityId);
        city.workTile(translate(tile));
        repository.update(city);
    }
    
    @Override
    public CityDto computeWealthGrowth(long cityId) {
        City city = repository.getById(cityId);
        city.computeWealthGrowth();
        repository.update(city);
        return translate(city,START_LEVEL);
    }

    @Override
    public void getAttackedByUnit(long cityId, UnitDto unit) {
        City city = repository.getById(cityId);
        Unit unitentity = translate(unit);
        //city.attackUnit(unitentity);
        if(unitentity.getHitPoints() > 0)
        {
             city.getAttackedByUnit(unitentity);
        }
        repository.update(city);
    }

    @Override
    public void attackUnit(long cityId, UnitDto unit) {
        City city = repository.getById(cityId);
        city.attackUnit(translate(unit));
        repository.update(city);
    }
}
