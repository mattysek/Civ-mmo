package com.redhat.civ.dao.implementation;

import com.redhat.civ.dao.interfaces.ResourceDao;
import com.redhat.civ.entities.Resource;

public class ResourceDaoImpl extends BaseDaoImpl<Resource> implements
		ResourceDao {

	@Override
	protected boolean isValid(Resource object) {
		// TODO Auto-generated method stub
		return true;
	}

}
