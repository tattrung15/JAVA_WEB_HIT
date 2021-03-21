package com.hithaui.dto;

public class AccountDTO {

	private String username;

	private Integer money;

	public AccountDTO() {
	}

	public AccountDTO(String username, Integer money) {
		super();
		this.username = username;
		this.money = money;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

}
