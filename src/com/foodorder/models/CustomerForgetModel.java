package com.foodorder.models;

import java.io.Serializable;

public class CustomerForgetModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String customerId;
	private String password;

	public CustomerForgetModel() {
		super();
	}

	public CustomerForgetModel(String customerId, String password) {
		super();
		this.customerId = customerId;
		this.password = password;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
