package com.example.SpringBoot.service;

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
		Iterator<Map.Entry<String, String>> iterator = bank.getAccountMap().entrySet().iterator();
		while (iterator.hasNext()) {
		    Map.Entry<String,String> entry = iterator.next();
		    String key = entry.getKey();
		    String value = entry.getValue();
		    if(bankRequest.getAccount().equals(key) && bankRequest.getPwd().equals(value)) {
		    	System.out.println("登入成功!");
				br.setAccount(bankRequest.getAccount());
				br.setAmount(bank.getAmount());
		    }else {
				br.setAccount("this account is invalid");
		    }
		}
		return br;
//		if(account == null || account.isBlank()) {
//			System.out.println("您的帳號不得為空或null");D
//		}
//		System.out.println("帳戶: " + bank.getAccount() + " , 餘額: " + bank.getAmount());
	}

	@Override
	public BankResponse deposit(BankRequest bankRequest) {
		BankResponse br = new BankResponse();
		if(bank.getAccountMap().isEmpty()) {
			br.message = "尚未有帳號存在";
		}
		Iterator<Map.Entry<String, String>> iterator = bank.getAccountMap().entrySet().iterator();
		while (iterator.hasNext()) {
		    Map.Entry<String,String> entry = iterator.next();
		    String key = entry.getKey();
		    String value = entry.getValue();
		    if(bankRequest.getAccount().equals(key) && bankRequest.getPwd().equals(value)){
		    	br.message = "登入成功 , 存款" + bankRequest.getAmount() + "元";
		    	System.out.println("登入成功 , 存款" + bankRequest.getAmount() + "元");
		    	bank.setAmount(bank.getAmount()+bankRequest.getAmount());
		    	br.setAccount(bankRequest.getAccount());
		    	br.setAmount(bank.getAmount());
		    }else {
		    	br.message = "無此帳號";
		    	System.out.println("無此帳號");
		    }
		}
		return br;
		
//		System.out.println("帳戶: " + bank.getAccount() + " , 餘額: " + bank.getAmount());
//		int recentAmount = bank.getAmount();
//		recentAmount += depositAmount;
//		bank.setAmount(recentAmount);
//		System.out.println("存款" + depositAmount + "元 已完成");
//		System.out.println("帳戶: " + bank.getAccount() + " , 餘額: " + bank.getAmount());
	}

	@Override
	public BankResponse withdraw(BankRequest bankRequest) {
		BankResponse br = new BankResponse();
		Iterator<Map.Entry<String, String>> iterator = bank.getAccountMap().entrySet().iterator();
		if(bankRequest.getAmount() <= 0) {
			br.message = "提款金額不得低於1元";
			return br;
		}
		while (iterator.hasNext()) {
		    Map.Entry<String,String> entry = iterator.next();
		    String key = entry.getKey();
		    String value = entry.getValue();
		    if(bankRequest.getAccount().equals(key) && bankRequest.getPwd().equals(value)){
			br.message = "success";
			int recentAmount = bank.getAmount();
				if(bank.getAmount() >= bankRequest.getAmount()) {
					recentAmount -= bankRequest.getAmount();
					System.out.println("提款: " + bankRequest.getAmount() + "元");
					System.out.println("提款完成");
				} else {
					System.out.println("提款: " + bankRequest.getAmount() + "元");
					System.out.println("提款失敗 , 您的餘額不足!");
					br.message = "提款失敗,餘額不足";
				}
			bank.setAmount(recentAmount);
			System.out.println("帳戶: " + bank.getAccount() + " , 餘額: " + bank.getAmount());
			br.setAccount(bankRequest.getAccount());
			br.setAmount(recentAmount);
		    }
		}
		return br;
	}

	@Override
	public BankResponse createAccountAndPwd(BankRequest bankRequest) {
		BankResponse br = new BankResponse();
		if(bank.getAccountMap().containsKey(bankRequest.getAccount())) {
			br.message = "account is exist";
		}
		if(bankRequest.getAccount() != null && !bankRequest.getAccount().isBlank()
				&& bankRequest.getPwd() != null && !bankRequest.getPwd().isBlank()
				&& !bank.getAccountMap().containsKey(bankRequest.getAccount())) {
			bank.getAccountMap().put(bankRequest.getAccount(), bankRequest.getPwd());
			System.out.println("帳號密碼設置完成!");
			br.setAccount(bankRequest.getAccount());
			br.setPwd(bankRequest.getPwd());
			br.message = "success!";
		}else {
			br.message = "failed : illegal format";
		}
		return br;
	}

}
