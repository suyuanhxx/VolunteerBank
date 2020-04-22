package com.vb.service;

import java.util.List;

import com.vb.beans.Pagination;
import com.vb.beans.TaskT;
import com.vb.dao.TaskTDAO;

public class TaskTService extends BasicService{
	private TaskTDAO taskdao=(TaskTDAO) factory.getBean("TaskTDAO");
	
	public void save(TaskT task) throws RuntimeException{
		taskdao.save(task);
	}
	
	public void delete(TaskT task) throws RuntimeException{
		taskdao.delete(task);
	}
	
	public TaskT findById(String id) throws RuntimeException{
		return taskdao.findById(id);
	}
	
	public List findByProperty(String propertyName , String value) throws RuntimeException{
		return taskdao.findByProperty(propertyName, value);
	}
	
	public List findAll() throws RuntimeException{
		return taskdao.findAll();
	}
	public void update(TaskT task) throws RuntimeException {
		taskdao.attachDirty(task);
	}
	public List searchtask(String value) throws RuntimeException{
		return taskdao.searchTask(value);
	}
	
	public List findNotStartTask(){
		return taskdao.findNotStartTask();
	}
	
	public Pagination fuzzyQuery(TaskT task,Pagination pagination , String keyword){
		return taskdao.fuzzyQuery(task, pagination,keyword);
	}

}
