package com.foodorder.models;

public class Order {

	private String order_id;
	private double billAmount;
	private String customer_id;

	public Order() {
		super();
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public double getBill() {
		return billAmount;
	}

	public void setBill(double bill) {
		this.billAmount = bill;
	}

	public String getC_id() {
		return customer_id;
	}

	public void setC_id(String c_id) {
		this.customer_id = c_id;
	}

	public Order(String order_id, double bill, String c_id) {
		super();
		this.order_id = order_id;
		this.billAmount = bill;
		this.customer_id = c_id;
	}

}
