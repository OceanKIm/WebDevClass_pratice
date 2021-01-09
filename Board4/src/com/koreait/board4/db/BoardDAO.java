package com.koreait.board4.db;

import java.sql.*;
import java.util.*;
import com.koreait.board4.model.*;


public class BoardDAO extends CommonDAO{
	
	public static List<BoardSEL> selBoardList(BoardPARAM p) {
		List<BoardSEL> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.i_board, A.seq, A.title, A.r_dt, A.m_dt, A.hits, ifnull(B.nm, '탈퇴회원') AS writer_nm, " + 
				" ifnull(C.favorite_cnt, 0) AS favorite_cnt " + 
				" FROM t_board A " + 
				" LEFT JOIN t_user B " + 
				" ON A.i_user = B.i_user " + 
				" LEFT JOIN (SELECT i_board, COUNT(i_user) AS favorite_cnt " + 
				" FROM t_board_favorite " + 
				" GROUP BY i_board) C " + 
				" ON A.i_board = C.i_board " + 
				" WHERE typ = ? " + 
				" ORDER BY seq desc ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getTyp());
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardSEL vo = new BoardSEL();
				vo.setI_board(rs.getInt("i_board"));
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getNString("title"));
				vo.setR_dt(rs.getString("r_dt"));
				vo.setM_dt(rs.getString("m_dt"));
				vo.setHits(rs.getInt("hits"));
				vo.setWriter_nm(rs.getNString("writer_nm"));
				vo.setFavorite_cnt(rs.getInt("favorite_cnt"));
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
