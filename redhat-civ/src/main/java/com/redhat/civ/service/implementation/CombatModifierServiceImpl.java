package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.CombatModifierDao;
import com.redhat.civ.dto.CombatModifierDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.CombatModifier;
import com.redhat.civ.service.interfaces.CombatModifierService;

@Stateless
public class CombatModifierServiceImpl implements CombatModifierService {

	@Inject
	private CombatModifierDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(CombatModifierDto dto) {
		dao.create(DtoFactory.CreateDto(CombatModifier.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(CombatModifierDto dto) {
		dao.update(DtoFactory.CreateDto(CombatModifier.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(CombatModifierDto dto) {
		dao.delete(DtoFactory.CreateDto(CombatModifier.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public CombatModifierDto getById(Long id) {
		return DtoFactory.CreateDto(CombatModifierDto.class, dao.getById(id));
	}
}
