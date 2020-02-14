package com.aaron.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aaron.service.GameService;
import com.arron.entities.Game;

/**
 * @author aaron
 * 
 *         Servlet implementation class GameServlet
 */
@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gameId = request.getParameter("id");
		String search = request.getParameter("search");
		Boolean gameFound = false;
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/game.jsp");

		if (gameId != null) {
			Game g = GameService.getGameById(Integer.parseInt(gameId));
			request.setAttribute("game", g);
			gameFound = true;
		} else {
			for (Game g : GameService.getAllGames()) {
				if (g.getName().equals(search)) {
					request.setAttribute("game", g);
					gameFound = true;
					break;
				}
			}
		}

		if (!gameFound) {
			rd = getServletContext().getRequestDispatcher("/jsp/error.jsp");
		}

		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute("user") != null) {
				request.setAttribute("loggedIn", true);
			}
		}

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
