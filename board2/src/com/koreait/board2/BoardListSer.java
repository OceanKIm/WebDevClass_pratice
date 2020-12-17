package com.koreait.board2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board2.common.Paging;
import com.koreait.board2.common.Utils;
import com.koreait.board2.db.BoardDAO;
import com.koreait.board2.model.BoardVO;


@WebServlet("/bList")
public class BoardListSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int setPageMove = 5;
	int pageBegin = 1;
	int pageEnd = 0;
	int pageCnt = setPageMove;   
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String msg = request.getParameter("msg");
		if (msg != null) {
			switch(msg) {
			case "del":
				request.setAttribute("msg", "삭제실패하였습니다.");
				break;
			case "login":
				request.setAttribute("msg", "로그인에 성공했습니다!");
				break;
			}
		}
		int typ = Utils.parsInt(request, "typ", 1);	// default 값 역시 1.
		int page = Utils.parsInt(request, "page", 1);	// 1
		BoardVO param = new BoardVO();
		param.setTyp(typ);
		param.setGetRowCntPerPage(5);;	// 페이지 갯수 설정

	
		String move = request.getParameter("pageMove");
		Paging pg = Paging.getInstance(BoardService.selPageCnt(param), 5);
		pg.pageMoving(move);
		
		request.setAttribute("pageBegin", pg.begin());
		request.setAttribute("pageEnd", pg.end());
		request.setAttribute("boundary", pg.boundary());
		request.setAttribute("typ", typ);
		request.setAttribute("data", BoardService.selBoardList(param, page));
		Utils.forward("리스트", "bList", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
