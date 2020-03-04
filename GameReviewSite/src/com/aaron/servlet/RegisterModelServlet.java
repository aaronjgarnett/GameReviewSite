/*
 * Filename: RegisterModelServlet.java
 * author: Aaron Garnett
 * date: 2/18/2020 original
 * 
 * */
package com.aaron.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.aaron.config.UtilityConfig;
import com.aaron.entities.User;
import com.aaron.exceptions.ValidationException;
import com.aaron.service.UserService;

/**
 * Servlet implementation class RegisterModelServlet
 * 
 */
@WebServlet("/RegisterModelServlet")
@MultipartConfig(location = UtilityConfig.USER_AARON)
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
		Part avatar = request.getPart("avatar");
		String fileName = Paths.get(avatar.getSubmittedFileName()).getFileName().toString();
		String savePath = "uploadFiles";
		Boolean exists = false;

		try {
			validatePassword(pass);
		} catch (ValidationException e) {
			e.printStackTrace();
		}

		if (UserService.getAllUsers().stream().anyMatch(u -> u.getName().equals(user) || u.getEmail().equals(pass))) {
			exists = true;
		}

		if (!exists) {
			if (!fileName.equals("")) {

				for (Part part : request.getParts()) {
					String name = UtilityConfig.EXTRACT_FILENAME(part);
					name = new File(name).getName();
					if (name.equals("avatar")) {
						name = fileName;
						part.write(savePath + File.separator + name);
						UserService.addUser(new User(savePath + File.separator + name, email, user, pass));
					}
				}

				HttpSession session = request.getSession();
				session.setAttribute("user", user);
			} else {
				UserService.addUser(new User(email, user, pass));

				HttpSession session = request.getSession();
				session.setAttribute("user", user);
			}

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

	public static void validatePassword(String pass) throws ValidationException {
		if (!pass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=.{8,})")) {
			throw new ValidationException("Exception: Your password must include one number, one\r\n"
					+ "						upper-case letter, one lower-case letter, and one special\r\n"
					+ "						character. The password must also be at least 8 characters long.");
		}
	}
}
