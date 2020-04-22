package com.vb.action;

import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vb.beans.UserT;
import com.vb.service.UserTService;

public class RegisterAction extends BasicAction implements ModelDriven<UserT>,ServletResponseAware{
	private UserT user;
	private HttpServletResponse response;

	private UserTService uService = new UserTService();
	public UserTService getuService() {
		return uService;
	}

	public void setuService(UserTService uService) {
		this.uService = uService;
	}

	public UserT getModel() {
		if (user == null) {
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

	@Override
	public String execute() throws Exception {
		if (!check())
			return null;
		try {
			user.setAuthorityId("0");
			uService.save(user);
			return SUCCESS;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public boolean check() {
		try {
			boolean result = false;
			response.setContentType("text/xml;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<message>");

			String old = request.getParameter("name");
			if (old != null) {
				UserT userd= uService.findById(user.getUsername());
				if (userd==null) {
					out.println("<usernamemes>"
							+ "用户名已存在"
							+ "</usernamemes>");
					result = true;
				} else {
					out.println("<usernamemes>"
							+ "username not exist,you can use it"
							+ "</usernamemes>");
					result = false;
				}
			} else {
				out.println("<usernamemes>" + "username is required"
						+ "</usernamemes>");
				result = false;
			}

			out.println("</message>");
			out.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

}
