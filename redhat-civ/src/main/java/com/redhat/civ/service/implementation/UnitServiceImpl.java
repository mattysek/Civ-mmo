package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.UnitDao;
import com.redhat.civ.dto.UnitDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.Unit;
import com.redhat.civ.service.interfaces.UnitService;

@Stateless
public class UnitServiceImpl implements UnitService {

	@Inject
	private UnitDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(UnitDto dto) {
		dao.create(DtoFactory.CreateDto(Unit.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(UnitDto dto) {
		dao.update(DtoFactory.CreateDto(Unit.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(UnitDto dto) {
		dao.delete(DtoFactory.CreateDto(Unit.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public UnitDto getById(Long id) {
		return DtoFactory.CreateDto(UnitDto.class, dao.getById(id));
	}

}
