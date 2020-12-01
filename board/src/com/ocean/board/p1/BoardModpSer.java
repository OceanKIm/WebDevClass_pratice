package com.ocean.board.p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/p1/BoardMod")
public class BoardModpSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String str = request.getParameter("i_board");
		int i_board = Integer.parseInt(str);
		
		MainBoardDAO dao = MainBoardDAO.getInstance();
		MainBoardDTO dto = dao.selBoardListDTO(i_board);
		
		request.setAttribute("data", dto);
		
		String path = "/WEB-INF/practice1/boardMod.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int i_board = Integer.parseInt(request.getParameter("i_board"));
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		MainBoardDAO dao = MainBoardDAO.getInstance();
		dao.upBoardList(i_board, title, ctnt);

		response.sendRedirect("/p1/BoardDetail?i_board=" + i_board);
		
		
	}

}
