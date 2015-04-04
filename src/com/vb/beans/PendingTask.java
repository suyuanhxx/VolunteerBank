package com.vb.beans;

import java.sql.Timestamp;

public class PendingTask {
	private String task_id;
	private String task_name;
	private String content;
	private int task_score;
	private Timestamp start_time;
	private Timestamp end_time;
	private String task_comment;
	private String accepter_name;
	private String publisher_name;
	private String progress;
	
	public PendingTask(){
	}
	
	public PendingTask(String task_id,String task_name, String content,int task_score,Timestamp start_time,
			Timestamp end_time,String task_comment, String accepter_name,String publisher_name,String progress){
		this.task_id = task_id;
		this.task_name = task_name;
		this.content = content;
		this.task_score = task_score;
		this.start_time = start_time;
		this.end_time = end_time;
		this.task_comment = task_comment;
		this.accepter_name = accepter_name;
		this.publisher_name = publisher_name;
		this.progress = progress;
	}
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTask_score() {
		return task_score;
	}
	public void setTask_score(int task_score) {
		this.task_score = task_score;
	}
	
	public Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	
	public String getTask_comment() {
		return task_comment;
	}
	public void setTask_comment(String task_comment) {
		this.task_comment = task_comment;
	}
	
	public String getAccepter_name() {
		return accepter_name;
	}
	public void setAccepter_name(String accepter_name) {
		this.accepter_name = accepter_name;
	}
	public String getPublisher_name() {
		return publisher_name;
	}
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}
	
}
