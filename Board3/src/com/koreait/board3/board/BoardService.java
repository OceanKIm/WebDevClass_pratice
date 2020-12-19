package com.koreait.board3.board;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.koreait.board3.common.SecurityUtils;
import com.koreait.board3.common.Utils;
import com.koreait.board3.db.CommonDAO;
import com.koreait.board3.db.SQLInterUpdate;
import com.koreait.board3.model.BoardPARAM;
import com.koreait.board3.model.BoardSEL;
import com.koreait.board3.model.UserModel;

public class BoardService {
	
	public static void detail(HttpServletRequest request) {
		int i_board = Utils.parsInt(request, "i_board");
		BoardPARAM p = new BoardPARAM();
		p.setI_board(i_board);
		
		// 연습 조회수 처리. - 조회수 중복 처리, 아이디별로 application에서 중복처리.
		ServletContext appliction = request.getServletContext();
		String userId = SecurityUtils.getLoginUser(request).getUser_id();
		String savedUerHits = (String) appliction.getAttribute(userId);
		
		if (!String.valueOf(i_board).equals(savedUerHits)) {
			System.out.println("조회수 up!");
			appliction.setAttribute(userId, String.valueOf(i_board));
			addHits(p);
		}
		
		BoardSEL vo = BoardDAO.selBoard(p);
		if (vo == null) {
			// 에러 처리;
		}
	
		request.setAttribute("data", vo);
	}
	
	public static void selBoardList(HttpServletRequest request) {
		int typ = Utils.parsInt(request, "typ");	// 0
		// 연습 - 페이징
		int page = Utils.parsInt(request, "page", 1);
		
		BoardPARAM p = new BoardPARAM();
		p.setTyp(typ);
		p.setGetRowCntPerPage(5); // 연습 - 페이징
		p.setS_IDx((page - 1) * p.getGetRowCntPerPage()); // 연습 - 페이징
		System.out.println("sidx = " + p.getS_IDx());
		
		// 연습
		request.setAttribute("pageCnt", BoardDAO.selPageCnt(p));
		request.setAttribute("data", BoardDAO.selBoardList(p));
	}

	public static int regmod(HttpServletRequest request) {
		int i_board = Utils.parsInt(request, "i_board");
		int typ = Utils.parsInt(request, "typ");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		// 나중에 시큐리티 pk에서 받기. 일단 되는지 확인.
		HttpSession hs = request.getSession();
		UserModel vo = (UserModel) hs.getAttribute("loginUser");
		
		if (i_board == 0) {	// 글등록.
			String sql = " insert into t_board (typ, seq, title, ctnt, i_user) "
					+ " select ?, ifnull(max(seq),0) + 1, ?, ?, ? from t_board ";

			CommonDAO.executeUpdate(sql, new SQLInterUpdate() {
				
				@Override
				public void proc(PreparedStatement ps) throws SQLException {
					ps.setInt(1, typ);
					ps.setNString(2, title);
					ps.setNString(3, ctnt);
					ps.setInt(4, vo.getI_user());
				}
			});			
			return 0; 	// 리스트로 이동
		} else {	// 글수정 (연습)
			String sql = " update t_board "
					+ " set title = ?, ctnt = ?, m_dt = now() "
					+ " where i_board = ? ";
			CommonDAO.executeUpdate(sql, new SQLInterUpdate() {
				@Override
				public void proc(PreparedStatement ps) throws SQLException {
					ps.setNString(1, title);
					ps.setNString(2, ctnt);
					ps.setInt(3, i_board);	
				}
			});	
			return 1; // 디테일로 이동
		}
	}
	
	public static void del(HttpServletRequest request) {
		int i_board = Utils.parsInt(request, "i_board");

		String sql = " delete from t_board where i_board = ? and i_user = ?";
	
		CommonDAO.executeUpdate(sql, new SQLInterUpdate() {
			@Override
			public void proc(PreparedStatement ps) throws SQLException {
				ps.setInt(1, i_board);
				ps.setInt(2, SecurityUtils.getLoginUserPk(request));
			}
		});
		
	}
	
	// 연습 조회수 처리
	public static void addHits(BoardPARAM p) {
		String sql = " update t_board "
				+ " set hits = hits + 1 "
				+ " where i_board = ? ";
		CommonDAO.executeUpdate(sql, new SQLInterUpdate() {
			@Override
			public void proc(PreparedStatement ps) throws SQLException {
				ps.setInt(1, p.getI_board());
			}
		});
	}
	

	
}

















