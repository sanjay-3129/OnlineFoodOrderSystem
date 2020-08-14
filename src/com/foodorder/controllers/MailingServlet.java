package com.foodorder.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodorder.dao.SecretCodeDAO;
import com.foodorder.dao.impl.SecretCodeDAOImpl;

/**
 * Servlet implementation class MailingServlet
 */
@WebServlet(urlPatterns = {"/email/verify", "/email/customerVerification"})
public class MailingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(request.getServletPath());
		if(request.getServletPath().contains("verify")) {
			System.out.println("Inside Mailing Servlet Path");
			String code = request.getParameter("code");
			SecretCodeDAO dao = new SecretCodeDAOImpl();
			String secrectCode = dao.getSecrectCode();
			if(code.equals(secrectCode)) {
				int deleteSecretCode = dao.deleteSecretCode();
				if(deleteSecretCode > -1) {
					request.getRequestDispatcher("/adminlogin.jsp").forward(request, response);					
				}
			} else {
				request.getRequestDispatcher("/emailverify.jsp").forward(request, response);
			}
			
		} else if(request.getServletPath().contains("customerVerification")) {
			String code = request.getParameter("code");
			SecretCodeDAO dao = new SecretCodeDAOImpl();
			String secrectCode = dao.getSecrectCode();
			if(code.equals(secrectCode)) {
				int deleteSecretCode = dao.deleteSecretCode();
				if(deleteSecretCode > -1) {
					request.getRequestDispatcher("/customerlogin.jsp").forward(request, response);					
				}
			} else {
				request.getRequestDispatcher("/customeremailverify.jsp").forward(request, response);
			}
		} else {
			System.out.println("Check in mailing system servlet...");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
