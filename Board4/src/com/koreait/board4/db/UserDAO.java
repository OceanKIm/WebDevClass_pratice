package com.koreait.board4.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board4.model.UserModel;

public class UserDAO extends CommonDAO {
	
	public static UserModel selUser(UserModel p) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserModel vo = null;
		
		String sql = "select i_user, nm, user_pw, salt "
				+ " from t_user where user_id = ? "; 
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getUser_id());
			rs = ps.executeQuery();
			if (rs.next()) {
				vo = new UserModel();
				vo.setI_user(rs.getInt("i_user"));
				vo.setNm(rs.getNString("nm"));
				vo.setUser_pw(rs.getNString("user_pw"));
				vo.setSalt(rs.getNString("salt"));
				return vo;
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return null;
	}
}
