package com.ocean.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 기본 생성자.
    public index() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 제일 간단한 방식
		//request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		
		// 정통적인 방식
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
//		rd.forward(request, response);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.append("<html>")
		.append("<body>")
		.append("<h1>Hello World!!!</h1>")
		.append("<div><a href=\"http://www.naver.com\">go to naver</a></div>")
		.append("</body>")
		.append("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
