package com.ocean.board.v3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/v3/bDetail")
public class SerbDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_board = Utils.parsInt(request, "i_board");
		
		BoardDAO3 dao = BoardDAO3.getInstance();
		BoardDTO3 dto = dao.selDTO(i_board);
		dto.upViews();
		
		request.setAttribute("data", dto);
		
		Utils.forward("bDetail", request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
