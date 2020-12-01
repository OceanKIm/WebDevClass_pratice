package com.ocean.board.p2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/p2/bDetail")
public class SerbDetailp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_board = Utils.parsInt(request, "i_board");
		BoardDAOp2.upViews(i_board);
		BoardDTOp2 dto = BoardDAOp2.selBoard(i_board);
		request.setAttribute("data", dto);
		Utils.forward("bDetail", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
