package com.vb.service;

import java.util.List;

import com.vb.beans.Pagination;
import com.vb.beans.UserT;
import com.vb.dao.UserTDAO;

public class UserTService extends BasicService {
//	@Autowired
//	ApplicationContext ctx=new  ClassPathXmlApplicationContext("../applicationContext.xml");
//	UserTDAO userdao=(UserTDAO) ctx.getBean("UserTDAO");

	private UserTDAO userdao=(UserTDAO) factory.getBean("UserTDAO");

	public UserTDAO getUserdao() {
		return userdao;
	}
	public void setUserdao(UserTDAO userdao) {
		this.userdao = userdao;
	}
	public void save(UserT user) throws RuntimeException{
		userdao.save(user);
	}
	public void delete(UserT user) throws RuntimeException{
		userdao.delete(user);
	}
	
	public UserT findById(String id) throws RuntimeException{
		return userdao.findById(id);
	}
	
	public List findByProperty(String propertyName , String value)
			throws RuntimeException{
		return userdao.findByProperty(propertyName, value);
	}
	
	public List findAll() throws RuntimeException{
		return userdao.findAll();
	}
	
	public void update(UserT user){
		userdao.attachDirty(user);
	}
	
	public Pagination findScoreRank(UserT user , Pagination pagination){
		return userdao.findScoreRank(user, pagination);
	}
	
}
