/*
 * Filename: HeaderServlet.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aaron.service.GameService;
import com.aaron.service.UserService;
import com.arron.entities.Game;
import com.arron.entities.User;

/**
 * Servlet implementation class HeaderServlet
 * 
 */
@WebServlet("/HeaderServlet")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HeaderServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Game> games = GameService.getAllGames();
		request.setAttribute("games", games);

		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute("user") != null) {
				request.setAttribute("loggedIn", true);
			}

			if (session.getAttribute("admin") != null) {
				request.setAttribute("isAdmin", true);
			}
			
			for (User u : UserService.getAllUsers()) {
				if (u.getName().equals(session.getAttribute("user"))) {
					request.setAttribute("u", u);
					break;
				}
			}
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/header.jsp");
		rd.forward(request, response);
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
