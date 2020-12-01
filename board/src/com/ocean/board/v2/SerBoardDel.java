package com.ocean.board.v2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/v2/BoardDel")
public class SerBoardDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int i_board = Utils.parsInt(request, "i_board");
		
		BoardDAO2 dao = BoardDAO2.getInstance();
		dao.delBoard(i_board);
		
		response.sendRedirect("/v2/BoardList");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
