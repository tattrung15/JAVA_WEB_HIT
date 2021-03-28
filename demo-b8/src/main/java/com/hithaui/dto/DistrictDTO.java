package com.hithaui.dto;

public class DistrictDTO {
	private String name;

	private String type;

	private Integer code;

	private Integer parentCode;

	public DistrictDTO() {
	}

	public DistrictDTO(String name, String type, Integer code, Integer parentCode) {
		super();
		this.name = name;
		this.type = type;
		this.code = code;
		this.parentCode = parentCode;
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

	public Integer getParentCode() {
		return parentCode;
	}

	public void setParentCode(Integer parentCode) {
		this.parentCode = parentCode;
	}

}
