package com.ocean.board.p1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// servelet 주소에 경로에 path 경로를 붙여버리는 오류...
@WebServlet("/p1/BoardList")
public class BoardListpSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("open page");
		
		MainBoardDAO dao = MainBoardDAO.getInstance();
		List<MainBoardDTO> list = dao.selBoardList();
		request.setAttribute("data", list);
		

		String path = "/WEB-INF/practice1/boardList.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
