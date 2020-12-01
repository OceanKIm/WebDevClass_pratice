package com.ocean.board.p2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class BoardDAOp2 {
	
	public static int insBoard(String title, String ctnt) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " insert into board_p(title, ctnt)" + 
					"values(?,?)";
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
	
	
	public static List<BoardDTOp2> selBoardList() {
		List<BoardDTOp2> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select * from board_p order by i_board ";

		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int i_board = rs.getInt("i_board");
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String r_dt = rs.getString("r_dt");
				int views = rs.getInt("views");
				BoardDTOp2 dto = new BoardDTOp2(i_board, title, ctnt, r_dt,views);
				list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return list;
	}
	
	public static BoardDTOp2 selBoard(int i_board) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardDTOp2 dto = new BoardDTOp2();
		
		String sql = " select * from board_p where i_board = " + i_board;
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto.setI_board(rs.getInt("i_board"));
				dto.setTitle(rs.getString("title"));
				dto.setCtnt(rs.getString("ctnt"));
				dto.setR_dt(rs.getString("r_dt"));
				dto.setViews(rs.getInt("views"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
		return dto;
	}
	
	public static void upViews(int i_board) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int views = 0;
		String sql1 = " select views from board_p where i_board = " + i_board;
		String sql2 = " update board_p set views = ? where i_board = " + i_board;
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			if (rs.next()) {
				views = rs.getInt("views");
			}
			ps.close(); // 닫고 재 참조
			ps = con.prepareStatement(sql2);
			ps.setInt(1, views + 1);	// 조회수 올리기.
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
	}
	
	public static void delBoard(int i_board) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " delete from board_p where i_board = " + i_board;
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
	}
	
	public static void upBoard(int i_board, String title, String ctnt) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " update board_p " +
					"set title = ? , ctnt = ? " + 
					"where i_board = " + i_board;
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, title);
			ps.setNString(2, ctnt);	
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
	}
}









