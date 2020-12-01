package com.ocean.board.p2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/p2/bList")
public class SerbListp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BoardDTOp2> list = BoardDAOp2.selBoardList();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		request.setAttribute("data", list);
		Utils.forward("bList", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
