package com.hithaui.dto;

public class ProvinceDTO {
	private String name;

	private String type;

	private Integer code;

	public ProvinceDTO() {
	}

	public ProvinceDTO(String name, String type, Integer code) {
		super();
		this.name = name;
		this.type = type;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
