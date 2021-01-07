package com.koreait.board4;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.common.Utils;
import com.koreait.board4.db.CommonDAO;

public class Controller {
	private static UserController uCont = new UserController();
	private static BoardController bCont = new BoardController();
	
	public static void goToErr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utils.forward("에러", "err", request, response);
	}
	
	public static void nav(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[] urlArr = request.getRequestURI().split("/");
		System.out.println("요청된 url : " + Arrays.toString(urlArr));

		// 메뉴리스트 가져오기
		ServletContext appliction = request.getServletContext();
		if (appliction.getAttribute("menus") == null) {
			appliction.setAttribute("menus", CommonDAO.selManagerBoardList());
		}
		
		// 1 단계
		switch(urlArr[1]){
		case "user": // 로그인 영역
			// 2 단계
			switch (urlArr[2]) {
			case "login.korea":	// 로그인 화면 뿌리기
				uCont.login(request, response);
				return;
			case "loginProc.korea":	// 로그인 처리
				uCont.loginProc(request, response);;
				return;	
			case "join.korea":
				uCont.join(request, response);
				return;
			case "joinProc.korea":
				uCont.joinProc(request, response);
				return;
			}
			break;
		case "board": // 게시판 영역
			switch (urlArr[2]) {
			case "list.korea":
				bCont.list(request, response);
				break;
			}
			break;
		}
		// 위의 nav 밖의 url이면 무조건 에러 페이지 이동.
		goToErr(request, response);
		
	}
	
	
	
}
