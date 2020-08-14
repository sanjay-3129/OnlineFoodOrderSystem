package com.foodorder.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodorder.bo.CheckPassword;
import com.foodorder.bo.SendMail;
import com.foodorder.dao.AdminDAO;
import com.foodorder.dao.CustomerDAO;
import com.foodorder.dao.impl.AdminDAOImpl;
import com.foodorder.dao.impl.CustomerDAOImpl;
import com.foodorder.models.AdminCredential;
import com.foodorder.models.Customer;
import com.foodorder.models.CustomerCredential;
import com.foodorder.models.Menu;
import com.foodorder.util.PasswordEncode;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/admin/login", "/customer/login", "/customer/forgetPassword" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String servletPath = request.getServletPath();
		AdminDAO dao = null;
		CustomerDAO dao1 = new CustomerDAOImpl();
		HttpSession session = request.getSession();
		if (servletPath.contains("admin/login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String encodedPassword = PasswordEncode.encodePassword(password);
			
			dao = new AdminDAOImpl();
			AdminCredential adminCredential = dao.getCredentialByUsername(username);
			
			if (CheckPassword.passwordValidation(adminCredential, username, encodedPassword)) {
				session.setAttribute("username", username); //email here
				session.setAttribute("name", username);
				session.setMaxInactiveInterval(15*60); //15mins
				if(session.isNew()) {
					request.getRequestDispatcher("/adminlogin.jsp").forward(request, response);
				} else {
					List<Menu> itemList = dao.getMenuDetails();
					request.setAttribute("itemList", itemList);
					request.getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
					//out.print("You have successfully logged in to admin dashboard...");
				}
			}
			else {
				request.getRequestDispatcher("/adminlogin.jsp").forward(request, response);
				session.invalidate();
			}

		} else if (servletPath.contains("customer/login")) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String encodedPassword = PasswordEncode.encodePassword(password);
			
			Customer customer = new CustomerDAOImpl().getCustomerByEmail(username);
			System.out.println("customer id in login servlet: " + customer.getCustomerId());
			session.setAttribute("customerId", customer.getCustomerId());
			//System.out.println("Session, customerId: "+session.getAttribute("customerId"));
			
			CustomerCredential customerCredential = dao1.getCustomerCredentialByEmail(username);
			
			if (CheckPassword.customerPasswordValidation(customerCredential, username, encodedPassword)) {
				session.setAttribute("username", username); //email here
				session.setMaxInactiveInterval(15*60); //15mins
				if(session.isNew()) {
					request.getRequestDispatcher("/customerlogin.jsp").forward(request, response);
				} else {
					dao = new AdminDAOImpl();
					List<Menu> itemList = dao.getMenuDetails(); //getting details from admin database
					request.setAttribute("itemList", itemList);
//					System.out.println(itemList.get(3).getItemImgPath());
					request.getRequestDispatcher("/customerDashboard.jsp").forward(request, response);
				}
			}
			else {
				request.getRequestDispatcher("/customerlogin.jsp").forward(request, response);
				session.invalidate();	
			}
			
		} else if(servletPath.contains("customer/forgetPassword")) {
			
			String email = request.getParameter("email");
			boolean passwordSent = SendMail.sendMailToRetrievePassword(email); 
			
			if(passwordSent) {
				request.getRequestDispatcher("/customerlogin.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/forgetPassword.jsp").forward(request, response);
			}
			
			
		} else {
			request.getRequestDispatcher("/error.html").forward(request, response);
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
