package com.example.SpringBoot.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankResponse {
	
	private String account;
	
	@JsonProperty("password")
	private String pwd;
	
	public String message;
	
	private int amount;

	
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
