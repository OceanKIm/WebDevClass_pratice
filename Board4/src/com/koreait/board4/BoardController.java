package com.koreait.board4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.common.Utils;
import com.koreait.board4.db.BoardDAO;
import com.koreait.board4.model.BoardPARAM;

public class BoardController {
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int typ = Utils.parsInt(request, "typ", 1); // default : 1
		BoardPARAM p = new BoardPARAM();
		p.setTyp(typ);
		request.setAttribute("data", BoardDAO.selBoardList(p));
		Utils.forwardTemp("리스트", "temp/basic_temp", "board/bList", request, response);
	}
	
	public void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utils.forwardTemp("글작성", "temp/basic_temp", "board/bRegMod", request, response);
	}
	
	
	
	
	
	
}
