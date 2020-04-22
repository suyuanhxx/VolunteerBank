package com.vb.service;

import com.vb.beans.AuthorityT;
import com.vb.beans.AuthorityTId;
import com.vb.dao.AuthorityTDAO;

public class AuthorityTService extends BasicService{
	
	private AuthorityTDAO authorityDao = (AuthorityTDAO)factory.getBean("AuthorityTDAO");
	
	public void save(AuthorityT authority) throws RuntimeException{
		authorityDao.save(authority);
	}
	
	public void delete(AuthorityT authority) throws RuntimeException{
		authorityDao.delete(authority);
	}
	
	public AuthorityT findById(AuthorityTId id)  throws RuntimeException{
		return authorityDao.findById(id);
	}

}
