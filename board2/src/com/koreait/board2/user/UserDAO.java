package com.koreait.board2.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.koreait.board2.db.DbUtils;

public class UserDAO {
	
	public static int userSign(UserVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " insert into users (user_id, user_pw, user_name, user_gen) " + 
					" values (?, ?, ?, ?)" ;
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, param.getUser_id());
			ps.setNString(2, param.getUser_pw());
			ps.setNString(3, param.getUser_name());
			ps.setNString(4, param.getUser_gen());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println();
		} finally {
			DbUtils.close(con, ps);
		}
		return result;
	}

	public static int userLogin(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select user_id, user_pw from users" + 
					" where user_id = ? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setNString(1, param.getUser_id());
			rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getNString("user_pw").equals(param.getUser_pw())) {
					return 1; // 로그인 성공
				}
				return 0; // 비밀번호 불일치
			} 
			return -1; // 아이디 불일치
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return -2; // 오류
	}
	
}































