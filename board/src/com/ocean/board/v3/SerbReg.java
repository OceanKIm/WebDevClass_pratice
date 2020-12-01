package com.ocean.board.v3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/v3/bReg")
public class SerbReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utils.forward("bReg", request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardDAO3 dao = BoardDAO3.getInstance();
		dao.insDTO(title, ctnt);
		
		response.sendRedirect("/v3/bList");
	}

}
