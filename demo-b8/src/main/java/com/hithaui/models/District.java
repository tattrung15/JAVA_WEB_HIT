package com.hithaui.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "districts")
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "district_id")
	private Integer id;

	@Nationalized
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "type", nullable = false)
	private String type;

	@Column(name = "slug", nullable = false)
	private String slug;

	@Nationalized
	@Column(name = "name_with_type", nullable = false)
	private String nameWithType;

	@Nationalized
	@Column(name = "path", nullable = false)
	private String path;

	@Nationalized
	@Column(name = "path_with_type", nullable = false)
	private String pathWithType;

	@Column(name = "code", unique = true, nullable = false)
	private Integer code;

	@Column(name = "parent_code", nullable = false)
	private Integer parentCode;

	@ManyToOne
	@JoinColumn(name = "province_id")
	private Province province;

	public District() {

	}

	public District(Integer id, String name, String type, String slug, String nameWithType, String path,
			String pathWithType, Integer code, Integer parentCode, Province province) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.slug = slug;
		this.nameWithType = nameWithType;
		this.path = path;
		this.pathWithType = pathWithType;
		this.code = code;
		this.parentCode = parentCode;
		this.province = province;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getNameWithType() {
		return nameWithType;
	}

	public void setNameWithType(String nameWithType) {
		this.nameWithType = nameWithType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPathWithType() {
		return pathWithType;
	}

	public void setPathWithType(String pathWithType) {
		this.pathWithType = pathWithType;
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

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

}
