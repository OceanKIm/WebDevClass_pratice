package com.koreait.board2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board2.common.Utils;
import com.koreait.board2.model.BoardVO;


@WebServlet("/bRegMod")
public class BoardRegModSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int typ = Utils.parsInt(request, "typ");	// 0
		int i_board = Utils.parsInt(request, "i_board"); 	// 0
		
		
		BoardVO param = new BoardVO();
		param.setTyp(typ);
		if (typ == 0) {
			Utils.forward("에러", "err", request, response);
			return;
		}
		
		// 연습 수정 처리
		if (i_board > 0) {
			param.setI_board(i_board);
			BoardVO vo = new BoardVO();
			vo = BoardService.detail(param, request);
			request.setAttribute("data", vo);
			request.setAttribute("typ", typ);
			Utils.forward("글수정", "bRegMod", request, response);
			return;
		}
		request.setAttribute("num", BoardService.regI_board(param));
		request.setAttribute("typ", typ);
		Utils.forward("글등록","bRegMod",request, response);
		

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int typ = Utils.parsInt(request, "typ");	// 0 <- 거의 안 나올것.
		if (typ == 0) {
			Utils.forward("에러", "err", request, response);
			return;
		}
		int i_board = Utils.parsInt(request, "i_board");	// 0
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardVO param = new BoardVO();
		param.setTyp(typ);
		param.setI_board(i_board);
		param.setTitle(title);
		param.setCtnt(ctnt);
		
		if (BoardService.regmod(param) == 0) {
			Utils.forward("에러", "err", request, response);
			return;
		}
		
		response.sendRedirect("/bDetail?typ=" + typ + "&i_board=" + param.getI_board());
	
		// 연습 코딩
		System.out.println("< 요청 클라이언트 정보 >");
		String ip = request.getRemoteAddr();
		String scheme = request.getScheme();
		String protocol = request.getProtocol();
		System.out.println("ip : " + ip);
		System.out.println("scheme : " + scheme);
		System.out.println("protocol : " + protocol);
		/*
		System.out.println("test : getParameterNames()");
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String val = request.getParameter(name);
			System.out.println(name + " = " + val);
		}

		System.out.println(" map test");
		Map<String, String[]> map = request.getParameterMap();
		Set<Entry<String, String[]>> set = map.entrySet();
		Iterator<Entry<String, String[]>> it = set.iterator();
		while(it.hasNext()) {
			Entry<String, String[]> entry = it.next();
			String key = entry.getKey();
			String[] val = entry.getValue();
			System.out.println(key + " : " + Arrays.toString(val));
		}
		*/
		
		// 쿠키 연습.
		/*
		System.out.println("< " + ip + " : 쿠키 정보 >");
		Cookie[] co = request.getCookies();
		for (Cookie c : co) {
			System.out.println(c + " : 정보");
			System.out.println("comment : " + c.getComment());
			System.out.println("domain : " + c.getDomain());
			System.out.println("maxAge : " + c.getMaxAge());
			System.out.println("name : " + c.getName());
			System.out.println("path : " + c.getPath());
			System.out.println("secure : " + c.getSecure());
			System.out.println("value : " + c.getValue());
			System.out.println("version : " + c.getVersion());
			response.addCookie(c);	// 클라이언트쪽에 클라이언트의 정보를 저장함.
		}
		*/
		// 세션 연습
		/*
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		System.out.println("세션 test");
		// 애초에 로그인 할때 session 을  넣어줘야함.
		HttpSession session = request.getSession();
		System.out.println("id : " + session.getId());
		date.setDate((int) session.getCreationTime());
		System.out.println(sdf.format(date));
		date.setDate((int) session.getLastAccessedTime());
		System.out.println(sdf.format(date));
		int interval = session.getMaxInactiveInterval();
		System.out.println("세션유지시간 : " + interval);
		
		// 이 정보는  브라우저가 종료 될 때까지 유지.
		session.setAttribute("key", "test session");
		System.out.println(session.getAttribute("key"));
		
		if (session.isNew()) {
			System.out.println("새로운 페이지 입니다.");
		} else {
			System.out.println("기존의 페이지 입니다.");
		}
		*/
	}
}
























