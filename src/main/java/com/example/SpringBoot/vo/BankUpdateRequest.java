package com.example.SpringBoot.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BankUpdateRequest {
	
	private String account;
	
	@JsonProperty("password")
	private String pwd;
	
	@JsonProperty("newPassword")
	private String newPwd;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getOldPwd() {
		return pwd;
	}

	public void setOldPwd(String oldPwd) {
		this.pwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
	
	
}
