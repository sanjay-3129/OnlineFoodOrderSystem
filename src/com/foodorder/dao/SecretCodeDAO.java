package com.foodorder.dao;

public interface SecretCodeDAO {
	
	int setSecretCode(String code);
	
	String getSecrectCode();
	
	int deleteSecretCode();

}
