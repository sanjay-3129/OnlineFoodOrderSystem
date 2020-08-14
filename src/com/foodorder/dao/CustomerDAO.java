package com.foodorder.dao;

import com.foodorder.models.Customer;
import com.foodorder.models.CustomerCredential;

public interface CustomerDAO {

	int addCustomerDetails(Customer user);

	int addCustomerCredentials(CustomerCredential Login);

	double addToCart(int itemId, int itemQuantity);

	Customer getCustomerById(String customerId);

	CustomerCredential getCustomerCredentialByEmail(String email);

	int editCustomerDetails(Customer user);

	Customer getCustomerByEmail(String email);

}
