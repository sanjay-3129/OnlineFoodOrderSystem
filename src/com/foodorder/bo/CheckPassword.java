package com.foodorder.bo;

import com.foodorder.models.AdminCredential;
import com.foodorder.models.CustomerCredential;

public class CheckPassword {

	public static boolean passwordValidation(AdminCredential cred, String username, String encodedPassword) {

		if ((cred.getUsername().equals(username)) && (cred.getPassword().equals(encodedPassword))) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean customerPasswordValidation(CustomerCredential cred, String username, String encodedPassword) {

		if ((cred.getEmail().equals(username)) && (cred.getPassword().equals(encodedPassword))) {
			return true;
		} else {
			return false;
		}
	}

}
