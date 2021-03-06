package com.koreait.board3.board.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board3.board.BoardService;
import com.koreait.board3.common.SecurityUtils;
import com.koreait.board3.common.Utils;

@WebServlet("/board/cmt/reg")
public class BoardCmtRegSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (!SecurityUtils.isLogin(request)) {
			response.sendRedirect("/login");
			return;
		}
		// 댓글 공감처리. 
		//int i_cmt = Utils.parsInt(request, "i_cmt");
		//System.out.println("i_cmt : " + i_cmt);
		
		response.setContentType("appliction/json");
		response.setCharacterEncoding("UTF-8");
		// ajax통신 반환. json을 던져 줌
		response.getWriter().write(BoardCmtService.regEmp(request));
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(BoardCmtService.reg(request));
		
	}

}
