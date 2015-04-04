package com.vb.service;

import java.util.List;

import com.vb.beans.AccepterTaskT;
import com.vb.beans.AccepterTaskTId;
import com.vb.beans.PublisherTaskT;
import com.vb.dao.AccepterTaskTDAO;
import com.vb.dao.PublisherTaskTDAO;


public class TaskManageService extends BasicService {
	private AccepterTaskTDAO ATdao=(AccepterTaskTDAO) factory.getBean("AccepterTaskTDAO");
	private PublisherTaskTDAO PTdao=(PublisherTaskTDAO) factory.getBean("PublisherTaskTDAO");
	
	public List findByAccepterName(String accepterName){
		return ATdao.findByUsername(accepterName);
	}

	public List findByPublisherName(String publisherName){
		return PTdao.findByUsername(publisherName);
	}
	
	public AccepterTaskT findById(AccepterTaskTId id){
		return ATdao.findById(id);
	}
	
	public void savePublisherTask(PublisherTaskT PT){
		PTdao.save(PT);
	}
	
	public void saveAccepterTask(AccepterTaskT AT){
		ATdao.save(AT);
	}
	
	public void updateA(AccepterTaskT AT){
		ATdao.attachDirty(AT);
	}
	
	public void deleteA(AccepterTaskT AT){
		ATdao.delete(AT);
	}
	
	public List findPendingTask(){
		return ATdao.findPendingTask();
	}

}
