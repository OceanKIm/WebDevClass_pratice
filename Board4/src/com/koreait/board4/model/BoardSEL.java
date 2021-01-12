package com.koreait.board4.model;

public class BoardSEL extends BoardModel{
	private String writer_nm;
	private int favorite_cnt;
	private int is_favorite;
	
	public String getWriter_nm() {
		return writer_nm;
	}
	public void setWriter_nm(String writer_nm) {
		this.writer_nm = writer_nm;
	}
	public int getFavorite_cnt() {
		return favorite_cnt;
	}
	public void setFavorite_cnt(int favorite_cnt) {
		this.favorite_cnt = favorite_cnt;
	}
	public int getIs_favorite() {
		return is_favorite;
	}
	public void setIs_favorite(int is_favorite) {
		this.is_favorite = is_favorite;
	}
}
