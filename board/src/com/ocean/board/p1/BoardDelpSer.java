package com.ocean.board.p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/p1/BoardDel")
public class BoardDelpSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("i_board");
		int i_board = Integer.parseInt(str);
		MainBoardDAO dao = MainBoardDAO.getInstance();
		dao.delBoardList(i_board);
		
		response.sendRedirect("/p1/BoardList");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
