package com.redhat.civ.dao.implementation;

import com.redhat.civ.dao.interfaces.PolicyDao;
import com.redhat.civ.entities.Policy;

public class PolicyDaoImpl extends BaseDaoImpl<Policy> implements PolicyDao {

	@Override
	protected boolean isValid(Policy object) {
		// TODO Auto-generated method stub
		return true;
	}

}
