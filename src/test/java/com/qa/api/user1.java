package com.qa.api;

public class user1 {
	
	String name;
	String job;
	String id;
	String createdAt;

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	public user1() {
		
	}

	
	public user1(String name,String job) {
		this.name = name;
		this.job = job;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}
}
