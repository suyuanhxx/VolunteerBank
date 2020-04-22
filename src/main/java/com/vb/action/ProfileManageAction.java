package com.vb.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vb.beans.AccepterTaskT;
import com.vb.beans.PublisherTaskT;
import com.vb.beans.TaskT;
import com.vb.beans.UserT;
import com.vb.service.TaskManageService;
import com.vb.service.TaskTService;
import com.vb.service.UserTService;

public class ProfileManageAction extends BasicAction {
	private UserT profile;

	private UserTService uService= new UserTService();

	public UserTService getuService() {
		return uService;
	}

	public void setuService(UserTService uService) {
		this.uService = uService;
	}
	
	public String show() throws RuntimeException{
		String username = request.getParameter("username");
		try{
			profile = uService.findById(username);
			if(profile!=null){
				session.put("profile", profile);
				return "profile";
			}
			else
				return ERROR;
		}catch(RuntimeException e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String update() throws RuntimeException{
		String truename= request.getParameter("truename");
		String sex = request.getParameter("sex");
		String age1 = request.getParameter("age");
		BigDecimal age = new BigDecimal( Integer.parseInt(age1) );
		String major = request.getParameter("major");
		String sno = request.getParameter("sno");
//		String himage = request.getParameter("himage");
		profile = (UserT) session.get("user");
		profile.setTruename(truename);
		profile.setSex(sex);
		profile.setAge(age);
		profile.setMajor(major);
		profile.setSno(sno);
//		profile.setHimage(himage);
		try{
			uService.update(profile);
			if(profile.getAuthorityId().equals("1")){
				 return "superadmin";
			 }
			 if(profile.getAuthorityId().equals("2")){
				 return "commonadmin";
			 }
			 if(profile.getAuthorityId().equals("3")){
				 return "volunteer";
			 }
			 return "noright";
		}catch(RuntimeException e){
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String modifypwd(){
		String npwd = request.getParameter("npwd");
		profile = (UserT) session.get("profile");
		try{
			profile.setPwd(npwd);
			uService.update(profile);
			return "success";
		}catch(RuntimeException r){
			r.printStackTrace();
			return ERROR;
		}
	}
	
}
