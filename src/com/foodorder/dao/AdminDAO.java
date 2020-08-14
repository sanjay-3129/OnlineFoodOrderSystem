package com.foodorder.dao;

import java.util.List;

import com.foodorder.models.Admin;
import com.foodorder.models.AdminCredential;
import com.foodorder.models.Menu;

public interface AdminDAO {
	
	int addAdminDetails(Admin superuser);
	
	List<Admin> getAdminDetails();

	int addAdminCredentials(AdminCredential userLogin);
	
	AdminCredential getCredentialByUsername(String userName);

	int addFoodItem(Menu Item);

	List<Menu> getMenuDetails();
	
	int editItem(Menu item);
	
	int deleteItem(String itemId);

}
