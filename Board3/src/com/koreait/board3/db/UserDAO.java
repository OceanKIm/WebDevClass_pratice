package com.koreait.board3.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.koreait.board3.common.SecurityUtils;
import com.koreait.board3.model.UserModel;

public class UserDAO extends CommonDAO {

	public static UserModel selUser(UserModel p) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserModel vo = null;
		
		String sql = " select i_user, nm, user_pw, salt from t_user "
				+ " where user_id = ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, p.getUser_id());
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
		return null;	// 아이디 존재하지 않음.
	}
	
	
	//0: 에러발생, 1:로그인 성공, 2:아이디 없음, 3:비밀번호 틀림
	public static int login(UserModel p) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select i_user, nm, user_pw, salt from t_user "
				+ " where user_id = ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, p.getUser_id());
			rs = ps.executeQuery();
			if (rs.next()) {
				String encryptPw = SecurityUtils.getSecurePassword(p.getUser_pw(), rs.getNString("salt"));
				if (rs.getNString("user_pw").equals(encryptPw)) {
					p.setNm(rs.getNString("nm"));
					p.setI_user(rs.getInt("i_user"));
					return 1;
				} 
				return 3;
			} else {
				return 2;
			}		
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return 0;
	}
}
