package com.koreait.board3.model;

public class BoardSEL extends BoardModel {
	private String nm;
	private int is_favorite;

	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public int getIs_favorite() {
		return is_favorite;
	}
	public void setIs_favorite(int is_favorite) {
		this.is_favorite = is_favorite;
	}
}
