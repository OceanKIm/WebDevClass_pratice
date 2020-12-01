package com.ocean.board;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.security.jca.GetInstance;


@WebServlet("/BoardReg")
public class BoardRegSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "/WEB-INF/jsp/boardReg.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		Calendar cal = Calendar.getInstance();
		
		int i_borad = Integer.parseInt(request.getParameter("i_board"));
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		String date = (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH);  		
	
		BoardVO vo = new BoardVO(i_borad, title, ctnt, date, date);
		BoardDAO dao = BoardDAO.getInstance();
		dao.insBoard(vo);
				
		response.sendRedirect("/BoardList");
	}

}
