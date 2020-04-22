package com.vb.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.vb.beans.UserT;

public class CheckAuthority extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		UserT user = (UserT)ctx.getSession().get("user");
		if(user.getAuthorityId().equals("1")){
			return invocation.invoke();
		}
		else
			return "noright";
	}

}
