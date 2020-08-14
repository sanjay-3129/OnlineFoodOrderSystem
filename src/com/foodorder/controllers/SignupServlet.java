package com.foodorder.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodorder.bo.IdGeneration;
import com.foodorder.bo.SendMail;
import com.foodorder.bo.SerDeser;
import com.foodorder.dao.AdminDAO;
import com.foodorder.dao.CustomerDAO;
import com.foodorder.dao.impl.AdminDAOImpl;
import com.foodorder.dao.impl.CustomerDAOImpl;
import com.foodorder.models.Admin;
import com.foodorder.models.AdminCredential;
import com.foodorder.models.Customer;
import com.foodorder.models.CustomerCredential;
import com.foodorder.util.PasswordEncode;

/**
 * Servlet implementation class SignupServlet this servlet will maintain signup
 * for both customer and admin
 */
@WebServlet(urlPatterns = { "/signup/admin", "/signup/customer" })
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		System.out.println("Served at: " + request.getServletPath()); // localhost:8080/onlinefood/signup/admin
		String servletPath = request.getServletPath();
		if (servletPath.contains("admin")) {
			String fname = request.getParameter("fname"); // not attribute
			String lname = request.getParameter("lname");
			String mail = request.getParameter("mail");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");
			System.out.println(mail + " " + password);

			String encodedPassword = PasswordEncode.encodePassword(password);
			// admin credential class
			Admin admin = new Admin(fname, lname, mail, phone);

			// encoding password and storing in module
			AdminCredential ac = new AdminCredential(mail, encodedPassword);

			// adding admin details
			AdminDAO dao = new AdminDAOImpl();
			int adminDetails = dao.addAdminDetails(admin);
			if (adminDetails > 0) {
				System.out.println("admin details added successfully.");
			} else {
				System.out.println("admin details not added in db...");
			}

			// adding username and encoded password in admincredentials
			int adminCredentials = dao.addAdminCredentials(ac);
			if (adminCredentials > 0) {
				System.out.println("admin credentials added successfully.");
				// and proceed to email verification by sending email
				SendMail.sendMailToVerify(mail); // code added to db in this method itself
													// and email will be sent
				request.getRequestDispatcher("/emailverify.jsp").forward(request, response); // email verification
			} else {
				System.out.println("admin credentials not added in db...");
				request.getRequestDispatcher("/adminsignup.jsp").forward(request, response); // signup page
			}
		} else if (servletPath.contains("customer")) {
			// customer
			String fname = request.getParameter("fname"); // not attribute
			String lname = request.getParameter("lname");
			String mail = request.getParameter("mail");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");
			String address = request.getParameter("address");

			String encodedPassword = PasswordEncode.encodePassword(password);

			String customerId = IdGeneration.generateCustomerId(); // random customer id

			// using serialization store the username and password, and if user forgets the
			// password
			// deserialize that file and send the stored password to the customers mail...
			boolean serialized = SerDeser.serializeObjectData(customerId, mail, password);

			if (serialized) {
				Customer customer = new Customer(customerId, fname, lname, mail, phone, address);

				CustomerCredential cred = new CustomerCredential(mail, encodedPassword);

				CustomerDAO dao = new CustomerDAOImpl();

				int customerDetails = dao.addCustomerDetails(customer);
				if (customerDetails > 0) {
					System.out.println("customer details added successfully.");
				} else {
					System.out.println("customer details not added in db...");
				}

				int addCustomerCredentials = dao.addCustomerCredentials(cred);
				if (addCustomerCredentials > 0) {
					System.out.println("customer details added successfully.");
					SendMail.sendMailToVerify(mail);
					request.getRequestDispatcher("/customeremailverify.jsp").forward(request, response);
				} else {
					System.out.println("customer details not added in db...");
					request.getRequestDispatcher("/customersignup.jsp").forward(request, response);
				}
			} else {
				System.out.println("Serialization not done for backuping the passwords...");
				request.getRequestDispatcher("/customersignup.jsp").forward(request, response);
			}
		} else {
			out.println("Having some issues... contact the developer");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
