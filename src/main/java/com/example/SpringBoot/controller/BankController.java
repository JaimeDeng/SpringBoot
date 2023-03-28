package com.example.SpringBoot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot.entity.*;
import com.example.SpringBoot.service.BankService;
import com.example.SpringBoot.service.CustomerService;
import com.example.SpringBoot.vo.BankRequest;
import com.example.SpringBoot.vo.BankResponse;

@RestController
public class BankController {

	@Autowired
	private BankService bs;
	
//	@CrossOrigin
//	@PostMapping(value = "/bs" , 
//			consumes = MediaType.APPLICATION_JSON_VALUE ,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(value = "/getAmount" , method = RequestMethod.POST)
	
	@PostMapping("/getAmount")	//等同於method = POST
	public BankResponse getAmount(@RequestBody BankRequest bankRequest) {	//帳號密碼由外部匯入
		BankResponse br = new BankResponse();
		br = bs.getAmount(bankRequest);
		return br;
	}
}
