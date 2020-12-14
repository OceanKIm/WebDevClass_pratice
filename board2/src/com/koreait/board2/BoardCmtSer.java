package com.koreait.board2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board2.common.Utils;
import com.koreait.board2.model.BoardCmtVO;


@WebServlet("/cmt")
public class BoardCmtSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String err = "";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int typ = Utils.parsInt(request, "typ");	// 0
		int i_board = Utils.parsInt(request, "i_board");	// 0
		int i_cmt = Utils.parsInt(request, "i_cmt");
		String emp = request.getParameter("emp");
		BoardCmtVO param = new BoardCmtVO();
		param.setTyp(typ);
		param.setI_cmt(i_cmt);
		switch (emp) {
		case "yes":	// 공감.
			param.setEmp(1);
			break;
		case "no":	// 비공감.
			param.setUnemp(1);
			break;
		}
		err = "";
		if (BoardService.empOrUnemp(param, request) == 0) {
			err = "&err=2";
		}
		response.sendRedirect("/bDetail?typ=" + typ + "&i_board=" + i_board + err);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int typ = Utils.parsInt(request, "typ");	// 0
		int i_board = Utils.parsInt(request, "i_board");	// 0
		String cmt_ctnt = request.getParameter("cmt_ctnt");
		
		BoardCmtVO param = new BoardCmtVO();
		param.setTyp(typ);
		param.setI_board(i_board);
		param.setCtnt(cmt_ctnt);

		err = "";
		if (BoardService.cmtIns(param) == 0) {
			err = "&err=1";
		}
		response.sendRedirect("/bDetail?typ=" + typ + "&i_board=" + i_board + err);
	}

}
