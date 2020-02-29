/*
 * Filename: AddGameServlet.java
 * author: Aaron Garnett
 * date: 2/29/2020 original
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

import com.aaron.entities.Genre;
import com.aaron.entities.PublishingCompany;
import com.aaron.service.GenreService;
import com.aaron.service.PublishingCompanyService;

/**
 * Servlet implementation class AddGameServlet
 */
@WebServlet("/AddGameServlet")
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddGameServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Genre> genres = GenreService.getAllGenres();
		request.setAttribute("genres", genres);

		List<PublishingCompany> publishers = PublishingCompanyService.getAllPublishers();
		request.setAttribute("publishers", publishers);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/gameForm.jsp");
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
