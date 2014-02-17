package com.redhat.civ.dao.implementation;

import com.redhat.civ.dao.interfaces.TechnologyDao;
import com.redhat.civ.entities.Technology;

public class TechnologyDaoImpl extends BaseDaoImpl<Technology> implements
		TechnologyDao {

	@Override
	protected boolean isValid(Technology object) {
		// TODO Auto-generated method stub
		return true;
	}

}
