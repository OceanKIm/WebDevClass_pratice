package com.koreait.board2.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board2.model.BoardCmtVO;
import com.koreait.board2.model.BoardVO;

public class BoardDAO {

	// 페이징 갯수 리턴
	public static int selPageCnt(final BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select ceil(count(*) / ?) cnt from t_board_? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getGetRowCntPerPage());
			ps.setInt(2, param.getTyp());
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}
	
	public static int insBoard(final BoardVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " insert into t_board_? (title, ctnt) " +
					" values (?,?) ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, param.getTyp());
			ps.setNString(2, param.getTitle());
			ps.setNString(3, param.getCtnt());
			result = ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				param.setI_board(rs.getInt(1));	// param에 값 재 설정.
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
		return result;
	}
	
	
	public static List<BoardVO> selBoardList(final BoardVO param) {
		List<BoardVO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;
		
		String sql = " select i_board, title, r_dt, m_dt, views " + 
					" from t_board_? order by i_board desc " + 
				    " limit ?, ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getTyp());
			ps.setInt(2, param.getS_IDx());
			ps.setInt(3, param.getGetRowCntPerPage());
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new BoardVO();
				vo.setI_board(rs.getInt("i_board"));
				vo.setTitle(rs.getNString("title"));
				vo.setR_dt(rs.getString("r_dt"));
				vo.setM_dt(rs.getString("m_dt"));
				vo.setViews(rs.getInt("views"));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return list;
	}
	
	public static BoardVO selBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;
		
		String sql = " select * from t_board_? where i_board = ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getTyp());
			ps.setInt(2, param.getI_board());
			rs = ps.executeQuery();
			if (rs.next()) {
				vo = new BoardVO();
				vo.setI_board(rs.getInt("i_board"));
				vo.setTitle(rs.getNString("title"));
				vo.setCtnt(rs.getNString("ctnt"));
				vo.setR_dt(rs.getString("r_dt"));
				vo.setM_dt(rs.getString("m_dt"));
				vo.setViews(rs.getInt("views"));
				vo.setTyp(param.getTyp());
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return vo;
	}
	
	// upsView, delBoard, upsBoard -> AOP 통합. 인터페이스 활용.
	public static int myExecuteUpdate(String sql, SQLInterUpdate sqlInter) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			sqlInter.proc(ps);
			return ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}
	
	// 댓글 list
	public static List<BoardCmtVO> selBoardCmtList(final BoardVO param) {
		List<BoardCmtVO> list = new ArrayList<BoardCmtVO>();
		BoardCmtVO vo = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select i_cmt, ctnt, r_dt, emp, unemp "
				+ " from t_board_cmt_? where i_board = ? "
				+ "order by i_cmt desc ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getTyp());
			ps.setInt(2, param.getI_board());
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new BoardCmtVO();
				vo.setI_cmt(rs.getInt("i_cmt"));
				vo.setCtnt(rs.getNString("ctnt"));
				vo.setR_dt(rs.getString("r_dt"));
				vo.setEmp(rs.getInt("emp"));
				vo.setUnemp(rs.getInt("unemp"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return list;
	}
	
	
	
	
	// AOP 통합
	public static void upsViews(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " update t_board_? set views = views + 1 where i_board = ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getTyp());
			ps.setInt(2, param.getI_board());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
	}
	

	// AOP 통합
	public static int delBoard(BoardVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " delete from t_board_? where i_board = ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getTyp());
			ps.setInt(2, param.getI_board());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	// AOP 통합
	public static int upsBoard(BoardVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " update t_board_? "
				+ " set title = ?, ctnt = ?, m_dt = now() "
				+ " where i_board = ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getTyp());
			ps.setNString(2, param.getTitle());
			ps.setNString(3, param.getCtnt());
			ps.setInt(4, param.getI_board());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
		return result;
	}
	
	// 글작성시 다음 글 번호 값 가져오기.
	public static int regI_board(BoardVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select max(i_board) from t_board_? ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getTyp());
			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt("max(i_board)") + 1;
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
		return result;
	}
}








































































































































































































































































