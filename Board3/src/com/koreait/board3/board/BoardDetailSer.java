package com.koreait.board3.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board3.board.cmt.BoardCmtService;
import com.koreait.board3.common.SecurityUtils;
import com.koreait.board3.common.Utils;
import com.koreait.board3.model.BoardSEL;


@WebServlet("/board/detail")
public class BoardDetailSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (!SecurityUtils.isLogin(request)) {
			response.sendRedirect("/login");
			return;
		}
		int msg = Utils.parsInt(request, "msg");	// 0
		switch (msg) {
		case 1:
			request.setAttribute("msg", "알 수 없는 에러가 발생하였습니다.");
			break;
		}
		BoardSEL vo = BoardService.detail(request);
		request.setAttribute("jsList", new String[]{"board"});
		Utils.forwardTemp(vo.getTitle(), "temp/basic_temp", "board/bDetail", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
