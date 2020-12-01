package com.ocean.board.v2;

import java.util.ArrayList;
import java.util.List;

public class BoardDAO2 {
	
	private List<BoardDTO> list;
	
	public static BoardDAO2 dao;
	
	public static BoardDAO2 getInstance() {
		if (dao == null) {
			dao = new BoardDAO2();
		}
		return dao;
	}
	
	public BoardDAO2() {
		list = new ArrayList<>();
		list.add(new BoardDTO("제목", "내용"));
	}
	
	public List<BoardDTO> selBoardList() {
		return list;
	}
	
	public BoardDTO selBoardDTO(int i_board) {
		for(BoardDTO dto : list) {
			if(dto.getI_board() == i_board) {
				return dto;
			}
		}
		return null;
	}
	
	public void insBoard(String title, String ctnt) {
		list.add(new BoardDTO(title, ctnt));
	}
	
	public void delBoard(int i_board) {
		for(BoardDTO dto : list) {
			if(dto.getI_board() == i_board) {
				list.remove(dto);
				return;	// 리턴 필수!! ㅇㅅㅇ
			}
		}
	}
	
	public void upBoard(int i_board, String title, String ctnt) {
		for(BoardDTO dto : list) {
			if(dto.getI_board() == i_board) {
				dto.setTitle(title);
				dto.setCtnt(ctnt);
				dto.setM_dt(Utils.setData());
			}
		}
		
	}
}






















