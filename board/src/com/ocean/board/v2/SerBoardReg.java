package com.ocean.board.v2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/v2/BoardReg")
public class SerBoardReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 페이지 뿌려주는 것 잊지 말자.... ㅜㅡㅜ
		Utils.forword("boardReg", request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardDAO2 dao = BoardDAO2.getInstance();
		dao.insBoard(title, ctnt);
		
		response.sendRedirect("/v2/BoardList");
	}

}
