package com.example.SpringBoot.entity;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.service.Active;
import com.example.SpringBoot.service.Animal;

public class Bank {

//	private String account;
//	
//	private String pwd;
	
	private LinkedHashMap AccountMap = new LinkedHashMap<String , String>();
	
	private LinkedHashMap balanceMap = new LinkedHashMap<String , Integer>();

	public LinkedHashMap getAccountMap() {
		return AccountMap;
	}

	public void setAccountMap(LinkedHashMap accountMap) {
		AccountMap = accountMap;
	}

	public LinkedHashMap getBalanceMap() {
		return balanceMap;
	}

	public void setBalanceMap(LinkedHashMap balanceMap) {
		this.balanceMap = balanceMap;
	}

	public Bank() {
	}
}
