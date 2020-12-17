package com.koreait.board2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board2.common.Utils;
import com.koreait.board2.model.BoardCmtVO;
import com.koreait.board2.model.BoardVO;


@WebServlet("/bDetail")
public class BoardDetailSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int typ = Utils.parsInt(request, "typ"); 	// 0
		int i_board = Utils.parsInt(request, "i_board");	// 0
		int err = Utils.parsInt(request, "err");
		int showCmt = Utils.parsInt(request, "showCmt", 10);	// default 10
		if (err > 0) {
			switch (err) {
			case 1:
				request.setAttribute("msg", "댓글 쓰기 실패");
				break;
			case 2:
				request.setAttribute("msg", "이미 공감/비공감 하셨습니다.");
				break;	
			}
		}
		if (typ == 0 || i_board == 0) {
			Utils.forward("에러", "err", request, response);
			return;
		}
		
		BoardVO param = new BoardVO();
		param.setI_board(i_board);
		param.setTyp(typ);
		
		List<BoardCmtVO> list = BoardService.selBoardCmtList(param, showCmt);
		BoardVO vo = BoardService.detail(param, request);
		
		request.setAttribute("cmtList", list);
		request.setAttribute("data", vo);
		request.setAttribute("showCmt", showCmt);
		Utils.forward("디테일", "bDetail", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("del !!!!!");
		
		int typ = Utils.parsInt(request, "typ");	// 0 
		int i_board = Utils.parsInt(request, "i_board");	// 0
		
		BoardVO param = new BoardVO();
		param.setTyp(typ);
		param.setI_board(i_board);
		
		if (BoardService.delBoard(param) == 0) {
			System.out.println("del err!!!");
			request.setAttribute("err", "삭제 할 수 없습니다.");
			doGet(request, response);
			//response.sendRedirect("/bList?typ=" + typ + "&err=del");
			return;
		}
		response.sendRedirect("/bList?typ=" + typ);
	}

}

















