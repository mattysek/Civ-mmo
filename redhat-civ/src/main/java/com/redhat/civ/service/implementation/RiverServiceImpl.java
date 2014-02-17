package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.RiverDao;
import com.redhat.civ.dto.RiverDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.River;
import com.redhat.civ.service.interfaces.RiverService;

@Stateless
public class RiverServiceImpl implements RiverService {

	@Inject
	private RiverDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(RiverDto dto) {
		dao.create(DtoFactory.CreateDto(River.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(RiverDto dto) {
		dao.update(DtoFactory.CreateDto(River.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(RiverDto dto) {
		dao.delete(DtoFactory.CreateDto(River.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public RiverDto getById(Long id) {
		return DtoFactory.CreateDto(RiverDto.class, dao.getById(id));
	}

}
