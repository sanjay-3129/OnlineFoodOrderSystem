package com.foodorder.models;

public class AdminCredential {

	private String username;
	private String password;

	public AdminCredential() {
		super();
	}

	public AdminCredential(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
