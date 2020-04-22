package com.vb.beans;

import java.math.BigDecimal;


/**
 * AccepterTaskT entity. @author MyEclipse Persistence Tools
 */

public class AccepterTaskT implements java.io.Serializable {

	// Fields

	private AccepterTaskTId id;
	private BigDecimal progress;

	// Constructors

	/** default constructor */
	public AccepterTaskT() {
	}

	/** minimal constructor */
	public AccepterTaskT(AccepterTaskTId id) {
		this.id = id;
	}

	/** full constructor */
	public AccepterTaskT(AccepterTaskTId id, BigDecimal progress) {
		this.id = id;
		this.progress = progress;
	}

	// Property accessors

	public AccepterTaskTId getId() {
		return this.id;
	}

	public void setId(AccepterTaskTId id) {
		this.id = id;
	}

	public BigDecimal getProgress() {
		return this.progress;
	}

	public void setProgress(BigDecimal progress) {
		this.progress = progress;
	}

}