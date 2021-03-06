package com.koreait.board3.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board3.common.SecurityUtils;
import com.koreait.board3.common.Utils;
import com.koreait.board3.model.UserModel;


@WebServlet("/join")
public class JoinSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(SecurityUtils.isLogin(request)) {
			response.sendRedirect("/main");
			return;
		}
		
	
		Utils.forward("회원가입", "user/join", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (UserService.join(request) == 0) {
			// 회원가입 실패. <아이디가 중복된 경우>
			String user_id = request.getParameter("user_id");
			request.setAttribute("user_id", user_id);
			request.setAttribute("msg", "중복된 아이디 입니다.");
			doGet(request, response);
		}
		
		response.sendRedirect("/login?msg=1");
		
	}

}
