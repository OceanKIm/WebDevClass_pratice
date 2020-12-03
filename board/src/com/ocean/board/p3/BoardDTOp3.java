package com.ocean.board.p3;

public class BoardDTOp3 {
	private int i_board;
	private String title;
	private	String ctnt;
	private String r_dt;
	private int views;
	
	public BoardDTOp3() {}
	
	public BoardDTOp3(int i_board, String title, String ctnt, String r_dt, int views) {
		this.i_board = i_board;
		this.title = title;
		this.ctnt = ctnt;
		this.r_dt = r_dt;
		this.views = views;
	}
	
	// getter and setter
	public int getI_board() {
		return i_board;
	}
	public void setI_board(int i_board) {
		this.i_board = i_board;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCtnt() {
		return ctnt;
	}
	public void setCtnt(String ctnt) {
		this.ctnt = ctnt;
	}
	public String getR_dt() {
		return r_dt;
	}
	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
}
