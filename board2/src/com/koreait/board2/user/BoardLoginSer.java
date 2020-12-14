package com.koreait.board2.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board2.common.Utils;


@WebServlet("/bLogin")
public class BoardLoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int msg = Utils.parsInt(request, "msg");
		if (msg == 1) {
			request.setAttribute("msg", "회원가입에 성공하셨습니다!");
		}
		
		String path = "/WEB-INF/jsp/user/bLogin.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		UserVO param = new UserVO();
		param.setUser_id(user_id);
		param.setUser_pw(user_pw);
		
		switch(UserDAO.userLogin(param)) {
		case 1:
			response.sendRedirect("bList?msg=login");
			break;
		case 0:
			request.setAttribute("msg", "비밀번호가 틀립니다!");
			doGet(request, response);
			break;
		case -1:
			request.setAttribute("msg", "존재하지 않는 아이디!");
			doGet(request, response);
			break;
		case -2:
			request.setAttribute("msg", "알수 없는 오류!");
			doGet(request, response);
			break;
		}
	}

}
