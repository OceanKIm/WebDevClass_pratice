package com.ocean.board.p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/p1/BoardDetail")
public class BoardDetailpSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("i_board");
		int i_board = Integer.parseInt(str);
		
		MainBoardDAO dao = MainBoardDAO.getInstance();
		MainBoardDTO dto = dao.selBoardListDTO(i_board);
		
		request.setAttribute("data", dto);
		
		String path = "/WEB-INF/practice1/boardDetail.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
