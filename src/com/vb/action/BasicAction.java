package com.vb.action;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.vb.beans.Pagination;
import com.vb.beans.UserT;

public class BasicAction extends ActionSupport implements SessionAware,ServletRequestAware{
	
	protected Map<String, Object> session;
	protected HttpServletRequest request;
	
	public void setSession(Map<String, Object> arg0){
		this.session = arg0;
	}
	
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	
	public String generateRandomId() {
		String base = "0123456789";
	    Random random = new Random();
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < 10; i++) {
	        int number = random.nextInt(base.length());
	        sb.append(base.charAt(number));
	    }
	    return sb.toString();
	}
	
	public boolean isThisAuthority(String authority) {
		UserT user = (UserT)session.get("user");
		if(user.getAuthorityId().equals(authority))
			return true;
		else
			return false;
	}
	
	/** 分页类 */  
    protected Pagination pagination;  
  
    public Pagination getPagination() {  
        return pagination;  
    }  
  
    public void setPagination(Pagination pagination) {  
        this.pagination = pagination;  
    }  
      
    public String preAdd(){  

        return INPUT;  
    }

}
