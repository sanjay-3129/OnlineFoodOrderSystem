package com.foodorder.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foodorder.dao.CustomerDAO;
import com.foodorder.models.Customer;
import com.foodorder.models.CustomerCredential;

public class CustomerDAOImpl implements CustomerDAO {
	public static Connection conn;

	public static Connection getConnect() throws IOException {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodorder", "root", "Sanjay00197!@#");

		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException ce) {
			System.out.println(ce);
		}
		return conn;

	}

	@Override
	public int addCustomerDetails(Customer user) {
		int data = 0;
		try {
			conn = getConnect();

			PreparedStatement p = conn.prepareStatement("insert into customer values(?,?,?,?,?,?)");			
			p.setString(1, user.getCustomerId());
			p.setString(2, user.getFirstName());
			p.setString(3, user.getLastName());
			p.setString(4, user.getEmail());
			p.setString(5, user.getPhoneNumber());
			p.setString(6, user.getAddress());

			data = p.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return data;
	}

	@Override
	public int addCustomerCredentials(CustomerCredential Login) {
		int status = 0;
		try {
			conn = getConnect();

			PreparedStatement ps = conn.prepareStatement("insert into customercredentials values(?,?)");
			ps.setString(1, Login.getEmail());
			ps.setString(2, Login.getPassword());

			status = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	@Override
	public double addToCart(int itemId, int itemQuantity) {
		double totalItemCost = 0.0;

		try {
			conn = getConnect();
			PreparedStatement ps = conn.prepareStatement("select item_price from menu where item_id=?");
			ps.setInt(1, itemId);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				if (itemQuantity > 0) {
					totalItemCost = res.getDouble(1) * itemQuantity;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return totalItemCost;
	}

	@Override
	public Customer getCustomerById(String customerId) {
		Customer c = null;
		try {
			conn = getConnect();
			PreparedStatement ps = conn.prepareStatement("select * from Customer where customer_id=?");
			ps.setString(1, customerId);
			ResultSet res = ps.executeQuery();
			c = new Customer();
			while (res.next()) {
				c.setFirstName(res.getString(1));
				c.setLastName(res.getString(2));
				c.setEmail(res.getString(3));
				c.setPhoneNumber(res.getString(4));
				return c;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return c;
	}

	@Override
	public CustomerCredential getCustomerCredentialByEmail(String email) {
		CustomerCredential cr = null;
		try {
			conn = getConnect();
			PreparedStatement ps = conn.prepareStatement("select * from customercredentials where username=?");
			ps.setString(1, email);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				cr = new CustomerCredential();
				cr.setEmail(res.getString(1));
				cr.setPassword(res.getString(2));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return cr;
	}

	@Override
	public int editCustomerDetails(Customer user) {
		int status = 0;

		try {

			conn = getConnect();
			PreparedStatement ps = conn.prepareStatement("update customer "
					+ "set fisrtname=?, lastname=? ,email_id=?, phonenumber=?, address=?" + "where customer_id=?");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhoneNumber());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getCustomerId());
			status = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
	
	@Override
	public Customer getCustomerByEmail(String email) {
		Customer c = null;
		try {
			conn = getConnect();
			PreparedStatement ps = conn.prepareStatement("select * from customer where email_id=?");
			ps.setString(1, email);
			ResultSet res = ps.executeQuery();
	
			while (res.next()) {
				String customerId = res.getString(1);
				String firstName = res.getString(2);
				String lastName = res.getString(3);
				String emailId = res.getString(4);
				String phoneNumber = res.getString(5);
				String address = res.getString(6);
				c = new Customer(customerId, firstName, lastName, emailId, phoneNumber, address);
				return c;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return c;
	}

}
