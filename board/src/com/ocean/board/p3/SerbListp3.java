package com.ocean.board.p3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/p3/bList")
public class SerbListp3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String err = request.getParameter("err");
		if (err != null) {
			switch(err) {
				case "del":
				request.setAttribute("msg", "삭제 실패하였습니다.");
				break;
			}
		}
		List<BoardDTOp3> list = BoardDAOp3.selBoardList();
		request.setAttribute("data", list);
		Utils.forward("bList", request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
