package com.foodorder.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodorder.dao.OrderDAO;
import com.foodorder.models.Order;

public class OrderDAOImpl implements OrderDAO {
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
	public int addOrderDetails(Order order) {
		int status = 0;
		try {
			conn = getConnect();
			System.out.println(conn);
			PreparedStatement ps = conn.prepareStatement("insert into orders values(?,?,?)");
			ps.setString(1, order.getC_id());
			ps.setString(2, order.getOrder_id());
			ps.setDouble(3, order.getBill());

			status = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;

	}

	@Override
	public List<Order> getOrderDetails() {
		List<Order> list = new ArrayList<>();
		Order order = null;
		try {
			conn = getConnect();
			PreparedStatement ps = conn.prepareStatement("select * from orders");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				order = new Order();

				order.setOrder_id(rs.getNString(1));
				order.setBill(rs.getDouble(2));
				order.setC_id(rs.getNString(3));

				list.add(order);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public Order getOrderByCustomerId(String c_id) {
		Order order = new Order();
		try {
			conn = getConnect();
			PreparedStatement ps = conn.prepareStatement("select * from orders where customer_id=?");
			ps.setString(1, c_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				order.setOrder_id(rs.getNString(1));
				order.setBill(rs.getDouble(2));
				order.setC_id(rs.getNString(3));

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return order;
	}

	public List<Order> getOrderByOrderId(String orderId) {
		List<Order> orders = new ArrayList<>();
		Order order = null;
		try {
			conn = getConnect();
			PreparedStatement ps = conn.prepareStatement("select * from orders where order_id=?");
			ps.setString(1, orderId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				order = new Order();
				order.setC_id(rs.getString(1));
				order.setOrder_id(rs.getString(2));
				order.setBill(rs.getDouble(3));
				
				orders.add(order);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
}
