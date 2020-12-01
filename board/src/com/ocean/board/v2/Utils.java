package com.ocean.board.v2;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Utils {
	
	static Calendar cal = Calendar.getInstance();
	
	static public void forword(String target, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/jsp2/" + target + ".jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	public static int parsInt(HttpServletRequest request, String key) {
		String data = request.getParameter(key);
		return parsIntSub(data);
	}
	
	// 우아한 에러처리 방식
	public static int parsIntSub(String data) {
		try {
			return Integer.parseInt(data);
		} catch (NumberFormatException e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public static String setData() {
		return (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH);
	}
	

}
