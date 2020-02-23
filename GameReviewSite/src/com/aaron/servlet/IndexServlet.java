/*
 * Filename: IndexServlet.java
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

import com.aaron.service.GameService;
import com.aaron.service.GenreService;
import com.arron.entities.Game;
import com.arron.entities.Genre;

/**
 * Servlet implementation class IndexServlet
 * 
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String genreType = request.getParameter("id");

		if (genreType != null) {
			List<Game> games = GameService.getTopTenGamesByGenre(Integer.parseInt(genreType));
			request.setAttribute("games", games);
		} else {
			List<Game> games = GameService.getTopTenGames();
			request.setAttribute("games", games);
		}

		List<Genre> genres = GenreService.getAllGenres();
		request.setAttribute("genres", genres);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/index.jsp");
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
