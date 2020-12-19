package com.koreait.board3.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board3.db.DbUtils;
import com.koreait.board3.model.BoardPARAM;
import com.koreait.board3.model.BoardSEL;

public class BoardDAO {
	
	public static int selPageCnt(BoardPARAM p) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select ceil(count(*) / ?) cnt from t_board "
				+ " where typ = ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getGetRowCntPerPage());
			ps.setInt(2, p.getTyp());
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt"); 
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return 0;
	}
	
	public static BoardSEL selBoard(BoardPARAM p) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardSEL vo = null;
		
		String sql = " select A.i_board, A.i_user, A.seq, A.title, A.ctnt, A.r_dt, A.m_dt, B.nm, A.hits "
				+ " from t_board A, t_user B where A.i_user = B.i_user "
				+ " and A.i_board = ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getI_board());
			rs = ps.executeQuery();
			if (rs.next()) {
				vo = new BoardSEL();
				vo.setI_board(rs.getInt("i_board"));
				vo.setI_user(rs.getInt("i_user"));
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getNString("title"));
				vo.setCtnt(rs.getNString("ctnt"));
				vo.setR_dt(rs.getString("r_dt"));
				vo.setM_dt(rs.getString("m_dt"));
				vo.setNm(rs.getNString("nm"));
				vo.setHits(rs.getInt("hits"));
				return vo;
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return vo;
	}
	
	// 페이징 - 연습
	public static List<BoardSEL> selBoardList(BoardPARAM p) {
		List<BoardSEL> list = new ArrayList<BoardSEL>();
		BoardSEL vo = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select A.i_board, A.seq, A.title, A.r_dt, A.m_dt, B.nm, A.hits " +
				" from t_board A, t_user B " +
				" where A.i_user = B.i_user and A.typ = ? " +
				" order by seq desc " +
				" limit ?, ? ";
	
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getTyp());
			ps.setInt(2, p.getS_IDx());
			ps.setInt(3, p.getGetRowCntPerPage());
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new BoardSEL();
				vo.setI_board(rs.getInt("i_board"));
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getNString("title"));
				vo.setR_dt(rs.getString("r_dt"));
				vo.setM_dt(rs.getString("m_dt"));
				vo.setNm(rs.getNString("nm"));
				vo.setHits(rs.getInt("hits"));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return list;
	}

}
