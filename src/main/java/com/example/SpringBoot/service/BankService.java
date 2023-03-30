package com.example.SpringBoot.service;

import org.springframework.stereotype.Repository;

import com.example.SpringBoot.entity.Bank;
import com.example.SpringBoot.vo.BankRequest;
import com.example.SpringBoot.vo.BankResponse;
import com.example.SpringBoot.vo.BankUpdateRequest;

public interface BankService {
	
	public BankResponse createAccountAndPwd(BankRequest bankRequest);
	public BankResponse getAmount(BankRequest bankRequest);
	public BankResponse deposit(BankRequest bankRequest);
	public BankResponse withdraw(BankRequest bankRequest);
	public BankResponse updatePassword(BankUpdateRequest bankUpdateRequest);
	
}