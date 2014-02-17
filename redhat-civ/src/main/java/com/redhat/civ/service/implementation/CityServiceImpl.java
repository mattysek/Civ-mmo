package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.CityDao;
import com.redhat.civ.dto.CityDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.City;
import com.redhat.civ.service.interfaces.CityService;

@Stateless
public class CityServiceImpl implements CityService {

	@Inject
	private CityDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(CityDto dto) {
		dao.create(DtoFactory.CreateDto(City.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(CityDto dto) {
		dao.update(DtoFactory.CreateDto(City.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(CityDto dto) {
		dao.delete(DtoFactory.CreateDto(City.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public CityDto getById(Long id) {
		return DtoFactory.CreateDto(CityDto.class, dao.getById(id));
	}
}
