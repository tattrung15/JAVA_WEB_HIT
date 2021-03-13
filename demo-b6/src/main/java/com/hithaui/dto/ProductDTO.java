package com.hithaui.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {

	private String title;

	private MultipartFile image;

	private String description;

	public ProductDTO() {
	}

	public ProductDTO(String title, MultipartFile image, String description) {
		super();
		this.title = title;
		this.image = image;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
