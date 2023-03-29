package com.example.SpringBoot.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)		//定義Json只顯示非null
public class BankResponse extends BankRequest {
//因為會使用重複的屬性 , 直接繼承BankRequest來使用這些屬性即可
//	BankRequest已經擁有以下屬性
//	private String account;
//
//	private String pwd;
//	
//	private Integer amount;
	
	public String message;

	private Integer balance;
	
	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}
}
