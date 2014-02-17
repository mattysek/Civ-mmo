package com.redhat.civ.service.implementation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.redhat.civ.dao.interfaces.TileDao;
import com.redhat.civ.dto.TileDto;
import com.redhat.civ.dto.DtoFactory;
import com.redhat.civ.entities.Tile;
import com.redhat.civ.service.interfaces.TileService;

@Stateless
public class TileServiceImpl implements TileService {

	@Inject
	private TileDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void create(TileDto dto) {
		dao.create(DtoFactory.CreateDto(Tile.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(TileDto dto) {
		dao.update(DtoFactory.CreateDto(Tile.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(TileDto dto) {
		dao.delete(DtoFactory.CreateDto(Tile.class, dto));

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public TileDto getById(Long id) {
		return DtoFactory.CreateDto(TileDto.class, dao.getById(id));
	}
}
