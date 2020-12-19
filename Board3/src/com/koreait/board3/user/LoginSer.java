package com.koreait.board3.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board3.common.SecurityUtils;
import com.koreait.board3.common.Utils;


@WebServlet("/login")
public class LoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(SecurityUtils.isLogin(request)) {
			response.sendRedirect("/main");
			return;
		}
		
		int msg = Utils.parsInt(request, "msg");	// 0
		System.out.println(msg);
		switch (msg) {
		case 1:
			request.setAttribute("msg", "회원가입에 성공하셨습니다!");
			break;
		}
		
		Utils.forward("로그인", "user/login", request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user_id = request.getParameter("user_id");
		int result = UserService.login(request);
		
		switch (result) {
		case 1:
			response.sendRedirect("/main");
			break;
		case 2:
			request.setAttribute("user_id", user_id);
			request.setAttribute("msg", "존재하지 않는 아이디.");
			doGet(request, response);
			break;
		case 3:
			request.setAttribute("user_id", user_id);
			request.setAttribute("msg", "비밀번호 틀림.");
			doGet(request, response);
			break;
		}

		
	}

}
