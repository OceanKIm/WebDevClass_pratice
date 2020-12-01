package com.ocean.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardDetail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// getParmeter -> 쿼리스트링 값 받아오기!
		String strI_board = request.getParameter("i_board");
		//String name = request.getParameter("name");
		if (strI_board == null) {
			System.out.println("요청한 데이터를 받지 못하였습니다.");
		}
		
		System.out.println("i_board = " + strI_board);
		//System.out.println("name = " + name);
		
		// DB통신
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO data = dao.selBoard(Integer.parseInt(strI_board));
		request.setAttribute("data", data);
		
		
		
		String path = "/WEB-INF/jsp/boardDetail2.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
