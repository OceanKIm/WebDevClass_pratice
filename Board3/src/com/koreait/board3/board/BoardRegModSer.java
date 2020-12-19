package com.koreait.board3.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board3.common.SecurityUtils;
import com.koreait.board3.common.Utils;

@WebServlet("/board/regmod")
public class BoardRegModSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (!SecurityUtils.isLogin(request)) {
			response.sendRedirect("/login");
			return;
		}
		
		// 연습 (내용삽입)
		BoardService.detail(request);
		
		request.setAttribute("jsList", new String[]{"board"});
		Utils.forwardTemp("등록/수정(로직처리예정)", "temp/basic_temp", "board/bRegMod", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String typ = request.getParameter("typ");
		int i_board = Utils.parsInt(request, "i_board");
		
		// 반환형이 int임
		int result = BoardService.regmod(request);
		if (result == 0) {
			response.sendRedirect("list?typ=" + typ);
			return;
		}
		response.sendRedirect("detail?typ=" + typ + "&i_board=" + i_board);
	}

}
