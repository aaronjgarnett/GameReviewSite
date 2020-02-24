/*
 * Filename: ReviewServlet.java
 * author: Aaron Garnett
 * date: 2/24/2020 original
 * 
 * */
package com.aaron.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aaron.service.GameService;
import com.aaron.service.ReviewService;
import com.aaron.service.UserService;
import com.arron.entities.Review;
import com.arron.entities.User;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String content = request.getParameter("subject");
		String score = request.getParameter("score");
		String game = request.getParameter("id");

		HttpSession session = request.getSession(false);
		if (session != null) {
			for (User u : UserService.getAllUsers()) {
				if (u.getName().equals(session.getAttribute("user"))) {
					request.setAttribute("user", u);
					break;
				}
			}
		}

		ReviewService.addReview(new Review(content, Double.parseDouble(score),
				GameService.getGameById(Integer.parseInt(game)), (User) request.getAttribute("user")));

		response.sendRedirect("GameServlet?id=" + GameService.getGameById(Integer.parseInt(game)).getId());
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
