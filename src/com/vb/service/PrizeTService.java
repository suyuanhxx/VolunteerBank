package com.vb.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.xwork.StringUtils;

import com.vb.beans.Pagination;
import com.vb.beans.PrizeT;
import com.vb.dao.PrizeTDAO;

public class PrizeTService extends BasicService {
	
	private PrizeTDAO prizedao=(PrizeTDAO) factory.getBean("PrizeTDAO");

	public PrizeTDAO getPrizedao() {
		return prizedao;
	}

	public void setPrizedao(PrizeTDAO prizedao) {
		this.prizedao = prizedao;
	}
	
	public void save(PrizeT prize) throws RuntimeException {
		prizedao.save(prize);
	}
	
	public void delete(PrizeT prize) throws RuntimeException {
		prizedao.delete(prize);
	}
	
	public void deleteById(String id) throws RuntimeException {
		PrizeT prize = new PrizeT(id);
		prizedao.delete(prize);
	}
	
	public PrizeT findById(String id) throws RuntimeException{
		return prizedao.findById(id);
	}
	
	public List findByProperty(String propertyName , String value)
			throws RuntimeException{
		return prizedao.findByProperty(propertyName, value);
	}
	
	public List findAll() throws RuntimeException{
		return prizedao.findAll();
	}
	
	public void attachDirty(PrizeT prize) throws RuntimeException {
		prizedao.attachDirty(prize);
	}
	
	public List searchPrizeName(Object prizename) {
		return prizedao.searchPrizeName(prizename);
	}
	
	/**
	 * get prizes by Pagination
	 * @param prizes
	 * @param pagination
	 */
	public Pagination getPrizes(PrizeT prize, Pagination pagination) {
		return prizedao.getPrizes(prize, pagination);
	}

}
