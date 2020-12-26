package com.koreait.board3.board.cmt;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.koreait.board3.common.SecurityUtils;
import com.koreait.board3.common.Utils;
import com.koreait.board3.db.BoardCmtDAO;
import com.koreait.board3.db.SQLInterUpdate;
import com.koreait.board3.model.BoardCmtSEL;
import com.koreait.board3.model.BoardPARAM;
import com.sun.net.httpserver.HttpContext;

public class BoardCmtService {

	
	public static String reg(HttpServletRequest request) {
		int i_board = Utils.parsInt(request, "i_board");	// 0
		String ctnt = request.getParameter("ctnt");
		String typ = request.getParameter("typ");
		
		if (ctnt.length() < 5) {
			return String.format("/board/detail?typ=%s&i_board=%d&msg=2", typ, i_board);
		}
		
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
	
	public static String regEmp(HttpServletRequest request) {
		int result = 0;
		int action = 0;
		int i_cmt = Utils.parsInt(request, "i_cmt");
		int i_user = SecurityUtils.getLoginUserPk(request);
		String emp = request.getParameter("emp");
		String sql = null;
		
		// 중복 공감 처리
		String empKey = i_user + "_emp_" + i_cmt;
		ServletContext appliction = request.getServletContext();
		String value = (String) appliction.getAttribute(empKey);
		if (!"emp".equals(value) && !"unemp".equals(value)) {
			// 처음 공감 or 비공감
			appliction.setAttribute(empKey, emp);
			sql = " update t_board_cmt "
					+ " set " + emp + " = " + emp + " + 1 "
					+ " where i_cmt = ? ";
			
			System.out.println("처음 공감");
			action = 1;
		} else if (emp.equals("emp") && "unemp".equals(value)) {
			// 비공감 -> 공감
			appliction.removeAttribute(empKey);
			appliction.setAttribute(empKey, emp);
			sql = " update t_board_cmt "
					+ " set emp = emp + 1, unemp = unemp - 1 "
					+ " where i_cmt = ? ";
			System.out.println("비공감 -> 공감");
			action = 2;
		} else if (emp.equals("unemp") && "emp".equals(value)) {
			// 공감 -> 비공감
			appliction.removeAttribute(empKey);
			appliction.setAttribute(empKey, emp);
			sql = " update t_board_cmt "
					+ " set emp = emp - 1, unemp = unemp + 1 "
					+ " where i_cmt = ? ";
			System.out.println("공감 -> 비공감");
			action = 3;
		} else if (emp.equals("emp") && "emp".equals(value)) {
			// 공감 취소.
			appliction.removeAttribute(empKey);
			sql = " update t_board_cmt "
					+ " set emp = emp - 1 "
					+ " where i_cmt = ? ";
			System.out.println("공감 취소");
			action = 4;
		} else if (emp.equals("unemp") && "unemp".equals(value)) {
			// 비공감 취소.
			appliction.removeAttribute(empKey);
			sql = " update t_board_cmt "
					+ " set unemp = unemp - 1 "
					+ " where i_cmt = ? ";
			System.out.println("비공감 취소");
			action = 5;
		}
		
		result = BoardCmtDAO.executeUpdate(sql, new SQLInterUpdate() {
			@Override
			public void proc(PreparedStatement ps) throws SQLException {
				ps.setInt(1, i_cmt);
			}
		});
		
		// emp and unemp 값 가져오기
		BoardCmtSEL vo = BoardCmtDAO.selEmpUnemp(i_cmt);
		//System.out.println("emp : " + vo.getEmp());
		//System.out.println("unemp : " + vo.getUnemp());
		
		System.out.println("result : " + result);
		return String.format("{\"result\":%d, \"action\":%d, \"e\":%d, \"une\":%d}",
				result, action, vo.getEmp(), vo.getUnemp());
	}
	
	public static List<BoardCmtSEL> selBoardCmtList(BoardPARAM p) {
		return BoardCmtDAO.selCmtList(p);
	}

	public static String mod(HttpServletRequest request) {
		String typ = request.getParameter("typ");
		String i_board = request.getParameter("i_board");
		String i_cmt = request.getParameter("i_cmt");
		String ctnt = request.getParameter("ctnt");
		
		String sql = " update t_board_cmt "
				+ " set ctnt = ? "
				+ " where i_cmt = ? and i_user = ? ";
		
		int result = BoardCmtDAO.executeUpdate(sql, new SQLInterUpdate() {
			@Override
			public void proc(PreparedStatement ps) throws SQLException {
				ps.setNString(1, ctnt);
				ps.setNString(2, i_cmt);
				ps.setInt(3, SecurityUtils.getLoginUserPk(request));
			}
		});
		String url = String.format("../detail?typ=%s&i_board=%s", typ, i_board);
		if (result == 0) url += "&err=1";
		return url;
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























