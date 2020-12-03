package com.ocean.board.p3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOp3 {
	
	public static int insBoard(String title, String ctnt) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " insert into board_p (title, ctnt) " + 
					" values ( ?, ? )";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, title);
			ps.setNString(2, ctnt);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
		return result;
	}
	
	public static List<BoardDTOp3> selBoardList() {
		List<BoardDTOp3> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select * from board_p order by i_board ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int i_board = rs.getInt("i_board");
				String title = rs.getNString("title");
				String ctnt = rs.getNString("ctnt");
				String r_dt = rs.getString("r_dt");
				int views = rs.getInt("views");
				BoardDTOp3 dto = new BoardDTOp3(i_board, title, ctnt, r_dt, views);
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return list;
	}
	
	public static int upBoard(int i_board, String title, String ctnt) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " update board_p " + 
					" set title = ? , ctnt = ? " + 
					" where i_board = ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, title);
			ps.setNString(2, ctnt);
			result = ps.executeUpdate();
		} catch (Exception e) { 
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
		return result;
	}
	
	public static BoardDTOp3 selBoardDTO(int i_board) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardDTOp3 dto = null;
		
		String sql = String.format(" select * from board_p where i_board = '%d' ", i_board);

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				String title = rs.getNString("title");
				String ctnt = rs.getNString("ctnt");
				String r_dt = rs.getString("r_dt");
				int views = rs.getInt("views");
				dto = new BoardDTOp3(i_board, title, ctnt, r_dt, views);
			}
		} catch (Exception e) {
			System.out.println();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return dto;
	}
	
	public static void upViews(int i_board) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int views = 0;
		String sql1 = String.format(" select views from board_p where i_board = '%d' ", i_board);
		String sql2 = " update board_p set views = ? where i_board = " + i_board;
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			if(rs.next()) {
				views = rs.getInt("views");
			}
			ps.close();
			ps = con.prepareStatement(sql2);
			ps.setInt(1, views + 1);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps, rs);
		}
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
	

}




























































