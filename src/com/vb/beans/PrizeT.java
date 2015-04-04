package com.vb.beans;

import java.math.BigDecimal;

/**
 * PrizeT entity. @author MyEclipse Persistence Tools
 */

public class PrizeT implements java.io.Serializable {

	// Fields

	private String prizeId;
	private String prizeName;
	private String prizeImg;
	private BigDecimal prizeScore;

	// Constructors

	/** default constructor */
	public PrizeT() {
	}

	/** minimal constructor */
	public PrizeT(String prizeId) {
		this.prizeId = prizeId;
	}

	/** full constructor */
	public PrizeT(String prizeId, String prizeName, String prizeImg,
			BigDecimal prizeScore) {
		this.prizeId = prizeId;
		this.prizeName = prizeName;
		this.prizeImg = prizeImg;
		this.prizeScore = prizeScore;
	}

	// Property accessors

	public String getPrizeId() {
		return this.prizeId;
	}

	public void setPrizeId(String prizeId) {
		this.prizeId = prizeId;
	}

	public String getPrizeName() {
		return this.prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public String getPrizeImg() {
		return this.prizeImg;
	}

	public void setPrizeImg(String prizeImg) {
		this.prizeImg = prizeImg;
	}

	public BigDecimal getPrizeScore() {
		return this.prizeScore;
	}

	public void setPrizeScore(BigDecimal prizeScore) {
		this.prizeScore = prizeScore;
	}

}