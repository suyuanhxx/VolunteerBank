package com.vb.beans;


/**
 * AuthorityT entity. @author MyEclipse Persistence Tools
 */

public class AuthorityT implements java.io.Serializable {

	// Fields

	private AuthorityTId id;

	// Constructors

	/** default constructor */
	public AuthorityT() {
	}

	/** full constructor */
	public AuthorityT(AuthorityTId id) {
		this.id = id;
	}

	// Property accessors

	public AuthorityTId getId() {
		return this.id;
	}

	public void setId(AuthorityTId id) {
		this.id = id;
	}

}