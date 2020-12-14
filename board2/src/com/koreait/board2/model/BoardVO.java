package com.koreait.board2.model;

public class BoardVO {
	private int i_board;
	private String title;
	private String ctnt;
	private String r_dt;
	private String m_dt;
	private int views;
	private int typ;
	private int getRowCntPerPage;
	private int s_IDx;
	
	
	public BoardVO() {}

	public BoardVO(int i_board, String title, String ctnt, String r_dt, String m_dt, int views, int typ) {
		this.i_board = i_board;
		this.title = title;
		this.ctnt = ctnt;
		this.r_dt = r_dt;
		this.m_dt = m_dt;
		this.views = views;
		this.typ = typ;
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
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getTyp() {
		return typ;
	}
	public void setTyp(int typ) {
		this.typ = typ;
	}

	// 페이징 
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
