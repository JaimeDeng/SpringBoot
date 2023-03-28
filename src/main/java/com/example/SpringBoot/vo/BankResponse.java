package com.example.SpringBoot.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)		//定義Json只顯示非null
public class BankResponse {
	
	private String account;
	
	@JsonProperty("password")
	@JsonAlias("pass word")		//定義Json可以"password" . "pass word" 來存取pwd的值
	private String pwd;
	
	public String message;
	
	private Integer amount;

	private Integer balance;

	
	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
