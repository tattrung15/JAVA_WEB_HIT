package com.hithaui.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "provinces")
public class Province {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "province_id")
	private Integer id;

	@Nationalized
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "slug", nullable = false)
	private String slug;

	@Column(name = "type", nullable = false)
	private String type;

	@Nationalized
	@Column(name = "name_with_type", nullable = false)
	private String nameWithType;

	@Column(name = "code", nullable = false, unique = true)
	private Integer code;

	@OneToMany(mappedBy = "province")
	@JsonIgnore
	private List<District> districts;

	public Province() {

	}

	public Province(Integer id, String name, String slug, String type, String nameWithType, Integer code,
			List<District> districts) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.type = type;
		this.nameWithType = nameWithType;
		this.code = code;
		this.districts = districts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNameWithType() {
		return nameWithType;
	}

	public void setNameWithType(String nameWithType) {
		this.nameWithType = nameWithType;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

}
