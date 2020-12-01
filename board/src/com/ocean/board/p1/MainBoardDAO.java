package com.ocean.board.p1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainBoardDAO {

	private List<MainBoardDTO> list;
	Calendar cal = Calendar.getInstance();
	int month, day;
	public static MainBoardDAO dao;
	
	public static MainBoardDAO getInstance() {
		if (dao == null) {
			dao = new MainBoardDAO();
		}
		return dao;
	}
	
	public MainBoardDAO() {
		list = new ArrayList<MainBoardDTO>();
		MainBoardDTO dto = new MainBoardDTO("타이틀", "내용", "11/26", "11/26");
		list.add(dto);
	}
	
	public List<MainBoardDTO> selBoardList() {
		return list;
	}
	
	public MainBoardDTO selBoardListDTO(int i_board) {
		for (MainBoardDTO dto : list) {
			if (dto.getI_board() == i_board) {
				return dto;
			}
		}
		return null;
	}
	
	public void inBoardList(String title, String ctnt) {
		String date = (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH);
		list.add(new MainBoardDTO(title, ctnt, date, date));
	}
	
	public void delBoardList(int i_board) {
		for(MainBoardDTO dto : list) {
			if(dto.getI_board() == i_board) {
				list.remove(dto);
				return;
			}
		}
	}
	
	public void upBoardList(int i_board, String title, String ctnt) {
		for(MainBoardDTO dto : list) {
			if (dto.getI_board() == i_board) {
				dto.setTitle(title);
				dto.setCtnt(ctnt);
				return;
			}
		}
	}

}










