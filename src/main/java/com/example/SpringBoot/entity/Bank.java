package com.example.SpringBoot.entity;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.service.Active;
import com.example.SpringBoot.service.Animal;

@Entity
@Table(name = "bank")
public class Bank {

	@Id	
	@Column(name = "account")
	private String account;
	
	@Column(name = "pwd")
	private String pwd;
	
	@Column(name = "balance")
	private Integer balance;

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

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	public void setAll(String account , String pwd , Integer balance) {
		this.account = account;
		this.pwd = pwd;
		this.balance = balance;
	}

	public Bank() {
	}
	
//	private LinkedHashMap AccountMap = new LinkedHashMap<String , String>();
//	
//	private LinkedHashMap balanceMap = new LinkedHashMap<String , Integer>();
//
//	public LinkedHashMap getAccountMap() {
//		return AccountMap;
//	}
//
//	public void setAccountMap(LinkedHashMap accountMap) {
//		AccountMap = accountMap;
//	}
//
//	public LinkedHashMap getBalanceMap() {
//		return balanceMap;
//	}
//
//	public void setBalanceMap(LinkedHashMap balanceMap) {
//		this.balanceMap = balanceMap;
//	}
}
