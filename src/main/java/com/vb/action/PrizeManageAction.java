package com.vb.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.Hibernate;

import com.opensymphony.xwork2.ModelDriven;
import com.vb.beans.Pagination;
import com.vb.beans.PrizeT;
import com.vb.beans.UserT;
import com.vb.service.PrizeTService;

public class PrizeManageAction extends BasicAction implements ModelDriven<PrizeT>{
	
	private PrizeTService pService = new PrizeTService();
	
	public PrizeTService getpService() {
		return this.pService;
	}
	
	public void setpService(PrizeTService pService) {
		this.pService = pService;
	}
	
	private PrizeT prize;
	
	public PrizeT getModel() {
		if(prize == null){
			prize = new PrizeT();
	    }
	    return prize;
	}

	public PrizeT getPrize() {
		return prize;
	}

	public void setPrize(PrizeT prize) {
		this.prize = prize;
	}
	
	private File imagefile;
	private InputStream imageStream;
	
	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}

	public File getImagefile() {
		return imagefile;
	}

	public void setImagefile(File imagefile) {
		this.imagefile = imagefile;
	}
	
	public String show() throws Exception {
		try {
			query();
			if(isThisAuthority("1"))
				return "manage";
			else
				return "list";
		} catch(RuntimeException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * It's dead.
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		try {
			if(isThisAuthority("1")) {
				String anId;
				while(true) {
					anId = generateRandomId();
					PrizeT prizetemp = pService.findById(anId);
					if (prizetemp == null)
						break;
				}
				prize.setPrizeId(anId);
				pService.save(prize);
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String delete() throws Exception {
		try {
			if(isThisAuthority("1")) {
				String id = request.getParameter("prizeId");
				pService.deleteById(id);
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String update() throws Exception {
		try {
			if(isThisAuthority("1")) {
				if(prize.getPrizeId().equals("")) {
					String anId;
					while(true) {
						anId = generateRandomId();
						PrizeT prizetemp = pService.findById(anId);
						if (prizetemp == null)
							break;
					}
					prize.setPrizeId(anId);
				}
				this.setImage();
				pService.attachDirty(prize);
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String selectfuzzy() throws Exception {
		try {
			String keyword = request.getParameter("keyword");
			if(keyword==null){
				return "";
			}
			else{
				List list = pService.searchPrizeName(keyword);
				if(isThisAuthority("1")) {
					session.put("prizeSelectedList", list);
					return SUCCESS;
				} else {
					return ERROR;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public void setImage() {
		try {
			if (imagefile != null) {
				FileInputStream fin = new FileInputStream(imagefile);// File 转 InputStream
		        Blob blob = Hibernate.createBlob(fin);// InputStream 转 Blob
				StringBuffer sb = new StringBuffer();
				InputStream in = blob.getBinaryStream();
				byte[] buff = new byte[(int) blob.length()];
				for(int i = 0; (i = in.read(buff)) > 0;){    
					sb = sb.append(new String(buff));    
	            }
		        prize.setPrizeImg(sb.toString());
			}
		} catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public String getImage() throws Exception {
		try {
			String id = request.getParameter("prizeId");
			String img_str = pService.findById(id).getPrizeImg();
			if(img_str != null) {
				Blob blob = Hibernate.createBlob(img_str.getBytes()); // mysql
				imageStream = blob.getBinaryStream();
		        return SUCCESS;
			}       
			return ERROR;
		} catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}
    }
	
	public void query() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Entering query method...");
        }
        if (this.pagination == null) {
            this.pagination = new Pagination(10);
        }
        if (this.prize == null) {
            this.prize = new PrizeT();
        }
        try{
            this.pagination = pService.getPrizes(prize, pagination);
            session.put("pagination", pagination);
        }catch (Exception e) {
            addActionError(getText("search.exception", new String []{getText("PrizeT")}));
        }
    }

}
