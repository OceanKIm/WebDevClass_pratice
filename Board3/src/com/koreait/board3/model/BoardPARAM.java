package com.koreait.board3.model;

public class BoardPARAM {
	private int i_board;
	private int typ;
	// 연습 - 페이징
	private int getRowCntPerPage;
	private int s_IDx;
	
	
	
	// getter and setter
	public int getI_board() {
		return i_board;
	}
	public void setI_board(int i_board) {
		this.i_board = i_board;
	}
	public int getTyp() {
		return typ;
	}
	public void setTyp(int typ) {
		this.typ = typ;
	}
	
	//연습 - 페이징
	public int getGetRowCntPerPage() {
		return getRowCntPerPage;
	}
	public void setGetRowCntPerPage(int getRowCntPerPage) {
		this.getRowCntPerPage = getRowCntPerPage;
	}
	public int getS_IDx() {
		return s_IDx;
	}
	public void setS_IDx(int s_IDx) {
		this.s_IDx = s_IDx;
	}
}
