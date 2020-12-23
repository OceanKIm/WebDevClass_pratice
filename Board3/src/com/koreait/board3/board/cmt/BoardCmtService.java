package com.koreait.board3.board.cmt;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.koreait.board3.common.SecurityUtils;
import com.koreait.board3.common.Utils;
import com.koreait.board3.db.BoardCmtDAO;
import com.koreait.board3.db.SQLInterUpdate;
import com.koreait.board3.model.BoardCmtSEL;
import com.koreait.board3.model.BoardPARAM;

public class BoardCmtService {

	public static List<BoardCmtSEL> selBoardCmtList(BoardPARAM p) {
		return BoardCmtDAO.selCmtList(p);
	}
	
	public static String regCmt(HttpServletRequest request) {
		int i_board = Utils.parsInt(request, "i_board");	// 0
		String ctnt = request.getParameter("ctnt");
		String typ = request.getParameter("typ");
		
		int result;
		
		String sql = " insert into t_board_cmt (seq, ctnt, i_board, i_user) "
				+ " select ifnull(max(seq), 0) + 1, ?, ?, ? "
				+ " from t_board_cmt where i_board = ?";
		
		result = BoardCmtDAO.executeUpdate(sql, new SQLInterUpdate() {
			@Override
			public void proc(PreparedStatement ps) throws SQLException {
				ps.setNString(1, ctnt);
				ps.setInt(2, i_board);
				ps.setInt(3, SecurityUtils.getLoginUserPk(request));
				ps.setInt(4, i_board);
			}
		});
		
		if (result == 0) return "err";
		return String.format("/board/detail?typ=%s&i_board=%d", typ, i_board);
	}

	public static String del(HttpServletRequest request) {
		String i_board = request.getParameter("i_board");
		String typ = request.getParameter("typ");
		String i_cmt = request.getParameter("i_cmt");
		
		String sql = " delete from t_board_cmt "
				+ " where i_cmt = ? and i_user = ? ";
		
		int result = BoardCmtDAO.executeUpdate(sql, new SQLInterUpdate() {
			@Override
			public void proc(PreparedStatement ps) throws SQLException {
				ps.setString(1, i_cmt);
				ps.setInt(2, SecurityUtils.getLoginUserPk(request));
			}
		});
		String url = String.format("../detail?i_board=%s&typ=%s", i_board, typ);
		if (result == 0) return url += "&msg=1";
		return url;
	}
	
	
	
	
	
}























