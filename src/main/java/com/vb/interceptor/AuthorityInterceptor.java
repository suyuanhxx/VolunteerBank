package com.vb.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.vb.beans.UserT;

public class AuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String name = invocation.getInvocationContext().getName();
		if(name.equals("login")){
			return invocation.invoke();
		}
		else{
			ActionContext ctx = invocation.getInvocationContext();
			UserT user = (UserT)ctx.getSession().get("user");
			if( user == null){
				return "login";
			}
			else{
//				if( user.getAuthorityId() == "1" ){
//					return invocation.invoke();
//				}
//				else{
//					return "error";
//				}
				return invocation.invoke();
			}
		}
	}
	
	
}
