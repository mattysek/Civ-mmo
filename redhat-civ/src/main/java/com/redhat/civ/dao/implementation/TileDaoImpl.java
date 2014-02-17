package com.redhat.civ.dao.implementation;

import com.redhat.civ.dao.interfaces.TileDao;
import com.redhat.civ.entities.Tile;

public class TileDaoImpl extends BaseDaoImpl<Tile> implements TileDao {

	@Override
	protected boolean isValid(Tile object) {
		// TODO Auto-generated method stub
		return true;
	}

}
