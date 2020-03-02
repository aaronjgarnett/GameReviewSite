/*
 * Filename: UtilityConfig.java
 * author: Aaron Garnett
 * date: 3/2/2020 original
 * 
 * */
package com.aaron.config;

import javax.servlet.http.Part;

/**
 * @author aaron
 *
 */
public class UtilityConfig {
	public static final String USER_AARON = "C:\\Users\\aaron\\Documents\\GitHub\\GameReviewSite\\GameReviewSite\\WebContent";
	public static final String USER_CTSTUDENT = "C:\\Users\\CTStudent\\Documents\\GitHub\\GameReviewSite\\GameReviewSite\\WebContent";

	/**
	 * @param part
	 * @return file name from HTTP header content-disposition
	 */
	public static final String EXTRACT_FILENAME(Part part) {
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