package com.hithaui.dto;

public class ProductDTO {

	private String title;
	private Integer price;

	public ProductDTO() {
	}

	public ProductDTO(String title, Integer price) {
		super();
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
