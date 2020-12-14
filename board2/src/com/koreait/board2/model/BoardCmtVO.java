package com.koreait.board2.model;

public class BoardCmtVO {
	private int typ;
	private int i_cmt;
	private int i_board;
	private String ctnt;
	private String r_dt;
	private int emp;
	private int unemp;

	// getter and setter
	public int getI_cmt() {
		return i_cmt;
	}
	public void setI_cmt(int i_cmt) {
		this.i_cmt = i_cmt;
	}
	public int getI_board() {
		return i_board;
	}
	public void setI_board(int i_board) {
		this.i_board = i_board;
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
	public int getEmp() {
		return emp;
	}
	public void setEmp(int emp) {
		this.emp = emp;
	}
	public int getUnemp() {
		return unemp;
	}
	public void setUnemp(int unemp) {
		this.unemp = unemp;
	}
	public int getTyp() {
		return typ;
	}
	public void setTyp(int typ) {
		this.typ = typ;
	}
	
}
