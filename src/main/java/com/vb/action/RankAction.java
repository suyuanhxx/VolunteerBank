package com.vb.action;

import com.vb.beans.Page;
import com.vb.beans.Pagination;
import com.vb.beans.UserT;
import com.vb.service.UserTService;

public class RankAction extends BasicAction{
	private UserT user;
	private UserTService uService = new UserTService();
	private Page page;
	public String scoreRank(){
		if (LOG.isDebugEnabled()) {
            LOG.debug("Entering query method...");
        }
        if (this.pagination == null) {
            this.pagination = new Pagination(10);
        }
        if (this.user == null) {
            this.user = new UserT();
        }
        try{
            this.pagination = uService.findScoreRank(user, pagination);
            session.put("SRpagination", pagination);
            return "success";
        }catch (Exception e) {
            addActionError(getText("search.exception", new String []{getText("UserT")}));
            return ERROR;
        }
	}

}
