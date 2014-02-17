package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.BuildingDao;
import com.redhat.civ.dto.BuildingDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.Building;
import com.redhat.civ.service.interfaces.BuildingService;

@Stateless
public class BuildingServiceImpl implements BuildingService {

	@Inject
	private BuildingDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(BuildingDto dto) {
		dao.create(DtoFactory.CreateDto(Building.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(BuildingDto dto) {
		dao.update(DtoFactory.CreateDto(Building.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(BuildingDto dto) {
		dao.delete(DtoFactory.CreateDto(Building.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public BuildingDto getById(Long id) {
		return DtoFactory.CreateDto(BuildingDto.class, dao.getById(id));
	}
}
