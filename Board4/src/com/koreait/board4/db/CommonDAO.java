package com.koreait.board4.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board4.model.ManagerBoardModel;

public class CommonDAO {
	
	public static List<ManagerBoardModel> selManagerBoardList() {
		List<ManagerBoardModel> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select typ, nm from t_manager_board order by orderby ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ManagerBoardModel vo = new ManagerBoardModel();
				vo.setTyp(rs.getInt("typ"));
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
	
	
	
	
	
	public static int executeUpdate(String sql, SQLInterUpdate siu) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			siu.proc(ps);
			return ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}	
}
