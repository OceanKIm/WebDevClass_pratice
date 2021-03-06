package com.koreait.board3.user;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.koreait.board3.common.SecurityUtils;
import com.koreait.board3.common.Utils;
import com.koreait.board3.db.SQLInterUpdate;
import com.koreait.board3.db.UserDAO;
import com.koreait.board3.model.UserModel;
import com.sun.net.httpserver.HttpContext;

public class UserService {

	// 회원가입
	public static int join(HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String nm = request.getParameter("nm");
		int gender = Utils.parsInt(request, "gender");
		String ph = request.getParameter("ph");

		String salt = SecurityUtils.getSalt();
		String encryptPw = SecurityUtils.getSecurePassword(user_pw, salt);

		UserModel p = new UserModel();
		p.setUser_id(user_id);
		p.setUser_pw(encryptPw);
		p.setSalt(salt);
		p.setNm(nm);
		p.setGender(gender);
		p.setPh(ph);
		
		String sql = " insert into t_user(user_id, user_pw, salt, nm, gender, ph) "
				+ " values (?, ?, ?, ?, ?, ?) ";
		
		return UserDAO.executeUpdate(sql, new SQLInterUpdate() {
			@Override
			public void proc(PreparedStatement ps) throws SQLException {
				ps.setNString(1, p.getUser_id());
				ps.setNString(2, p.getUser_pw());
				ps.setNString(3, p.getSalt());
				ps.setNString(4, p.getNm());
				ps.setInt(5, p.getGender());
				ps.setNString(6, p.getPh());
			}
		});
	}
	
	// 로그인
	public static int login(HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		UserModel p = new UserModel();
		p.setUser_id(user_id);
		p.setUser_pw(user_pw);
		
		UserModel vo = UserDAO.selUser(p);
		if(vo == null) {
			// 아이디 없음
			return 2;
		} 
		String encryptPw = SecurityUtils.getSecurePassword(user_pw, vo.getSalt());
		if (encryptPw.equals(vo.getUser_pw())) {
			// 로그인 성공시 세션에 로그인 정보 박아버리고 pw, salt 값 초기화.
			HttpSession hs = request.getSession();
			hs.setAttribute("loginUser", vo);
			vo.setUser_pw(null);
			vo.setSalt(null);
			return 1;
		}
		return 3;
	}

	
}

















