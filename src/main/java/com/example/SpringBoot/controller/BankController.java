package com.example.SpringBoot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot.entity.*;
import com.example.SpringBoot.repository.BankDao;
import com.example.SpringBoot.service.BankService;
import com.example.SpringBoot.vo.BankRequest;
import com.example.SpringBoot.vo.BankResponse;

@RestController
public class BankController {

	@Autowired
	private BankService bs;
	
	@Autowired BankDao bankDao;
	
	Bank bank = new Bank();
	
	@PostMapping("/getBalance")	//等同於method = POST
	public BankResponse getAmount(@RequestBody BankRequest bankRequest) {
		BankResponse br = new BankResponse();
		br = bs.getAmount(bankRequest);
		return br;
	}
	
	@PostMapping("/setAccount")	//等同於method = POST
	public BankResponse createAccountAndPwd(@RequestBody BankRequest bankRequest) {
		BankResponse br = new BankResponse();
		br = bs.createAccountAndPwd(bankRequest);
		return br;
	}
	
	@PostMapping("/deposit")	//等同於method = POST
	public BankResponse deposit(@RequestBody BankRequest bankRequest) {
		BankResponse br = new BankResponse();
		br = bs.deposit(bankRequest);
		return br;
	}
	@PostMapping("/withdraw")	//等同於method = POST
	public BankResponse withdraw(@RequestBody BankRequest bankRequest) {
		BankResponse br = new BankResponse();
		br = bs.withdraw(bankRequest);
		return br;
	}
	
	@PostMapping("/list")	//等同於method = POST
	public List list() {
		var list = new ArrayList<>(bankDao.findAll());
		return list;
	}


}
