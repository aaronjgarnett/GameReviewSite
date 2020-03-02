/*
 * Filename: AddGameModelServlet.java
 * author: Aaron Garnett
 * date: 2/29/2020 original
 * 
 * */
package com.aaron.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.aaron.config.UtilityConfig;
import com.aaron.entities.Game;
import com.aaron.entities.Genre;
import com.aaron.entities.PublishingCompany;
import com.aaron.service.GameService;
import com.aaron.service.GenreService;
import com.aaron.service.PublishingCompanyService;

/**
 * Servlet implementation class AddGameModelServlet
 */
@WebServlet("/AddGameModelServlet")
@MultipartConfig(location = UtilityConfig.USER_AARON)
public class AddGameModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddGameModelServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gameName = request.getParameter("name");
		String genre = request.getParameter("genreType");
		String publisher = request.getParameter("publisher");
		String date = request.getParameter("date");
		Part cover = request.getPart("cover");
		String description = request.getParameter("description");
		String fileName = Paths.get(cover.getSubmittedFileName()).getFileName().toString();
		String savePath = "uploadFiles";
		Boolean exists = false;

		List<Genre> gameGenre = new ArrayList<>();
		PublishingCompany publishingCompany = new PublishingCompany();

		for (Game g : GameService.getAllGames()) {
			if (g.getName().equals(gameName)) {
				exists = true;
				break;
			}
		}

		for (Genre e : GenreService.getAllGenres()) {
			if (e.getName().equals(genre)) {
				gameGenre.add(e);
				break;
			}
		}

		for (PublishingCompany pc : PublishingCompanyService.getAllPublishers()) {
			if (pc.getName().equals(publisher)) {
				publishingCompany = pc;
				break;
			}
		}

		if (!exists) {
			for (Part part : request.getParts()) {
				String name = UtilityConfig.EXTRACT_FILENAME(part);
				name = new File(name).getName();
				if (name.equals("cover")) {
					name = fileName;
					part.write(savePath + File.separator + name);
					try {
						GameService.addGame(new Game(savePath + File.separator + name, description, gameName,
								new SimpleDateFormat("yyyy-MM-dd").parse(date), gameGenre, publishingCompany));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
			}

			response.sendRedirect("AddGameServlet");
		} else {
			request.setAttribute("addError", "That game is already in the database!");

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddGameServlet");
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
