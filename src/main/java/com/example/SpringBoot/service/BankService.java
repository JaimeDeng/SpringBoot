package com.example.SpringBoot.service;

import org.springframework.stereotype.Repository;

import com.example.SpringBoot.entity.Bank;
import com.example.SpringBoot.vo.BankRequest;
import com.example.SpringBoot.vo.BankResponse;

@Repository
public interface BankService {
	
	public void createAccountAndPwd(String account , String pwd);
	public BankResponse getAmount(BankRequest bankRequest);
	public void deposit(Bank bank , int depositAmount);
	public void withDraw(Bank bank , int withdrawAmount);
	
}