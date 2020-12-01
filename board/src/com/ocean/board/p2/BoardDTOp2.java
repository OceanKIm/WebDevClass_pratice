package com.ocean.board.p2;

public class BoardDTOp2 {
	private int i_board;
	private String title;
	private String ctnt;
	private String r_dt;
	private int views;
	
	public BoardDTOp2() {}
	
	public BoardDTOp2(int i_board, String title, String ctnt, String r_dt, int views) {
		this.i_board = i_board;
		this.title = title;
		this.ctnt = ctnt;
		this.r_dt = r_dt;
		this.views = views;
	}
	
	@Override
	public String toString() {
		return "i_board : " + i_board;
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
