package com.koreait.board4;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.common.SecurityUtils;
import com.koreait.board4.common.Utils;
import com.koreait.board4.db.BoardDAO;
import com.koreait.board4.db.SQLInterUpdate;
import com.koreait.board4.model.BoardPARAM;
import com.koreait.board4.model.BoardSEL;

public class BoardController {
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int typ = Utils.parsInt(request, "typ", 1); // default : 1
		BoardPARAM p = new BoardPARAM();
		p.setTyp(typ);
		request.setAttribute("data", BoardDAO.selBoardList(p));
		request.setAttribute("jsList", new String[] {"board"});
		Utils.forwardTemp("리스트", "temp/basic_temp", "board/bList", request, response);
	}
	
	public void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utils.forwardTemp("글작성", "temp/basic_temp", "board/bRegMod", request, response);
	}
	
	public void regProc(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int typ = Utils.parsInt(request, "typ");	// default : 1
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		String sql = " INSERT INTO t_board (typ, seq, title, ctnt, i_user) " + 
				" SELECT typ, ifnull(max(seq), 0) + 1, ?, ?, ? " + 
				" FROM t_board WHERE typ = ? ";
		
		int result = BoardDAO.executeUpdate(sql, new SQLInterUpdate() {
			@Override
			public void proc(PreparedStatement ps) throws SQLException {
				ps.setNString(1, title);
				ps.setNString(2, ctnt);
				ps.setInt(3, SecurityUtils.getLoginUserPk(request));
				ps.setInt(4, typ);
			}
		});
		if (result == 0) {
			Controller.goToErr(request, response);
		}
		response.sendRedirect("/board/list.korea?typ" + typ);
	}
	
	public void modProc(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_board = Utils.parsInt(request, "i_board");
		
		BoardPARAM p = new BoardPARAM();
		p.setI_board(i_board);
		p.setI_user(SecurityUtils.getLoginUserPk(request));
		
		BoardSEL vo = BoardDAO.selBoard(p);
		if (vo == null) {
			Controller.goToErr(request, response);
		}
		request.setAttribute("data", vo);
		Utils.forwardTemp(vo.getTitle(), "temp/basic_temp", "board/bDetail", request, response);
	}
	
	
	
	
	
	
}























