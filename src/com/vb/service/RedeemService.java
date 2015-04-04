package com.vb.service;

import java.util.List;

import com.vb.beans.PrizeUserT;
import com.vb.dao.PrizeUserTDAO;

public class RedeemService extends BasicService {
	private PrizeUserTDAO PUdao = (PrizeUserTDAO) factory.getBean("PrizeUserTDAO");
	
	public void save(PrizeUserT PU){
		PUdao.save(PU);
	}
	
	public List findByUsername(String username){
		String  propertyName="USERNAME";
		return PUdao.findByUsername(username);
	}

}
