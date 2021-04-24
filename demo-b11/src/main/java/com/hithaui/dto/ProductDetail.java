package com.hithaui.dto;

public class ProductDetail {
	private ProductDTO product;
	private ProductImageDTO productImage;

	public ProductDetail() {
	}

	public ProductDetail(ProductDTO product, ProductImageDTO productImage) {
		super();
		this.product = product;
		this.productImage = productImage;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public ProductImageDTO getProductImage() {
		return productImage;
	}

	public void setProductImage(ProductImageDTO productImage) {
		this.productImage = productImage;
	}

}
