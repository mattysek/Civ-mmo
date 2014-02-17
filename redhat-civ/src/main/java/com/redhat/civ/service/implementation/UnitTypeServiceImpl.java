package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.UnitTypeDao;
import com.redhat.civ.dto.UnitTypeDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.UnitType;
import com.redhat.civ.service.interfaces.UnitTypeService;

@Stateless
public class UnitTypeServiceImpl implements UnitTypeService {

	@Inject
	private UnitTypeDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(UnitTypeDto dto) {
		dao.create(DtoFactory.CreateDto(UnitType.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(UnitTypeDto dto) {
		dao.update(DtoFactory.CreateDto(UnitType.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(UnitTypeDto dto) {
		dao.delete(DtoFactory.CreateDto(UnitType.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public UnitTypeDto getById(Long id) {
		return DtoFactory.CreateDto(UnitTypeDto.class, dao.getById(id));
	}

}
