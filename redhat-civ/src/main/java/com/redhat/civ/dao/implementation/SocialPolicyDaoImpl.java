package com.redhat.civ.dao.implementation;

import com.redhat.civ.dao.interfaces.SocialPolicyDao;
import com.redhat.civ.entities.SocialPolicy;

public class SocialPolicyDaoImpl extends BaseDaoImpl<SocialPolicy> implements
		SocialPolicyDao {

	@Override
	protected boolean isValid(SocialPolicy object) {
		// TODO Auto-generated method stub
		return true;
	}

}
