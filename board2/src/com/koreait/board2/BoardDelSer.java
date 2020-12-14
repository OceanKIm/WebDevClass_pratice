package com.koreait.board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board2.common.Utils;
import com.koreait.board2.model.BoardVO;

// 사용 안함.
@WebServlet("/bDel")
public class BoardDelSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int typ = Utils.parsInt(request, "typ");	// 0	
		if (typ == 0) {
			Utils.forward("에러", "err", request, response);
			return;
		}
		int i_board = Utils.parsInt(request, "i_board"); 	// 0
		BoardVO param = new BoardVO();
		param.setTyp(typ);
		param.setI_board(i_board);
		
		if (BoardService.delBoard(param) == 0) {
			System.out.println("삭제 에러!!");
			response.sendRedirect("/bList?typ=" + typ + "&msg=del");
			return;
		}
		
		response.sendRedirect("/bList?typ=" + typ);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
