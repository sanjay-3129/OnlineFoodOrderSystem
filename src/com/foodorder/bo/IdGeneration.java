package com.foodorder.bo;

import java.util.Random;

public class IdGeneration {
	
	public static String generateCustomerId() {
		String customerId = "";
		
		Random rd = new Random();
		
		int randomNo = rd.nextInt(9999);  //0 - 999999 (111111-999999)
		String randomCode = String.format("%04d", randomNo);
		
		customerId = "CUS" + randomCode;
		System.out.println(customerId);
		
		return customerId;
	}
	
	public static String generateOrderId() {
		String orderId = "";
		
		Random rd = new Random();
		
		int randomNo = rd.nextInt(9999);  //0 - 999999 (111111-999999)
		String randomCode = String.format("%04d", randomNo);
		
		orderId = "ORDER" + randomCode;
		System.out.println(orderId);
		
		return orderId;
	}

}
