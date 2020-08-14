package com.foodorder.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodorder.bo.FilterMenu;
import com.foodorder.bo.IdGeneration;
import com.foodorder.dao.AdminDAO;
import com.foodorder.dao.OrderDAO;
import com.foodorder.dao.impl.AdminDAOImpl;
import com.foodorder.dao.impl.OrderDAOImpl;
import com.foodorder.models.Menu;
import com.foodorder.models.Order;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet(urlPatterns = { "/admin/addItem", "/admin/dashboard/search", "/admin/home", "/admin/delete",
		"/admin/update", "/admin/itemUpdation", "/customer/saveOrder" })
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashboardServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getServletPath());
		// response.setContentType("text/html");
		// PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String customerId = (String) session.getAttribute("customerId");
		String servletPath = request.getServletPath();
		AdminDAO dao = new AdminDAOImpl();
		String items = "";

		if (username != null) {
			if (servletPath.contains("addItem")) {
				System.out.println(username);
				String itemId = request.getParameter("itemId");
				String itemName = request.getParameter("itemName");
				double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));
				String itemType = request.getParameter("itemType");
				String itemImgPath = request.getParameter("itemPath");

				Menu menu = new Menu(itemId, itemName, itemPrice, itemType, itemImgPath);

				int addFoodItem = dao.addFoodItem(menu);
				if (addFoodItem > 0) {
					items = "full";
					session.setAttribute("items", items);
					List<Menu> itemList = dao.getMenuDetails();
					request.setAttribute("itemList", itemList);
					request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
				}
			} else if (servletPath.contains("search")) {
				items = "search";
				session.setAttribute("items", items);
				String searchItem = request.getParameter("searchItem");
				List<Menu> menuDetails = dao.getMenuDetails(); // all menu items
				List<Menu> filteredItems = FilterMenu.getFilteredMenuItems(menuDetails, searchItem);

				request.setAttribute("itemList", filteredItems);
				request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
			} else if (servletPath.contains("home")) {
				List<Menu> itemList = dao.getMenuDetails();
				request.setAttribute("itemList", itemList);
				request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);

			} else if (servletPath.contains("delete")) {
				String itemId = request.getParameter("itemId");
				int deleteItem = dao.deleteItem(itemId);
				if (deleteItem > 0) {
					List<Menu> itemList = dao.getMenuDetails();
					request.setAttribute("itemList", itemList);
					request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
				}
			} else if (servletPath.contains("update")) {
				String itemId = request.getParameter("itemId");
				request.setAttribute("itemId", itemId);
				request.getRequestDispatcher("/updateitemform.jsp").forward(request, response);

			} else if (servletPath.contains("itemUpdation")) {
				String itemId = request.getParameter("itemId");
				String itemName = request.getParameter("itemName");
				double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));
				String itemType = request.getParameter("itemType");
				String itemImgPath = request.getParameter("itemPath");

				Menu menu = new Menu(itemId, itemName, itemPrice, itemType, itemImgPath);

				int updateFoodItem = dao.editItem(menu);
				if (updateFoodItem > 0) {
					List<Menu> itemList = dao.getMenuDetails();
					request.setAttribute("itemList", itemList);
					request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
				}
			}
		} 
		if (servletPath.contains("saveOrder")) {
			if (customerId != null) {
				OrderDAO dao1 = null;
				System.out.println("customer id: " + session.getAttribute("customerId"));
				double totalBillAmount = Double.parseDouble(request.getParameter("totalBillAmount"));
				String orderId = IdGeneration.generateOrderId();
				Order order = new Order(orderId, totalBillAmount, customerId);
				dao1 = new OrderDAOImpl();
				System.out.println(
						"OrderId: " + orderId + "customerId: " + customerId + "totalBillAmount: " + totalBillAmount);
				int orderDetails = dao1.addOrderDetails(order);

				if (orderDetails > 0) {
					request.setAttribute("order", order);
					/*
					 * out.println("Order Placed..."); out.println("Customer Id: " +
					 * order.getC_id()); out.println("Order Id: " + order.getOrder_id());
					 * out.println("Total Bill Amount: " + order.getBill());
					 */
					request.getRequestDispatcher("/orderPlaced.jsp").forward(request, response);
				}
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
