package com.vb.beans;

import java.sql.Timestamp;

public class TaskList {
	private String task_id;
	private String task_name;
	private String content;
	private Timestamp start_time;
	private Timestamp end_time;
	private int task_score;
	private String task_comment;
	private int start_flag;
	
	public TaskList(){
	}
	
	public TaskList(String task_id,String task_name, String content,int task_score,Timestamp start_time,
			Timestamp end_time,String task_comment, int start_flag){
		this.task_id = task_id;
		this.task_name = task_name;
		this.content = content;
		this.start_time = start_time;
		this.end_time = end_time;
		this.task_score = task_score;
		this.task_comment = task_comment;
		this.start_flag = start_flag;
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
	public int getTask_score() {
		return task_score;
	}
	public void setTask_score(int task_score) {
		this.task_score = task_score;
	}
	public String getTask_comment() {
		return task_comment;
	}
	public void setTask_comment(String task_comment) {
		this.task_comment = task_comment;
	}
	public int getStart_flag() {
		return start_flag;
	}
	public void setStart_flag(int start_flag) {
		this.start_flag = start_flag;
	}

	
}
