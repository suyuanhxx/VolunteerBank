package com.vb.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;
import com.vb.beans.UserT;

public class MenuFilter implements Filter{

	private static HashSet superMenuSet=null;
	
	private static HashSet commonMenuSet=null;
	
	private static HashSet userMenuSet=null;
	
	private static HashSet protectedSet=null;
	
	static{
		superMenuSet = new HashSet();
		superMenuSet.add("/VolunteerBank/superAdmin/taskManage.jsp");
		superMenuSet.add("/VolunteerBank/superAdmin/profileManage.jsp");
		superMenuSet.add("/VolunteerBank/superAdmin/prizeManage.jsp");
		superMenuSet.add("/VolunteerBank/superAdmin/prizeResult.jsp");

		commonMenuSet = new HashSet();
		commonMenuSet.add("/VolunteerBank/commonAdmin/taskManage.jsp");
		commonMenuSet.add("/VolunteerBank/commonAdmin/profileManage.jsp");

		userMenuSet = new HashSet();
		userMenuSet.add("/VolunteerBank/volunteer/taskManage-noright.jsp");
		userMenuSet.add("/VolunteerBank/volunteer/profileManage.jsp");
		
		protectedSet = new HashSet();
		protectedSet.add("/VolunteerBank/protected/applytask.jsp");
		protectedSet.add("/VolunteerBank/protected/modifypwd.jsp");
		protectedSet.add("/VolunteerBank/protected/pendingtasklist.jsp");
		protectedSet.add("/VolunteerBank/protected/profile.jsp");
		protectedSet.add("/VolunteerBank/protected/publishtask.jsp");
		protectedSet.add("/VolunteerBank/protected/redeem.jsp");
		protectedSet.add("/VolunteerBank/protected/taskdetail.jsp");
		protectedSet.add("/VolunteerBank/protected/prizelist.jsp");
		protectedSet.add("/VolunteerBank/protected/publishercomment.jsp");
		protectedSet.add("/VolunteerBank/protected/findtask.jsp");
		protectedSet.add("/VolunteerBank/protected/findtask2.jsp");
	}
	
	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		String uri=req.getRequestURI();
		
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		UserT user = (UserT)session.get("user");
		
		String authority=null;
		boolean right=true;
		
		if(user == null){
			right=false;
		}else{
			authority=user.getAuthorityId();
			if("1".equals(authority)){
				if(!superMenuSet.contains(uri)){
					right= false;
				}
			}else if("2".equals(authority)){
				if(!commonMenuSet.contains(uri)){
					right=false;
				}
			}else if("3".equals(authority)){
				if(!userMenuSet.contains(uri)){
					right=false;
				}
			}
			if(protectedSet.contains(uri)){
				right = true;
			}
		}
		
		if(right){
			chain.doFilter(request, response);
		}else{
			req.getRequestDispatcher("/noright.jsp").forward(request, response);
		}
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
}
