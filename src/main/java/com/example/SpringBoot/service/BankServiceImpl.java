package com.example.SpringBoot.service;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.SpringBoot.entity.Bank;
import com.example.SpringBoot.vo.BankRequest;
import com.example.SpringBoot.vo.BankResponse;

import antlr.StringUtils;

@Service
public class BankServiceImpl implements BankService {
	
	Bank bank = new Bank();

	@Override
	public BankResponse getAmount(BankRequest bankRequest) {
		// 1. 撈DB確認資料->帳號 . 密碼 (但目前沒有DB , 先自製資料)
		BankResponse br = new BankResponse();
		String account = bankRequest.getAccount();
		String pwd = bankRequest.getPwd();
		
		if(bank.getAccountMap().isEmpty()) {
			br.message = "尚未有帳號存在";
		}
		Iterator<Map.Entry<String, String>> iterator = bank.getAccountMap().entrySet().iterator();
		while (iterator.hasNext()) {
		    Map.Entry<String,String> entry = iterator.next();
		    String key = entry.getKey();
		    String value = entry.getValue();
		    if(account.equals(key) && pwd.equals(value)) {
		    	br.message = account + "登入成功!";
		    	System.out.println("登入成功!");
				br.setAccount(account);
				int balance = (int) bank.getBalanceMap().get(account);
				br.setBalance(balance);
				if(bank.getBalanceMap().get(account) == null) {
					br.message = "尚未進行初次存款";
				}
				return br;
		    }else {
				br.message = "this account is invalid";
		    }
		}
		return br;
	}

	@Override
	public BankResponse deposit(BankRequest bankRequest) {
		BankResponse br = new BankResponse();
		String account = bankRequest.getAccount();
		String pwd = bankRequest.getPwd();
		int amount = bankRequest.getAmount();
		
		if(bank.getAccountMap().isEmpty()) {
			br.message = "尚未有帳號存在";
		}
		if(!bank.getAccountMap().containsKey(account)){
	    	br.message = "無此帳號";
	    	System.out.println("無此帳號");
	    	return br;
		}
		int balance = (int) bank.getBalanceMap().get(account);
		Iterator<Map.Entry<String, String>> iterator = bank.getAccountMap().entrySet().iterator();
		while (iterator.hasNext()) {
		    Map.Entry<String,String> entry = iterator.next();
		    String key = entry.getKey();
		    String value = entry.getValue();
		    if(account.equals(key) && pwd.equals(value)){
		    	br.message = "登入成功 , 存款" + amount + "元";
		    	System.out.println("登入成功 , 存款" + amount + "元");
		    	balance = amount + balance;
		    	bank.getBalanceMap().put(account, balance);
		    	br.setAccount(bankRequest.getAccount());
		    	br.setBalance(balance);
		    	return br;
		    }else {
		    	br.message = "密碼錯誤";
		    	System.out.println("密碼錯誤");
		    }
		}
		return br;
	}

	@Override
	public BankResponse withdraw(BankRequest bankRequest) {
		BankResponse br = new BankResponse();
		String account = bankRequest.getAccount();
		String pwd = bankRequest.getPwd();
		int amount = bankRequest.getAmount();
		
		if(bank.getAccountMap().isEmpty()) {
			br.message = "尚未有帳號存在";
		}
		if(!bank.getAccountMap().containsKey(account)){
	    	br.message = "無此帳號";
	    	System.out.println("無此帳號");
	    	return br;
		}
		if(amount <= 0) {
			br.message = "提款金額不得低於1元";
			return br;
		}
		int balance = (int) bank.getBalanceMap().get(account);
		Iterator<Map.Entry<String, String>> iterator = bank.getAccountMap().entrySet().iterator();
		while (iterator.hasNext()) {
		    Map.Entry<String,String> entry = iterator.next();
		    String key = entry.getKey();
		    String value = entry.getValue();
		    if(account.equals(key) && pwd.equals(value)){
				if(balance >= amount) {
					balance -= amount;
					System.out.println("提款: " + amount + "元");
					bank.getBalanceMap().put(account, balance);
					System.out.println("提款完成");
					br.message = "提款完成";
					br.setAccount(account);
					br.setBalance(balance);
					return br;
				} else {
					System.out.println("提款: " + amount + "元");
					System.out.println("提款失敗 , 您的餘額不足!");
					br.message = "提款失敗 , 您的餘額不足!";
					br.setAccount(account);
					br.setBalance(balance);
				}
		    }else {
		    	br.message = "密碼錯誤";
		    	System.out.println("密碼錯誤");
		    }
		}
		return br;
	}

	@Override
	public BankResponse createAccountAndPwd(BankRequest bankRequest) {
		BankResponse br = new BankResponse();
		String account = bankRequest.getAccount();
		String pwd = bankRequest.getPwd();
		if(bank.getAccountMap().containsKey(account)){
			br.message = "account is exist";
		}else {
			if(bankRequest.getAccount() != null && !bankRequest.getAccount().isBlank()
					&& bankRequest.getPwd() != null && !bankRequest.getPwd().isBlank()
					&& !bank.getAccountMap().containsKey(bankRequest.getAccount())) {
				bank.getAccountMap().put(account, pwd);
				System.out.println("帳號密碼設置完成!");
				bank.getBalanceMap().put(account, 0);
				br.setAccount(account);
				br.setPwd(pwd);
				br.message = "帳號密碼設置完成!";
			}else {
				br.message = "failed : illegal format";
			}
		}
		return br;
	}
}
