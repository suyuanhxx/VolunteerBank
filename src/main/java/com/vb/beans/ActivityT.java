package com.vb.beans;

/**
 * ActivityT entity. @author MyEclipse Persistence Tools
 */

public class ActivityT implements java.io.Serializable {

	// Fields

	private String activityId;
	private String activityTitle;
	private String activityContent;

	// Constructors

	/** default constructor */
	public ActivityT() {
	}

	/** minimal constructor */
	public ActivityT(String activityId, String activityTitle) {
		this.activityId = activityId;
		this.activityTitle = activityTitle;
	}

	/** full constructor */
	public ActivityT(String activityId, String activityTitle,
			String activityContent) {
		this.activityId = activityId;
		this.activityTitle = activityTitle;
		this.activityContent = activityContent;
	}

	// Property accessors

	public String getActivityId() {
		return this.activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getActivityTitle() {
		return this.activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getActivityContent() {
		return this.activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

}