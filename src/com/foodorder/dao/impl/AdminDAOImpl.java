package com.foodorder.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodorder.dao.AdminDAO;
import com.foodorder.models.Admin;
import com.foodorder.models.AdminCredential;
import com.foodorder.models.Menu;

public class AdminDAOImpl implements AdminDAO {

	public static Connection conn;

	public static Connection getConnect() throws IOException {

		try {
			/*
			 * FileReader reader = new FileReader("db.properties"); Properties p = new
			 * Properties();
			 * 
			 * p.load(reader); String drivername = p.getProperty("db.driver"); String url =
			 * p.getProperty("db.url"); String user = p.getProperty("db.user"); String
			 * password = p.getProperty("db.password"); Class.forName(drivername);
			 * 
			 * conn = DriverManager.getConnection(url, user, password);
			 */

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
	public int addAdminDetails(Admin superuser) {
		int status = 0;
		try {
			conn = getConnect();
			System.out.println(conn);
			PreparedStatement ps = conn.prepareStatement("insert into admin values(?,?,?,?)");
			ps.setString(1, superuser.getFirstName());
			ps.setString(2, superuser.getLastName());
			ps.setString(3, superuser.getEmail());
			ps.setString(4, superuser.getPhoneNumber());
			status = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;

	}

	@Override
	public List<Admin> getAdminDetails() {
		List<Admin> list = new ArrayList<>();
		Admin admin = null;
		try {
			conn = getConnect();
			PreparedStatement ps = conn.prepareStatement("select * from admin");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				admin = new Admin();
				admin.setFirstName(rs.getString(1));
				admin.setLastName(rs.getString(2));
				admin.setEmail(rs.getString(3));
				admin.setPhoneNumber(rs.getString(4));

				list.add(admin);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public int addAdminCredentials(AdminCredential userLogin) {
		int status = 0;
		try {
			conn = getConnect();

			PreparedStatement ps = conn.prepareStatement("insert into admincredentials values(?,?)");
			ps.setString(1, userLogin.getUsername());
			ps.setString(2, userLogin.getPassword());

			status = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	@Override
	public AdminCredential getCredentialByUsername(String username) {
		AdminCredential adminCr = null;
		try {

			conn = getConnect();
			PreparedStatement ps = conn.prepareStatement("select * from admincredentials where a_username=?");
			ps.setString(1, username);
			ResultSet res = ps.executeQuery();
			adminCr = new AdminCredential();
			while (res.next()) {
				adminCr.setUsername(res.getString(1));
				adminCr.setPassword(res.getString(2));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return adminCr;

	}

	@Override
	public int addFoodItem(Menu item) {

		int status = 0;
		try {
			conn = getConnect();

			PreparedStatement ps = conn.prepareStatement("insert into menu values(?,?,?,?,?)");
			ps.setString(1, item.getItemId());
			ps.setString(2, item.getItemName());
			ps.setDouble(3, item.getItemPrice());
			ps.setString(4, item.getItemType());
			ps.setString(5, item.getItemImgPath());

			status = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	@Override
	public List<Menu> getMenuDetails() {
		List<Menu> itemList = new ArrayList<Menu>();

		try {

			conn = getConnect();
			PreparedStatement ps = conn.prepareStatement("select * from menu");
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Menu item = new Menu();
				item.setItemId(res.getString(1));
				item.setItemName(res.getString(2));
				item.setItemPrice(res.getDouble(3));
				item.setItemType(res.getString(4));
				item.setItemImgPath(res.getString(5));
				itemList.add(item);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return itemList;

	}

	@Override
	public int editItem(Menu item) {
		int status = 0;

		try {

			conn = getConnect();
			PreparedStatement ps = conn.prepareStatement(
					"update menu " + "set item_name=?, item_price=? ,item_type=?, item_image=?" + "where item_id=?");
			ps.setString(1, item.getItemName());
			ps.setDouble(2, item.getItemPrice());
			ps.setString(3, item.getItemType());
			ps.setString(4, item.getItemImgPath());
			ps.setString(5, item.getItemId());
			status = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public int deleteItem(String itemId) {
		int status=0;
		try {
			conn=getConnect();
			PreparedStatement ps=conn.prepareStatement("delete from menu where item_id=?");
			ps.setString(1, itemId);
			
			status=ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

}
