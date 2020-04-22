package com.vb.beans;


/**
 * PrizeUserT entity. @author MyEclipse Persistence Tools
 */

public class PrizeUserT implements java.io.Serializable {

	// Fields

	private PrizeUserTId id;

	// Constructors

	/** default constructor */
	public PrizeUserT() {
	}

	/** full constructor */
	public PrizeUserT(PrizeUserTId id) {
		this.id = id;
	}

	// Property accessors

	public PrizeUserTId getId() {
		return this.id;
	}

	public void setId(PrizeUserTId id) {
		this.id = id;
	}

}