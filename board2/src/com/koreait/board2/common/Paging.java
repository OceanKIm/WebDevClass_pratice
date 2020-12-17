package com.koreait.board2.common;

public class Paging {
	private int pageBegin;
	private int pageEnd;
	private int boundary;
	private int setMove;
	
	static Paging pg;
	public static Paging getInstance(int selPageCnt, int setMove) {
		if (pg == null) {
			pg = new Paging(selPageCnt, setMove);
		} 
		return pg;
	}
	
	private Paging(int selPageCnt, int setMove) {
		this.pageBegin = 1;
		this.pageEnd = selPageCnt;
		this.boundary = setMove;
		this.setMove = setMove;
	}
	
	public void pageMoving(String move) {
		if (move != null) {
			switch (move) {
			case "up":
				if (boundary > (pageEnd - setMove)) {
					boundary = pageEnd;
					break;
				} 
				pageBegin += setMove;
				boundary += setMove;
				break;
			case "down":
				if (pageBegin == 1) {
					break;
				} else if (boundary % setMove != 0) {
					pageBegin -= setMove;
					boundary -= (setMove + (boundary % setMove));
				}
				pageBegin -= setMove;
				boundary -= setMove;
				break;
			}
		}
	}
	
	public int begin() {
		return pageBegin;
	}
	
	public int end() {
		return pageEnd;
	}
	
	public int boundary() {
		return boundary;
	}
}
