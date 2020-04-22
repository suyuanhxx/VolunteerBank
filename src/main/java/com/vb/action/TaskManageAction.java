package com.vb.action;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ModelDriven;
import com.vb.beans.AccepterTaskT;
import com.vb.beans.AccepterTaskTId;
import com.vb.beans.Pagination;
import com.vb.beans.PublisherTaskT;
import com.vb.beans.PublisherTaskTId;
import com.vb.beans.TaskT;
import com.vb.beans.UserT;
import com.vb.service.TaskManageService;
import com.vb.service.TaskTService;
import com.vb.service.UserTService;

public class TaskManageAction extends BasicAction implements ModelDriven<TaskT>{
	private TaskT task;
	private UserTService uService = new UserTService();
	private TaskTService taskService= new TaskTService();
	private TaskManageService TMService= new TaskManageService();
	private String  value;
	private String  result;
	
	public TaskTService getTaskService() {
		return taskService;
	}
	public void setTaskService(TaskTService taskService) {
		this.taskService = taskService;	
	}
	public TaskT getTask() {
		return task;
	}
	public void setTask(TaskT task) {
		this.task = task;
	}
	public TaskT getModel() {
		if(task==null){
			task= new TaskT();
		}
		return task;
	}
	
	public String add() throws Exception {
		try{
			taskService.save(task);
			return SUCCESS;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	public String delete() throws Exception{
		try{
			taskService.delete(task);
			return SUCCESS;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String  update() throws Exception{
		try{
			taskService.update(task);
			return SUCCESS;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String search() throws Exception{
		try{
			taskService.searchtask(value);
			return SUCCESS;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
//	/**
//	 * 任务分页查询
//	 */
//	public void pagingQuery() {
//        if (LOG.isDebugEnabled()) {
//            LOG.debug("Entering query method...");
//        }
//        if (this.pagination == null) {
//            this.pagination = new Pagination(10);
//        }
//        if (this.task == null) {
//            this.task = new TaskT();
//        }
//        try{
//            this.pagination = taskService.pagingQuery(task, pagination);
//            session.put("pagination", pagination);
//        }catch (Exception e) {
//            addActionError(getText("search.exception", new String []{getText("TaskT")}));
//        }
//    }
	
	/**
	 * 查询我的任务列表
	 * @return
	 */
	public String findmytask(){
		UserT user = (UserT)session.get("user");
		String username = user.getUsername();
		try{
			List l1 = TMService.findByAccepterName(username);//AccepterTaskT对象 接收任务
			List l2 = TMService.findByPublisherName(username);
			if( l1!=null && l2!=null){
				List acceptertask = new ArrayList();
				List publishertask = new ArrayList();
				for(int i=0;i<l1.size();i++){
					String at_id = ( (AccepterTaskT)l1.get(i) ).getId().getTaskId();
					TaskT atask = (TaskT)taskService.findById(at_id);//TaskT 对象
					if(atask!=null){
						acceptertask.add(atask);
					}
				}
				for(int j=0 ; j<l2.size(); j++){
					String pt_id = ( (PublisherTaskT)l2.get(j) ).getId().getTaskId();
					TaskT ptask = (TaskT)taskService.findById(pt_id);//TaskT 对象
					if( ptask!=null){
						publishertask.add(ptask);
					}
				}
				session.put("myacceptertask", acceptertask);
				session.put("myprogress", l1);
				session.put("mypublishertask", publishertask);
				if(user.getAuthorityId().equals("1")){
					return "superadmin";
				}
				else if(user.getAuthorityId().equals("2")){
					return "commonadmin";
				}
				else if(user.getAuthorityId().equals("3")){
					return "volunteer";
				}
				return "noright";
			}
			else
				return ERROR;
		}catch(RuntimeException re){
			re.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 查找我接受的任务详情
	 * @return
	 */
	public String searchById(){
		try{
			String taskId = request.getParameter("id");
			UserT user = (UserT)session.get("user");
			String username = user.getUsername();
			AccepterTaskTId at_taskid = new AccepterTaskTId(username,taskId);
			TaskT task1 = taskService.findById(taskId);
			AccepterTaskT at_task = TMService.findById(at_taskid);
			if(task1!=null && at_task!=null){
				session.put("task", task1);
				session.put("atask", at_task);
				 return "success";
			}
			else
				return ERROR;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	/**
	 * 发布任务
	 * @return
	 */
	public String publishtask(){
		String id;
		while(true){
			id = generateRandomId();
			TaskT task = taskService.findById(id);
			if (task == null)
				break;
		}
//		Timestamp date = new Timestamp(new Date().getTime());
		String username =( (UserT)session.get("user") ).getUsername();
		PublisherTaskTId tid = new PublisherTaskTId(username,id);
		PublisherTaskT PT = new PublisherTaskT(tid);
		task.setTaskId(id);
//		task.setStartTime(date);
		task.setStartFlag(new BigDecimal(-1));//-1表示任务没有人申请，0表示申请但没有开始，1表示任务已开始
		try{
			taskService.save(task);
			TMService.savePublisherTask(PT);
			session.put("flag", "true");
			return "success";
		}catch(RuntimeException re){
			re.printStackTrace();
			session.put("flag", "false");
			return ERROR;
		} 
	}
	
	/**
	 * 没有人申请或申请没有开始的任务
	 * @return
	 */
	public String tasklist(){
		try{
			List notstart = taskService.findNotStartTask();
			if(notstart!=null)
			{
				session.put("notstarttsak", notstart);
				return "success";
			}
			else
				return "notexit";
		}catch(RuntimeException re){
			re.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 待审核的任务
	 */
	public String findPendingTask(){
		try{
			List pendingtask = TMService.findPendingTask();
			if(pendingtask!=null){
				session.put("PendingTask", pendingtask);
				return "success";
			}
			else
				return "notask";
		}catch(RuntimeException re){
			re.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 申请任务
	 * @return
	 */
	public String applytask(){
		String taskId = request.getParameter("taskId");
		try{
			TaskT task = taskService.findById(taskId);
			if(task!=null){
				task.setStartFlag(new BigDecimal(0));
				taskService.update(task);//修改任务标志
				String accepterName = ( (UserT)session.get("user") ).getUsername();
				AccepterTaskTId id = new AccepterTaskTId( accepterName , taskId) ;
				AccepterTaskT AT = TMService.findById(id);
				if(AT!=null){
					session.put("apply",true);
				}
				else{
					AT = new AccepterTaskT(id , new BigDecimal(-1));
					TMService.saveAccepterTask(AT);
					session.put("apply", false);
				}
				return "success";
			}
			else
				return ERROR;
		}catch(RuntimeException re){
			re.printStackTrace();
			session.put("apply", "false");
			return ERROR;
		}
	}
	
	/**
	 * 管理员审核任务，将该任务与接受者对应的进度条设置为0，表示该接受者开始任务。
	 */
	public String agreetoApply(){
		try{
			String taskId = request.getParameter("taskId");
			String accepterName = request.getParameter("name");
			AccepterTaskTId id = new AccepterTaskTId( accepterName , taskId) ;
			AccepterTaskT AT = new AccepterTaskT(id , new BigDecimal(0));
			TaskT task = taskService.findById(taskId);
			Timestamp date = new Timestamp(new Date().getTime());
			task.setStartTime(date);
			task.setStartFlag(new BigDecimal(1));
			taskService.update(task);
			TMService.updateA(AT);
			return "success";
		}catch(RuntimeException re){
			re.printStackTrace();
			return ERROR;
		}
	}
	
	public String disagreetoApply(){
		try{
			String taskId = request.getParameter("taskId");
			String accepterName = request.getParameter("name");
			AccepterTaskTId id = new AccepterTaskTId( accepterName , taskId) ;
			AccepterTaskT AT = new AccepterTaskT();
			UserT user = (UserT)session.get("user"); 
			if(user.getAuthorityId().equals("1")){
				AT.setId(id);
				TMService.deleteA(AT);
				return "success";
			}else
				return "noright";
		}catch(RuntimeException re){
			re.printStackTrace();
			return ERROR;
		}
	}
	
	public String submitjob(){
		try{
			String taskId = request.getParameter("taskid");
			int taskscore = Integer.parseInt(request.getParameter("taskscore"));
			int progress = Integer.parseInt(request.getParameter("progress"));
			UserT user = (UserT)session.get("user");
			String accepterName = user.getUsername();
			AccepterTaskT AT = new AccepterTaskT(new AccepterTaskTId(accepterName,taskId));
			AT.setProgress(new BigDecimal(progress));
			if(progress==100){
				user.setScore( user.getScore().add(new BigDecimal(taskscore)) );
				uService.update(user);
				TaskT task = taskService.findById(taskId);
				Timestamp date = new Timestamp(new Date().getTime());
				task.setEndTime(date);
				taskService.update(task);
			}
			TMService.updateA(AT);
			if(user.getAuthorityId().equals("1")){
				return "superadmin";
			}
			else if(user.getAuthorityId().equals("2")){
				return "commonadmin";
			}
			else if(user.getAuthorityId().equals("3")){
				return "volunteer";
			}
			return "noright";
		}catch(RuntimeException re){
			re.printStackTrace();
			return ERROR;
		}
	}
	
	public String submitcomment(){
		String comment = request.getParameter("comment");
		String taskId = request.getParameter("tid");
		try{
			TaskT task = taskService.findById(taskId);
			task.setTaskComment(comment);
			taskService.update(task);
			return "success";
		}catch(RuntimeException re){
			re.printStackTrace();
			return ERROR;
		}
	}
	
	private Map<String, Object> dataMap = new HashMap();
	public Map<String, Object> getDataMap() {
		  return dataMap;
	}

	public String fuzzyTask(){
		if(dataMap!=null)
		{
			dataMap.clear();
		}
		String keyword = request.getParameter("keyword");
		 if (this.pagination == null) {
	            this.pagination = new Pagination(6);
	     }
		 TaskT task1 = new TaskT();
		 try{
	            this.pagination = taskService.fuzzyQuery(task1, pagination,keyword);
	            session.put("futask", pagination);
//	            dataMap.put("futask", pagination);
	        }catch (Exception e) {
	            addActionError(getText("search.exception", new String []{getText("TaskT")}));
	        }
//		 dataMap.put("futask", pagination);
//		 dataMap.put("success", true);
		 String uri=request.getParameter("uri");
		 if( uri.equals("findtask") ){
			 session.put("f", true);
			 return "change";
		 }
		 if( uri.equals("findtask2")){
			 return "success";
		 }
		 else
			 return ERROR;
	}
}
