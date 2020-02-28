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
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.aaron.service.UserService;
import com.arron.entities.User;

/**
 * Servlet implementation class RegisterModelServlet
 * 
 */
@WebServlet("/RegisterModelServlet")
@MultipartConfig(location = "C:\\Users\\aaron\\Documents\\GitHub\\GameReviewSite\\GameReviewSite\\WebContent")
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
		Part avatar = request.getPart("avatar");
		String pass = request.getParameter("pass");
		String fileName = Paths.get(avatar.getSubmittedFileName()).getFileName().toString();
		String appPath = request.getServletContext()
				.getRealPath("C:\\Users\\aaron\\Documents\\GitHub\\GameReviewSite\\GameReviewSite\\WebContent");
		String savePath = appPath + File.separator + "uploadFiles";
		Boolean exists = false;

		for (User u : UserService.getAllUsers()) {
			if (u.getName().equals(user) || u.getEmail().equals(pass)) {
				exists = true;
				break;
			}
		}

		if (!exists) {
			if (!fileName.equals("")) {
				File fileSaveDir = new File(savePath);
				if (!fileSaveDir.exists()) {
					fileSaveDir.mkdir();
				}

				for (Part part : request.getParts()) {
					String name = extractFileName(part);
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

	/**
	 * @param part
	 * @return file name from HTTP header content-disposition
	 */
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("name")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}
