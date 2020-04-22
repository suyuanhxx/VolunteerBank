package com.vb.beans;

/**
 * PublisherTaskTId entity. @author MyEclipse Persistence Tools
 */

public class PublisherTaskTId implements java.io.Serializable {

	// Fields

	private String publisherName;
	private String taskId;

	// Constructors

	/** default constructor */
	public PublisherTaskTId() {
	}

	/** full constructor */
	public PublisherTaskTId(String publisherName, String taskId) {
		this.publisherName = publisherName;
		this.taskId = taskId;
	}

	// Property accessors

	public String getPublisherName() {
		return this.publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
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
		if (!(other instanceof PublisherTaskTId))
			return false;
		PublisherTaskTId castOther = (PublisherTaskTId) other;

		return ((this.getPublisherName() == castOther.getPublisherName()) || (this
				.getPublisherName() != null
				&& castOther.getPublisherName() != null && this
				.getPublisherName().equals(castOther.getPublisherName())))
				&& ((this.getTaskId() == castOther.getTaskId()) || (this
						.getTaskId() != null && castOther.getTaskId() != null && this
						.getTaskId().equals(castOther.getTaskId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getPublisherName() == null ? 0 : this.getPublisherName()
						.hashCode());
		result = 37 * result
				+ (getTaskId() == null ? 0 : this.getTaskId().hashCode());
		return result;
	}

}