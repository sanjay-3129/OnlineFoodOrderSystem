package com.foodorder.models;

public class CustomerCredential {
	private String email;
	private String password;

	public CustomerCredential() {
		super();
	}

	public CustomerCredential(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
