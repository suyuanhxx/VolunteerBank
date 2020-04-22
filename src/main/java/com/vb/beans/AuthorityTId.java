package com.vb.beans;

/**
 * AuthorityTId entity. @author MyEclipse Persistence Tools
 */

public class AuthorityTId implements java.io.Serializable {

	// Fields

	private String authorityId;
	private String usergroup;

	// Constructors

	/** default constructor */
	public AuthorityTId() {
	}

	/** full constructor */
	public AuthorityTId(String authorityId, String usergroup) {
		this.authorityId = authorityId;
		this.usergroup = usergroup;
	}

	// Property accessors

	public String getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public String getUsergroup() {
		return this.usergroup;
	}

	public void setUsergroup(String usergroup) {
		this.usergroup = usergroup;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AuthorityTId))
			return false;
		AuthorityTId castOther = (AuthorityTId) other;

		return ((this.getAuthorityId() == castOther.getAuthorityId()) || (this
				.getAuthorityId() != null && castOther.getAuthorityId() != null && this
				.getAuthorityId().equals(castOther.getAuthorityId())))
				&& ((this.getUsergroup() == castOther.getUsergroup()) || (this
						.getUsergroup() != null
						&& castOther.getUsergroup() != null && this
						.getUsergroup().equals(castOther.getUsergroup())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getAuthorityId() == null ? 0 : this.getAuthorityId()
						.hashCode());
		result = 37 * result
				+ (getUsergroup() == null ? 0 : this.getUsergroup().hashCode());
		return result;
	}

}