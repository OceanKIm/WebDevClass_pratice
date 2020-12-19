package com.koreait.board3.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board3.common.SecurityUtils;
import com.koreait.board3.common.Utils;

@WebServlet("/board/del")
public class BoardDelSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String typ = request.getParameter("typ");
		
		if (!SecurityUtils.isLogin(request)) {
			response.sendRedirect("/login");
			return;
		}
	
		BoardService.del(request);
		response.sendRedirect("list?typ=" + typ);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
