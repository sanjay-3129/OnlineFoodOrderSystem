package com.foodorder.bo;

import java.util.Random;

import com.foodorder.dao.SecretCodeDAO;
import com.foodorder.dao.impl.CustomerDAOImpl;
import com.foodorder.dao.impl.SecretCodeDAOImpl;
import com.foodorder.models.Customer;
import com.foodorder.models.CustomerForgetModel;
import com.foodorder.util.MailSystem;

public class SendMail {
	
	public static String sendMailToVerify(String email) {
		
		Random rd = new Random();
		String subject = "Email Verification From Think-Food";
		String msg = "";
		
		int randomNo = rd.nextInt(999999);  //0 - 999999 (111111-999999)
		String randomCode = String.format("%06d", randomNo);
		
		msg = "Verification Code : " + randomCode + ".";
		System.out.println(msg);
		
		SecretCodeDAO dao1 = new SecretCodeDAOImpl();
		int secretCode = dao1.setSecretCode(randomCode);
		if(secretCode > 0) {
			MailSystem.sendMail(email, subject, msg);			
		}
		return randomCode;
	}
	
public static boolean sendMailToRetrievePassword(String email) {
		
		CustomerDAOImpl dao = new CustomerDAOImpl();
		
		
		String subject = "Confidential Details From Think Food";
		String msg = "";
		
		Customer customer = dao.getCustomerByEmail(email);
		CustomerForgetModel cred = SerDeser.deSerializeObjectData(customer.getCustomerId());  //here we will get the forget username and password.
		
		StringBuilder sb = new StringBuilder(msg);
		
		sb.append("Customer Id: " + cred.getCustomerId())
		.append("/nPassword: " + cred.getPassword());
		
		System.out.println(sb.toString());
		
		if(cred != null) {
			MailSystem.sendMail(email, subject, sb.toString());	
			return true;
		}
		return false;
	}

}
