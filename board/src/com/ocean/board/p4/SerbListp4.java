package com.ocean.board.p4;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/p4/bList")
public class SerbListp4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String err = request.getParameter("err");
		if (err != null) {
			switch (err) {
				case "del":
				request.setAttribute("msg", "삭제 실패하였습니다.");
				break;

			}
		}
		
		List<BoardDTOp4> list = BoardDAOp4.selList();
		request.setAttribute("data", list);
		Utils.forward("bList", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
