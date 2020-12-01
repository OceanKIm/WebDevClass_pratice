package com.ocean.board;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BoardDAO {

	private  List<BoardVO> list;
	private static BoardDAO dao;
	
	// 싱글턴 패턴을 위한 private
	private BoardDAO() {
		list = new ArrayList<>();
		list.add(new BoardVO(1, "안녕하세여", "내용입니다. 안녕하세여..", "10/12", "12/12"));
		list.add(new BoardVO(2, "Hello", "hi nice to meet you", "10/20", "10/20"));
		list.add(new BoardVO(3, "반갑습니다.", "반가워요 반갑습니다.", "11/20", "11/20"));
	}
	
	// 싱글턴 패턴 생성자.
	public static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	// 전체 리스트 보내주기
	public List<BoardVO> selBoardList() {
		return list;
	}
	
	// 리스트 하나 검색해서 보내주기
	public BoardVO selBoard(int i_board) {
		for (BoardVO vo : list) {
			if (vo.getI_board() == i_board) {
				return vo;
			}
		}
		return null;
	}
	// 리스트 삭제 메서드
	public void delBoard(int i_board) {
		for(BoardVO vo : list) {
			if(vo.getI_board() == i_board) {
				list.remove(vo);
				return;
			}
		}
	}
	// 리스트 삭제 메서드 -> 인덱스 버전
	public void delBoard2(int i_board) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getI_board() == i_board) {
				list.remove(i);
			}
		}
	}
	
	
	
	// 글 수정 메서드
	public void upBoard(int i_board ,String title, String ctnt) {
		Calendar cal = Calendar.getInstance();
		String date = (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH);  
		for(BoardVO vo : list) {
			if (vo.getI_board() == i_board) {
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setM_dt(date);
				return;
			}
		}
	}
	
	public void insBoard(BoardVO vo) {
		list.add(vo);
	}
	
}














