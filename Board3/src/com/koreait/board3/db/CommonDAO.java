package com.koreait.board3.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CommonDAO {
	
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
