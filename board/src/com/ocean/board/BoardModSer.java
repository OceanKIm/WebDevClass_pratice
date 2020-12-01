package com.ocean.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardMod")
public class BoardModSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_board = Integer.parseInt(request.getParameter("i_board"));
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.selBoard(i_board);
		
		request.setAttribute("data", vo);
		String path = "WEB-INF/jsp/boardMod.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int i_board = Integer.parseInt(request.getParameter("i_board"));
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.upBoard(i_board, title, ctnt);

		response.sendRedirect("/BoardDetail?i_board=" + i_board);
	}

}
