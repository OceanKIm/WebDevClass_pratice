package com.ocean.board.v3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Utils {
	
	public static void forward(String file, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = String.format("/WEB-INF/jsp3/%s.jsp", file);
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	public static int parsInt(HttpServletRequest request, String key) {
		String str = request.getParameter(key);
		return parsIntSub(str);
	}
	
	public static int parsIntSub(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println(e);
			return 0;
		}
	}
	
	

}
