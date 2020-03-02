/*
 * Filename: UserModelServlet.java
 * author: Aaron Garnett
 * date: 2/29/2020 original
 * 
 * */
package com.aaron.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.aaron.config.UtilityConfig;
import com.aaron.service.UserService;

/**
 * Servlet implementation class UserModelServlet
 */
@WebServlet("/UserModelServlet")
@MultipartConfig(location = UtilityConfig.USER_AARON)
public class UserModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserModelServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("id");
		Part avatar = request.getPart("avatar");
		String fileName = Paths.get(avatar.getSubmittedFileName()).getFileName().toString();
		String savePath = "uploadFiles";

		for (Part part : request.getParts()) {
			String name = UtilityConfig.EXTRACT_FILENAME(part);
			name = new File(name).getName();
			name = fileName;
			part.write(savePath + File.separator + name);
			UserService.updateAvater(Integer.parseInt(userId), savePath + File.separator + name);
		}

		response.sendRedirect("IndexServlet?id=" + userId);
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
