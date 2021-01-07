package com.koreait.board4.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Utils {
	
	public static void forwardTemp(String title, String openPage, String innerPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("page", String.format("/WEB-INF/view/%s.jsp", innerPage));
		forward(title, openPage, request, response);
		
	}
	
	public static void forward(String title, String openPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("title", title);
		String path = String.format("/WEB-INF/view/%s.jsp", openPage);
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	public static int parsInt(HttpServletRequest request, String key) {
		String str = request.getParameter(key);
		return parsStrToInt(str);
	}
	
	public static int parsInt(HttpServletRequest request, String key, int defVal) {
		String str = request.getParameter(key);
		return parsStrToInt(str, defVal);
	}
	
	public static int parsStrToInt(String str) {
		return parsStrToInt(str, 0);
	}
	
	public static int parsStrToInt(String str, int defVal) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println(e); 
		}
		return defVal;
	}
	
	

}
