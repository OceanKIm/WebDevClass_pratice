package com.ocean.board.v2;

import java.util.Calendar;

public class BoardDTO {
	private int i_board;
	private String title;
	private String ctnt;
	private String r_dt;
	private String m_dt;
	private int views;
	private static int count;
	
	Calendar cal = Calendar.getInstance();
	
	public BoardDTO() {}
	
	public BoardDTO(String title, String ctnt) {
		String date = (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DAY_OF_MONTH);
		this.i_board = ++count;
		this.title = title;
		this.ctnt = ctnt;
		this.r_dt = date;
		this.m_dt = date;
		this.views = 0;
	}
	// 조회수 올리기.
	public void upViews() {
		this.views++;
	}
	
	//getter and setter
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
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
}
