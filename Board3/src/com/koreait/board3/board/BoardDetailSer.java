package com.koreait.board3.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board3.common.SecurityUtils;
import com.koreait.board3.common.Utils;


@WebServlet("/board/detail")
public class BoardDetailSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (!SecurityUtils.isLogin(request)) {
			response.sendRedirect("/login");
			return;
		}
		
		BoardService.detail(request);
		
		request.setAttribute("jsList", new String[]{"board"});
		Utils.forwardTemp("디테일", "temp/basic_temp", "board/bDetail", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
