package com.koreait.board2.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bSign")
public class BoardSignSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "/WEB-INF/jsp/user/bSign.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_pw_chk = request.getParameter("user_pw_chk");
		String user_name = request.getParameter("user_name");
		String user_gen = request.getParameter("user_gen");
		
		if (!user_pw.equals(user_pw_chk)) {
			request.setAttribute("msg", "비밀번호가 다릅니다.");	// 왜 안돼지. 나중에 체크
			doGet(request, response);
			return;
		}
			
		UserVO param = new UserVO();
		param.setUser_id(user_id);
		param.setUser_pw(user_pw);
		param.setUser_name(user_name);
		param.setUser_gen(user_gen);
		
		if (UserDAO.userSign(param) == 0) {
			// 회원가입 실패
			response.sendRedirect("/bLogin?msg=0");
			return;
		}
		response.sendRedirect("/bLogin?msg=1");
		// 회원가입 성공 msg = 1, 실패 msg = 0
	}

}
