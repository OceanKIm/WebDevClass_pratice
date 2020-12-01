package com.ocean.board.v2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/v2/BoardDetail")
public class SerBoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int i_board = Utils.parsInt(request, "i_board");
		if (i_board == 0) {
			System.out.println("i_board = 0");
			return;
		}


		BoardDAO2 dao = BoardDAO2.getInstance();
		BoardDTO dto = dao.selBoardDTO(i_board);
		dto.upViews();	// 조회수 올리기.
		request.setAttribute("data", dto);
		
		Utils.forword("boardDetail", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
