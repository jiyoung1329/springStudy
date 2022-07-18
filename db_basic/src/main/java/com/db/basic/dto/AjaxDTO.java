package com.db.basic.dto;

public class AjaxDTO {
	public String title;
	public String artist;
	public String price;
	

	public AjaxDTO() {};
	
	public AjaxDTO(String title, String artist, String price) {
		super();
		this.title = title;
		this.artist = artist;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
