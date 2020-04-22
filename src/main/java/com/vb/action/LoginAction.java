package com.vb.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vb.beans.UserT;
import com.vb.service.AuthorityTService;
import com.vb.service.UserTService;

public class LoginAction extends BasicAction implements ModelDriven<UserT>{
	private UserT user;

	private UserTService uService = new UserTService();

	public UserTService getuService() {
		return uService;
	}

	public void setuService(UserTService uService) {
		this.uService = uService;
	}


	public UserT getModel() {
		if(user == null){
	           user = new UserT();
	       }
	       return user;
	}
	
	 public UserT getUser() {
	       return user;
	 }
	 
	 public void setUser(UserT user) {
	       this.user = user;
	 }
	 
	 public String login(){
		 try{
			 UserT userd= uService.findById(user.getUsername());
			 if(userd!=null && userd.getPwd().equals(user.getPwd())){
				 if(userd.getAuthorityId().equals("0"))
					 return "noright";
				 else
				 {
					 session.put("user", userd);
					 session.put("profile", userd);
					 setUser(userd);
					 if(userd.getAuthorityId().equals("1")){
						 return "superadmin";
					 }
					 if(userd.getAuthorityId().equals("2")){
						 return "commonadmin";
					 }
					 if(userd.getAuthorityId().equals("3")){
						 return "volunteer";
					 }
					 return "noright";
				 }
			 }
			 else
			 {
				 return "error";
			 }
		 }catch(RuntimeException r){
			 r.printStackTrace();
			 return "error";
		 }
	 }
	 
	 public String loginout() throws Exception{
		 try{
			 session.remove("user");
			 return "success";
		 }catch(RuntimeException e){
			 e.printStackTrace();
			 return ERROR;
		 }
		 
	 }
}
