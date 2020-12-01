package com.ocean.board.p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/p1/BoardReg")
public class BoardRegpSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/practice1/boardReg.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		MainBoardDAO dao = MainBoardDAO.getInstance();
		dao.inBoardList(title, ctnt);
		
		response.sendRedirect("/p1/BoardList");
	}

}
