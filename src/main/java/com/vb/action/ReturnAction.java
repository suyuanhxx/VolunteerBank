package com.vb.action;

public class ReturnAction extends BasicAction {
	
	public String execute() {
		try {
			if(isThisAuthority("1"))
				return "superadmin";
			else if(isThisAuthority("2"))
				return "commonadmin";
			else if(isThisAuthority("3"))
				return "volunteer";
			else
				return ERROR;
		} catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}
