package com.hithaui.dto;

import java.util.List;

public class ProvinceCollectionDTO {
	private List<ProvinceDTO> provinceDTOs;

	public ProvinceCollectionDTO() {
	}

	public ProvinceCollectionDTO(List<ProvinceDTO> provinceDTOs) {
		super();
		this.provinceDTOs = provinceDTOs;
	}

	public List<ProvinceDTO> getProvinceDTOs() {
		return provinceDTOs;
	}

	public void setProvinceDTOs(List<ProvinceDTO> provinceDTOs) {
		this.provinceDTOs = provinceDTOs;
	}

}
