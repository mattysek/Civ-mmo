package com.redhat.civ.dao.implementation;

import com.redhat.civ.dao.interfaces.BuildingDao;
import com.redhat.civ.entities.Building;

public class BuildingDaoImpl extends BaseDaoImpl<Building> implements BuildingDao {

	@Override
	protected boolean isValid(Building object) {
		// TODO Auto-generated method stub
		return true;
	}

}
