package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.ResourceDao;
import com.redhat.civ.dto.ResourceDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.Resource;
import com.redhat.civ.service.interfaces.ResourceService;

@Stateless
public class ResourceServiceImpl implements ResourceService{

	@Inject
	private ResourceDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(ResourceDto dto) {
		dao.create(DtoFactory.CreateDto(Resource.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(ResourceDto dto) {
		dao.update(DtoFactory.CreateDto(Resource.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(ResourceDto dto) {
		dao.delete(DtoFactory.CreateDto(Resource.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ResourceDto getById(Long id) {
		return DtoFactory.CreateDto(ResourceDto.class, dao.getById(id));
	}
}
