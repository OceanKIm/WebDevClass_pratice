package com.ocean.board.p2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/p2/bRegMod")
public class SerbRegModp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i_board;
	int result;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		i_board = Utils.parsInt(request, "i_board");
		if (i_board > 0) {
			BoardDTOp2 dto = BoardDAOp2.selBoard(i_board);
			request.setAttribute("data", dto);
		} 
		Utils.forward("bRegMod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		i_board = Utils.parsInt(request, "i_board");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		if (i_board > 0) {
			BoardDAOp2.upBoard(i_board, title, ctnt);
		} else {
			result = BoardDAOp2.insBoard(title, ctnt);
		}
		response.sendRedirect("/p2/bList");
	}
}
