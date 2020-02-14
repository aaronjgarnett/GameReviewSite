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
 * @author aaron
 * 
 *         Servlet implementation class LoginModelServlet
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

		for (User u : UserService.getAllUsers()) {
			if (u.getName().equals(user) && u.getPassword().equals(pass)) {
				loggedIn = true;
				break;
			}
		}

		if (loggedIn) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			response.sendRedirect("IndexServlet");
		} else {
			request.setAttribute("loginError", "Sorry, username/password were incorrect!");

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
