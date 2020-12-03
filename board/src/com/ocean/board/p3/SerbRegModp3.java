package com.ocean.board.p3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/p3/bRegMod")
public class SerbRegModp3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int result;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_board = Utils.parsInt(request, "i_board");
		if (i_board > 0 ) {
			BoardDTOp3 dto = BoardDAOp3.selBoardDTO(i_board);
			request.setAttribute("data", dto);
		}
		Utils.forward("bRegMod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int i_board = Utils.parsInt(request, "i_board");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		if (i_board > 0) {
			result = BoardDAOp3.upBoard(i_board, title, ctnt);
			if (result == 0) {
				request.setAttribute("msg", "수정 실패하였습니다.");
				doGet(request, response);
				return;
			}
			response.sendRedirect("/p3/bDetail?i_board=" + i_board);
			return;
		} 
		result = BoardDAOp3.insBoard(title, ctnt);
		if (result == 0) {
			request.setAttribute("msg", "등록 실패하였습니다.");
			doGet(request, response);
			return;
		}
		response.sendRedirect("/p3/bList");
		
	}

}
