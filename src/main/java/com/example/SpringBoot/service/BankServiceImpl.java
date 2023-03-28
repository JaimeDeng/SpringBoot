package com.example.SpringBoot.service;

import org.springframework.stereotype.Service;

import com.example.SpringBoot.entity.Bank;
import com.example.SpringBoot.vo.BankRequest;
import com.example.SpringBoot.vo.BankResponse;

import antlr.StringUtils;

@Service
public class BankServiceImpl implements BankService {

	@Override
	public BankResponse getAmount(BankRequest bankRequest) {
		// 1. 撈DB確認資料->帳號 . 密碼 (但目前沒有DB , 先自製資料)
		Bank bank = new Bank("AAA7414" , "74149487" , 10000);
		BankResponse br = new BankResponse();
		if(bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPwd())) {
			System.out.println("登入成功!");
			br.setAccount(bankRequest.getAccount());
			br.setAmount(10000);
		}else {
			br.setAccount("this account is invalid");
			br.setAmount(0);
		}
		return br;
//		if(account == null || account.isBlank()) {
//			System.out.println("您的帳號不得為空或null");D
//		}
//		System.out.println("帳戶: " + bank.getAccount() + " , 餘額: " + bank.getAmount());
	}

	@Override
	public void deposit(Bank bank, int depositAmount) {
		String account = bank.getAccount();
		if(account == null || account.isBlank()) {
			System.out.println("您的帳號不得為空或null");
			return;
		}
		if(depositAmount <= 0) {
			System.out.println("存款金額不得少於1");
			return;
		}
		System.out.println("帳戶: " + bank.getAccount() + " , 餘額: " + bank.getAmount());
		int recentAmount = bank.getAmount();
		recentAmount += depositAmount;
		bank.setAmount(recentAmount);
		System.out.println("存款" + depositAmount + "元 已完成");
		System.out.println("帳戶: " + bank.getAccount() + " , 餘額: " + bank.getAmount());
	}

	@Override
	public void withDraw(Bank bank, int withdrawAmount) {
		String account = bank.getAccount();
		if(account == null || account.isBlank()) {
			System.out.println("您的帳號不得為空或null");
			return;
		}
		if(withdrawAmount <= 0) {
			System.out.println("提款金額不得少於1");
			return;
		}
		System.out.println("帳戶: " + bank.getAccount() + " , 餘額: " + bank.getAmount());
		int recentAmount = bank.getAmount();
		if(bank.getAmount() >= withdrawAmount) {
			recentAmount -= withdrawAmount;
			System.out.println("提款: " + withdrawAmount + "元");
			System.out.println("提款完成");
		} else {
			System.out.println("提款: " + withdrawAmount + "元");
			System.out.println("提款失敗 , 您的餘額不足!");
		}
		bank.setAmount(recentAmount);
		System.out.println("帳戶: " + bank.getAccount() + " , 餘額: " + bank.getAmount());
	}

	@Override
	public void createAccountAndPwd(String account, String pwd) {
		// TODO Auto-generated method stub
		
	}

}
