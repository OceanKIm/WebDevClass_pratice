package com.ocean.board.p4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOp4 {
	
	public static int insboard(BoardDTOp4 dto) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " insert into board_p (title, ctnt) " +
					" values (?, ?) ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, dto.getTitle());
			ps.setNString(2, dto.getCtnt());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
		return result;
	}
	
	public static List<BoardDTOp4> selList() {
		List<BoardDTOp4> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardDTOp4 dto = null;
		
		String sql = " select * from board_p order by i_board ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int i_board = rs.getInt("i_board");
				String title = rs.getNString("title");
				String ctnt = rs.getNString("ctnt");
				String r_dt = rs.getString("r_dt");
				int views = rs.getInt("views");
				dto = new BoardDTOp4(i_board, title, ctnt, r_dt, views);
				list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return list;
	}
	
	public static BoardDTOp4 selBoard(int i_board) {
		BoardDTOp4 dto = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select * from board_p where i_board = " + i_board;
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String title = rs.getNString("title");
				String ctnt = rs.getNString("ctnt");
				String r_dt = rs.getString("r_dt");
				int views = rs.getInt("views");
				dto = new BoardDTOp4(i_board, title, ctnt, r_dt, views);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return dto;
	}
	
	public static int delBoard(int i_board) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " delete from board_p where i_board = " + i_board;
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
		return result;
	}
	
	public static int upViews(int i_board) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " update board_p set views = views + 1 where " + i_board;
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
		return result;
	}
	
	public static int upBoard(BoardDTOp4 dto) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " update board_p " + 
					" set title = ?, ctnt = ? " + 
					" where i_board = ? ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, dto.getTitle());
			ps.setNString(2, dto.getCtnt());
			ps.setInt(3, dto.getI_board());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
		return result;
	}
	
	public static int regI_board() {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select max(i_board) FROM board_p ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt("max(i_board)") + 1;
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return result;
	}
	
	
}















