package com.koreait.board3.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board3.common.Utils;


@WebServlet("/login")
public class LoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		int result = UserService.login(request);
		System.out.println("result : " + result);
		
	}

}
