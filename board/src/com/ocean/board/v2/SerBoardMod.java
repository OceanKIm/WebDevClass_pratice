package com.ocean.board.v2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/v2/BoardMod")
public class SerBoardMod extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardDAO2 dao = BoardDAO2.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_board = Utils.parsInt(request, "i_board");
		
		BoardDTO dto = dao.selBoardDTO(i_board);
		
		request.setAttribute("data", dto);
		Utils.forword("boardMod", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_board = Utils.parsInt(request, "i_board");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		dao.upBoard(i_board, title, ctnt);
		response.sendRedirect("/v2/BoardDetail?i_board=" + i_board);
	}

}
