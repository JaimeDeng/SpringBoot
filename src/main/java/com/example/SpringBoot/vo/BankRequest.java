package com.example.SpringBoot.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankRequest {
	
	private String account;
	
	@JsonProperty("password")		//讓post的JSON屬性字段"password"對應上JAVA程式碼內的pwd
	private String pwd;
	
	public BankRequest() {
	}
	
	public BankRequest(String account, String pwd) {
		this.account = account;
		this.pwd = pwd;
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
