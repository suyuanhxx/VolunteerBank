package com.vb.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.vb.beans.PrizeT;
import com.vb.beans.PrizeUserT;
import com.vb.beans.PrizeUserTId;
import com.vb.beans.UserT;
import com.vb.service.PrizeTService;
import com.vb.service.RedeemService;
import com.vb.service.UserTService;

public class RedeemAction extends BasicAction {
	private RedeemService redeemService = new RedeemService();
	private UserTService uService = new UserTService();
	private PrizeTService pService = new PrizeTService();
	
	public String redeem(){
		String prizeID = request.getParameter("prize_id");
		BigDecimal prizescore = new BigDecimal( request.getParameter("prize_score") );
		UserT user =  (UserT)session.get("user") ;
		PrizeUserT PU = new PrizeUserT( new PrizeUserTId(prizeID,user.getUsername() ) );
		try{
			BigDecimal scoreAvailable = user.getScoreAvailable();
			if(scoreAvailable==null){
				session.put("reddem", "false");
				return null;
			}
			int flag = ( scoreAvailable.subtract(prizescore) ).compareTo(new BigDecimal(0));
			if(flag==1 || flag==0){
				user.setScoreAvailable( scoreAvailable.subtract(prizescore) );
				uService.update(user);
				redeemService.save(PU);
				UserT usern = uService.findById(user.getUsername());
				session.put("profile", usern);
				session.put("redeem", "true");
				myprizelist();
				return "success";
			}
			if(flag==-1){
				session.put("reddem", "false");
				return null;
			}
			else
				return ERROR;
		}catch(RuntimeException re){
			re.printStackTrace();
			return ERROR;
		}
	}
	
	public String myprizelist(){
		try{
			UserT user = (UserT)session.get("user");
			List list = redeemService.findByUsername(user.getUsername());
			List l1 = new ArrayList();
			for(int i=0;i<list.size();i++){
				PrizeUserT pu = (PrizeUserT)list.get(i);
				PrizeT prize = pService.findById( pu.getId().getPrizeId() );
				l1.add(prize);
			}
			session.put("myprizelist", l1);
			return null;
		}catch(RuntimeException re){
			re.printStackTrace();
			return ERROR;
		}
	}
	
}
