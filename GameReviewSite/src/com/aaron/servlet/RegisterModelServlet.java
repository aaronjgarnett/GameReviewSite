/*
 * Filename: RegisterModelServlet.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aaron.service.UserService;
import com.arron.entities.User;

/**
 * Servlet implementation class RegisterModelServlet
 * 
 */
@WebServlet("/RegisterModelServlet")
public class RegisterModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterModelServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		Boolean exists = false;

		for (User u : UserService.getAllUsers()) {
			if (u.getName().equals(user) || u.getEmail().equals(pass)) {
				exists = true;
				break;
			}
		}

		if (!exists) {
			UserService.addUser(new User(email, user, pass));

			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			response.sendRedirect("IndexServlet");
		} else {
			request.setAttribute("registerError", "Sorry, username/email are already being used!");

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/RegisterServlet");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
