package com.foodorder.dao;

import java.util.List;

import com.foodorder.models.Order;

public interface OrderDAO {
	int addOrderDetails(Order order);

	List<Order> getOrderDetails();

	Order getOrderByCustomerId(String c_id);
}
