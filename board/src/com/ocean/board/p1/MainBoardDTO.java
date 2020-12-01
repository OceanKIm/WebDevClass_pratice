package com.ocean.board.p1;

public class MainBoardDTO {
	
	private int i_board;
	private String title;
	private String ctnt;
	private String r_dt;
	private String m_dt;
	public static int count;
	
	public MainBoardDTO(String title, String ctnt, String r_dt, String m_dt) {
		this.i_board = ++count;
		this.title = title;
		this.ctnt = ctnt;
		this.r_dt = r_dt;
		this.m_dt = m_dt;
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
	public String getM_dt() {
		return m_dt;
	}
	public void setM_dt(String m_dt) {
		this.m_dt = m_dt;
	}
	
}
