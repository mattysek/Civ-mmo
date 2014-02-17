package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.TradeRouteDao;
import com.redhat.civ.dto.TradeRouteDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.TradeRoute;
import com.redhat.civ.service.interfaces.TradeRouteService;

@Stateless
public class TradeRouteServiceImpl implements TradeRouteService {

	@Inject
	private TradeRouteDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(TradeRouteDto dto) {
		dao.create(DtoFactory.CreateDto(TradeRoute.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(TradeRouteDto dto) {
		dao.update(DtoFactory.CreateDto(TradeRoute.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(TradeRouteDto dto) {
		dao.delete(DtoFactory.CreateDto(TradeRoute.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public TradeRouteDto getById(Long id) {
		return DtoFactory.CreateDto(TradeRouteDto.class, dao.getById(id));
	}
}
