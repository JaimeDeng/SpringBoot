package com.example.SpringBoot.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.service.Active;
import com.example.SpringBoot.service.Animal;

public class Bank {
	
	
	private String account;
	
	private String pwd;
	
	private int amount = 0;
	
	
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

	public Bank() {
	}
	
	public Bank(String account) {
		this.account = account;
	}
	
	public Bank(String account, int amount) {
		this.account = account;
		this.amount = amount;
	}
	
	public Bank(String account, String pwd) {
		this.account = account;
		this.pwd = pwd;
	}
	
	public Bank(String account, String pwd , int amount) {
		this.account = account;
		this.pwd = pwd;
		this.amount = amount;
	}
}
