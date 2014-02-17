package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.ActionDao;
import com.redhat.civ.dto.ActionDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.Action;
import com.redhat.civ.service.interfaces.ActionService;

@Stateless
public class ActionServiceImpl implements ActionService {

	@Inject
	private ActionDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(ActionDto dto) {
		dao.create(DtoFactory.CreateDto(Action.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(ActionDto dto) {
		dao.update(DtoFactory.CreateDto(Action.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(ActionDto dto) {
		dao.delete(DtoFactory.CreateDto(Action.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ActionDto getById(Long id) {
		return DtoFactory.CreateDto(ActionDto.class, dao.getById(id));
	}

}
