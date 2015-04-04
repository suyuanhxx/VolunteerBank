package com.vb.beans;

/**
 * PrizeUserTId entity. @author MyEclipse Persistence Tools
 */

public class PrizeUserTId implements java.io.Serializable {

	// Fields

	private String prizeId;
	private String username;

	// Constructors

	/** default constructor */
	public PrizeUserTId() {
	}

	/** full constructor */
	public PrizeUserTId(String prizeId, String username) {
		this.prizeId = prizeId;
		this.username = username;
	}

	// Property accessors

	public String getPrizeId() {
		return this.prizeId;
	}

	public void setPrizeId(String prizeId) {
		this.prizeId = prizeId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PrizeUserTId))
			return false;
		PrizeUserTId castOther = (PrizeUserTId) other;

		return ((this.getPrizeId() == castOther.getPrizeId()) || (this
				.getPrizeId() != null && castOther.getPrizeId() != null && this
				.getPrizeId().equals(castOther.getPrizeId())))
				&& ((this.getUsername() == castOther.getUsername()) || (this
						.getUsername() != null
						&& castOther.getUsername() != null && this
						.getUsername().equals(castOther.getUsername())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPrizeId() == null ? 0 : this.getPrizeId().hashCode());
		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		return result;
	}

}