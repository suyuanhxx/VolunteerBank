package com.vb.beans;


/**
 * PublisherTaskT entity. @author MyEclipse Persistence Tools
 */

public class PublisherTaskT implements java.io.Serializable {

	// Fields

	private PublisherTaskTId id;

	// Constructors

	/** default constructor */
	public PublisherTaskT() {
	}

	/** full constructor */
	public PublisherTaskT(PublisherTaskTId id) {
		this.id = id;
	}

	// Property accessors

	public PublisherTaskTId getId() {
		return this.id;
	}

	public void setId(PublisherTaskTId id) {
		this.id = id;
	}

}