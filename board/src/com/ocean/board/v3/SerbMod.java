package com.ocean.board.v3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/v3/bMod")
public class SerbMod extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardDAO3 dao = BoardDAO3.getInstance();
	int i_board;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		i_board = Utils.parsInt(request, "i_board");
		
		BoardDTO3 dto = dao.selDTO(i_board);
		request.setAttribute("data", dto);
		Utils.forward("bMod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		i_board = Utils.parsInt(request, "i_board");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		dao.upDTO(i_board, title, ctnt);
				
		response.sendRedirect("/v3/bDetail?i_board=" + i_board);
	}
}
