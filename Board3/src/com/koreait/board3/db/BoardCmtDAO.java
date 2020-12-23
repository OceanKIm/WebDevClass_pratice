package com.koreait.board3.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board3.model.BoardCmtSEL;
import com.koreait.board3.model.BoardPARAM;

public class BoardCmtDAO extends CommonDAO {
	
	public static List<BoardCmtSEL> selCmtList(BoardPARAM p) {
		List<BoardCmtSEL> list = new ArrayList<>();
		BoardCmtSEL vo = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select A.i_cmt, A.seq, A.ctnt, date_format(A.r_dt, '%d %b %y %H:%I:%S') r_dt, A.emp, A.unemp, A.i_user, B.nm "
				+ " from t_board_cmt A, t_user B "
				+ " where A.i_user = B.i_user and i_board = ? "
				+ " order by seq desc ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getI_board());
			rs = ps.executeQuery();
			while(rs.next()) {
				vo = new BoardCmtSEL();
				vo.setI_cmt(rs.getInt("i_cmt"));
				vo.setSeq(rs.getInt("seq"));
				vo.setCtnt(rs.getNString("ctnt"));
				vo.setR_dt(rs.getString("r_dt"));
				vo.setEmp(rs.getInt("emp"));
				vo.setUnemp(rs.getInt("unemp"));
				vo.setI_user(rs.getInt("i_user"));
				vo.setNm(rs.getNString("nm"));
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
