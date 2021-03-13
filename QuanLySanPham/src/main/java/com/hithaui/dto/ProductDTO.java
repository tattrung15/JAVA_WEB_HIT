package com.hithaui.dto;

public class ProductDTO {
	private String title;

	private String imageLink;

	private String description;

	private String author;

	private Integer categoryId;

	private Integer price;

	private Integer numberOfPage;

	public ProductDTO() {
	}

	public ProductDTO(String title, String imageLink, String description, String author, Integer categoryId,
			Integer price, Integer numberOfPage) {
		super();
		this.title = title;
		this.imageLink = imageLink;
		this.description = description;
		this.author = author;
		this.categoryId = categoryId;
		this.price = price;
		this.numberOfPage = numberOfPage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(Integer numberOfPage) {
		this.numberOfPage = numberOfPage;
	}
}
