package com.vb.beans;

public class CatchTask {
	private String task_id;
	private String task_name;
	
	public CatchTask(String task_id , String task_name){
		this.task_id = task_id;
		this.task_name = task_name;
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
}
