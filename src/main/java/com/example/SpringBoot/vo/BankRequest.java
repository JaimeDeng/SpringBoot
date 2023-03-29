package com.example.SpringBoot.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BankRequest {
	
	private String account;
	
	@JsonProperty("password")		//讓的JSON屬性字段"password"對應上JAVA程式碼內的pwd
	@JsonAlias("pw")		// 使JSON "pw"字段 與 "password" 一樣對應pwd
	private String pwd;
	
	private Integer amount;
	
	public BankRequest() {
	}
	
	public BankRequest(String account, String pwd) {
		this.account = account;
		this.pwd = pwd;
	}
	
	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
