package com.vb.beans;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * TaskT entity. @author MyEclipse Persistence Tools
 */

public class TaskT implements java.io.Serializable {

	// Fields

	private String taskId;
	private String taskName;
	private String content;
	private Timestamp startTime;
	private Timestamp endTime;
	private BigDecimal taskScore;
	private String taskComment;
	private BigDecimal startFlag;//-1表示任务没有人申请，0表示申请但没有开始，1表示任务已开始

	// Constructors

	/** default constructor */
	public TaskT() {
	}

	/** minimal constructor */
	public TaskT(String taskId) {
		this.taskId = taskId;
	}

	/** full constructor */
	public TaskT(String taskId, String taskName, String content,
			Timestamp startTime, Timestamp endTime, BigDecimal taskScore,
			String taskComment,BigDecimal startFlag) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.content = content;
		this.startTime = startTime;
		this.endTime = endTime;
		this.taskScore = taskScore;
		this.taskComment = taskComment;
		this.startFlag = startFlag;
	}

	// Property accessors

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getTaskScore() {
		return this.taskScore;
	}

	public void setTaskScore(BigDecimal taskScore) {
		this.taskScore = taskScore;
	}

	public String getTaskComment() {
		return this.taskComment;
	}

	public void setTaskComment(String taskComment) {
		this.taskComment = taskComment;
	}

	public BigDecimal getStartFlag() {
		return startFlag;
	}

	public void setStartFlag(BigDecimal startFlag) {
		this.startFlag = startFlag;
	}
	
}