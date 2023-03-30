package com.example.SpringBoot.service;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.SpringBoot.entity.Bank;
import com.example.SpringBoot.repository.BankDao;
import com.example.SpringBoot.vo.BankRequest;
import com.example.SpringBoot.vo.BankResponse;
import com.example.SpringBoot.vo.BankUpdateRequest;


@Service
public class BankServiceImpl implements BankService {
	
	Bank bank = new Bank();
	
	@Autowired
	BankDao bankDao;

	@Override
	public BankResponse getAmount(BankRequest bankRequest) {
		// 1. 撈DB確認資料->帳號 . 密碼 (但目前沒有DB , 先自製資料)
		BankResponse br = new BankResponse();
		String account = bankRequest.getAccount();
		String pwd = bankRequest.getPwd();
		
		if(bankDao.findAll().isEmpty()) {
			br.message = "Database尚未有帳號存在";
			return br;
		}else {
		    if(checkAccount(account , pwd)) {
		    	br.message = account + "登入成功!";
		    	System.out.println("登入成功!");
				br.setAccount(account);
				int balance = bankDao.getById(account).getBalance();
				bank.setAll(account, pwd, balance);
				br.setBalance(balance);
				return br;
		    }else {
				br.message = "帳號或密碼錯誤";
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
		
		if(bankDao.findAll().isEmpty()) {
			br.message = "尚未有帳號存在";
			return br;
		}else {
			if(!bankDao.existsById(account)){
		    	br.message = "無此帳號";
		    	System.out.println("無此帳號");
		    	return br;
			}
		    if(checkAccount(account , pwd)){
		    	int balance = bankDao.getById(account).getBalance();
		    	balance = amount + balance;
		    	bank.setAll(account, pwd, balance);
		    	br.message = "登入成功 , 存款" + amount + "元";
		    	System.out.println("登入成功 , 存款" + amount + "元");
		    	br.setAccount(bankRequest.getAccount());
		    	br.setBalance(balance);
		    	bankDao.save(bank);
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
		
		if(bankDao.findAll().isEmpty()) {
			br.message = "尚未有帳號存在";
			return br;
		}else {
			if(!bankDao.existsById(account)){
		    	br.message = "無此帳號";
		    	System.out.println("無此帳號");
		    	return br;
			}
			if(amount <= 0) {
				br.message = "提款金額不得低於1元";
				return br;
			}
			int balance = bankDao.getById(account).getBalance();
			    if(checkAccount(account , pwd)){
				if(balance >= amount) {
					balance -= amount;
					System.out.println("登入成功 , 提款: " + amount + "元");
					bank.setBalance(balance);
					System.out.println("提款完成");
					br.message = "登入成功 , 提款"  + amount + "元";
					bank.setAll(account, pwd, balance);
					br.setAccount(account);
					br.setBalance(balance);
					bankDao.save(bank);
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
		
		if(bankDao.existsById(account)) {
			br.message = "該帳號已存在";
			return br;
		}
		if(StringUtils.hasText(account)
				&& StringUtils.hasText(pwd)) {
			bank.setAll(account, pwd, 0);
			System.out.println("帳號密碼設置完成!");
			br.setAccount(account);
			br.setPwd(pwd);
			bankDao.save(bank);
			br.message = "帳號密碼設置完成!";
		}else {
			br.message = "failed : illegal format";
		}
		return br;
	}
	
	public BankResponse updatePassword(BankUpdateRequest bankUpdateReq) {
		BankResponse br = new BankResponse();
		String reqAccount = bankUpdateReq.getAccount();
		String reqPwd = bankUpdateReq.getOldPwd();
		String reqNewPwd = bankUpdateReq.getNewPwd();
		
		if(bankDao.findAll().isEmpty()) {
			br.message = "尚未有帳號存在";
			return br;
		}else {
			if(!bankDao.existsById(reqAccount)){
		    	br.message = "無此帳號";
		    	System.out.println("無此帳號");
		    	return br;
			}
		}
		if(checkAccount(reqAccount , reqPwd) && StringUtils.hasText(reqNewPwd)){
			int balance = bankDao.getById(reqAccount).getBalance();
			bank.setAll(reqAccount, reqNewPwd, balance);
			bankDao.save(bank);
			br.message = "密碼變更完成";
		}else if(!StringUtils.hasText(reqNewPwd)) {
			br.message = "新密碼設置不得為空或null";
			return br;
		}else {
			br.message = "帳號或密碼有誤!";
			return br;
		}
		return br;
	}
	
	//帳密確認功能
	private boolean checkAccount(String account , String pwd) {
	    if(bankDao.existsById(account) && bankDao.getById(account).getPwd().equals(pwd)) {
	    	return true;
	    }
			return false;
		}
	
}
