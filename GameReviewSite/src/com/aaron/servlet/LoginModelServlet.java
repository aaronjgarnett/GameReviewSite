/*
 * Filename: LoginModelServlet.java
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

import com.aaron.entities.User;
import com.aaron.service.UserService;

/**
 * Servlet implementation class LoginModelServlet
 * 
 */
@WebServlet("/LoginModelServlet")
public class LoginModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginModelServlet() {
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
		String pass = request.getParameter("pass");
		Boolean loggedIn = false;
		Boolean isAdmin = false;

		for (User u : UserService.getAllUsers()) {
			if (u.getName().equals(user) && u.getPassword().equals(pass) && !u.getIsBlocked()) {
				loggedIn = true;

				if (u.getIsAdmin()) {
					isAdmin = true;
				}

				break;
			}
		}

		if (loggedIn) {
			if (isAdmin) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("admin", user);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
			}

			response.sendRedirect("IndexServlet");
		} else {
			request.setAttribute("loginError",
					"Sorry, username/password were incorrect! There is also a possibility that you may be blocked.");

			RequestDispatcher rd = request.getRequestDispatcher("/jsp/login.jsp");
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
