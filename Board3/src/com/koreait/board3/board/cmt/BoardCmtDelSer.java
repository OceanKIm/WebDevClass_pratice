package com.koreait.board3.board.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board3.common.SecurityUtils;

@WebServlet("/board/cmt/del")
public class BoardCmtDelSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (!SecurityUtils.isLogin(request)) {
			response.sendRedirect("/login");
			return;
		}
		
		response.sendRedirect(BoardCmtService.del(request));
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
