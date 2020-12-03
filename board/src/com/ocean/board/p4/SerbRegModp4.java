package com.ocean.board.p4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/p4/bRegMod")
public class SerbRegModp4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int result; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_board = Utils.parsInt(request, "i_board");
		if (i_board > 0) {
			BoardDTOp4 dto = BoardDAOp4.selBoard(i_board);
			request.setAttribute("data", dto);
		} else {
			int num = BoardDAOp4.regI_board();
			request.setAttribute("num", num);
		}
		
		Utils.forward("bRegMod", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_board = Utils.parsInt(request, "i_board");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		BoardDTOp4 dto = new BoardDTOp4();
		dto.setI_board(i_board);
		dto.setTitle(title);
		dto.setCtnt(ctnt);
		
		if (i_board > 0 ) {
			result = BoardDAOp4.upBoard(dto);
			if (result == 0) {
				request.setAttribute("msg", "수정을 실패하였습니다.");
				request.setAttribute("data", dto);
				Utils.forward("bRegMod", request, response);
				return;
			}
			response.sendRedirect("/p4/bDetail?i_board=" + i_board);
			return;
		}
		result = BoardDAOp4.insboard(dto);
		if (result == 0) {
			request.setAttribute("msg", "등록에 실패하였습니다.");
			doGet(request, response);
			return;
		}
		response.sendRedirect("/p4/bList");
	}

}
