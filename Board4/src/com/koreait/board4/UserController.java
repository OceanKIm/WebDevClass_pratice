package com.koreait.board4;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.common.SecurityUtils;
import com.koreait.board4.common.Utils;
import com.koreait.board4.db.CommonDAO;
import com.koreait.board4.db.SQLInterUpdate;
import com.koreait.board4.db.UserDAO;
import com.koreait.board4.model.UserModel;

// 각각 user 서블릿 역할을 하는 것임.
public class UserController {
	
	// 로그인 get
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utils.forwardTemp("로그인", "temp/basic_temp", "user/login", request, response);
	}
	// 로그인 post
	public void loginProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		UserModel param = new UserModel();
		param.setUser_id(user_id);
		param.setUser_pw(user_pw);
		
		UserModel loginUser = UserDAO.selUser(param);
		if (loginUser == null) {
			request.setAttribute("user_id", user_id);
			request.setAttribute("msg", "존재하지 않는 아이디");
			login(request, response);
			return;
		}
		String spw = SecurityUtils.getSecurePassword(user_pw, loginUser.getSalt());
		if (spw.equals(loginUser.getUser_pw())) {
			HttpSession hs = request.getSession();
			hs.setAttribute("loginUser", loginUser);
			loginUser.setSalt(null);
			loginUser.setUser_pw(null);
			response.sendRedirect("/board/list.korea");
			return;
		} else {
			request.setAttribute("user_id", user_id);
			request.setAttribute("msg", "비밀번호 틀림");
			login(request, response);
			return;
		}
	}
	
	// 회원가입 get
	public void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utils.forwardTemp("회원가입", "temp/basic_temp", "user/join", request, response);
	}
	
	// 회원가입 post
	public void joinProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String nm = request.getParameter("nm");
		String gender = request.getParameter("gender");
		String ph = request.getParameter("ph");
		String salt = SecurityUtils.getSalt();
		String spw = SecurityUtils.getSecurePassword(user_pw, salt);
		
		String sql = " insert into t_user (user_id, user_pw, salt, nm, gender, ph) "
				+ " values (?, ?, ?, ?, ?, ? ) ";
		
		int result = CommonDAO.executeUpdate(sql, new SQLInterUpdate() {
			@Override
			public void proc(PreparedStatement ps) throws SQLException {
				ps.setNString(1, user_id);
				ps.setNString(2, spw);
				ps.setNString(3, salt);
				ps.setNString(4, nm);
				ps.setInt(5, Integer.parseInt(gender));
				ps.setNString(6, ph);
			}
		});
		
		if (result == 0) {
			request.setAttribute("msg", "회원가입 실패");
			join(request, response);
			return;
		}
		response.sendRedirect("/board/list.korea");
	}
	
}










































