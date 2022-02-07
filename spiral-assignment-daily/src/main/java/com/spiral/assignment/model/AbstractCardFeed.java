package com.spiral.assignment.model;

import java.io.Serializable;

public abstract class AbstractCardFeed implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer id = 0;
	private StatusFeed status   = null;
	private String from    = null;
	private String condition = null;
	
	public String getAuthor() {
		return from;
	}
	public void setAuthor(String author) {
		this.from = author;
	}

	public StatusFeed getStatus() {
		return status;
	}
	public void setStatus(StatusFeed statusUpdate) {
		this.status = statusUpdate;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
