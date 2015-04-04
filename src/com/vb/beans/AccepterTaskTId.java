package com.vb.beans;

/**
 * AccepterTaskTId entity. @author MyEclipse Persistence Tools
 */

public class AccepterTaskTId implements java.io.Serializable {

	// Fields

	private String accepterName;
	private String taskId;

	// Constructors

	/** default constructor */
	public AccepterTaskTId() {
	}

	/** full constructor */
	public AccepterTaskTId(String accepterName, String taskId) {
		this.accepterName = accepterName;
		this.taskId = taskId;
	}

	// Property accessors

	public String getAccepterName() {
		return this.accepterName;
	}

	public void setAccepterName(String accepterName) {
		this.accepterName = accepterName;
	}

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AccepterTaskTId))
			return false;
		AccepterTaskTId castOther = (AccepterTaskTId) other;

		return ((this.getAccepterName() == castOther.getAccepterName()) || (this
				.getAccepterName() != null && castOther.getAccepterName() != null && this
				.getAccepterName().equals(castOther.getAccepterName())))
				&& ((this.getTaskId() == castOther.getTaskId()) || (this
						.getTaskId() != null && castOther.getTaskId() != null && this
						.getTaskId().equals(castOther.getTaskId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getAccepterName() == null ? 0 : this.getAccepterName()
						.hashCode());
		result = 37 * result
				+ (getTaskId() == null ? 0 : this.getTaskId().hashCode());
		return result;
	}

}