package com.ocean.board.v3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BoardDAO3 {
	
	Calendar cal = Calendar.getInstance();
	List<BoardDTO3> list = new ArrayList<>();
	
	private static BoardDAO3 dao;
	
	public static BoardDAO3 getInstance() {
		if (dao == null) {
			dao = new BoardDAO3();
		}
		return dao;
	}
	
	public BoardDAO3() {
		list.add(new BoardDTO3("제목", "내용"));
	}
	
	public List<BoardDTO3> selList() {
		return list;
	}
	
	public BoardDTO3 selDTO(int i_board) {
		for (BoardDTO3 dto : list) {
			if(dto.getI_board() == i_board) {
				return dto;
			}
		}
		return null;
	}
	
	public void insDTO(String title, String ctnt) {
		list.add(new BoardDTO3(title, ctnt));
	}
	
	public void delDTO(int i_board) {
		for(BoardDTO3 dto : list) {
			if(dto.getI_board() == i_board) {
				list.remove(dto);
				return;
			}
		}
	}
	
	public void upDTO(int i_board, String title, String ctnt) {
		String date = (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH);
		for(BoardDTO3 dto : list) {
			if(dto.getI_board() == i_board) {
				dto.setTitle(title);
				dto.setCtnt(ctnt);
				dto.setM_dt(date);
			}
		}
	}
	
	
}

















