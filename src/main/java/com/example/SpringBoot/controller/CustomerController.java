package com.example.SpringBoot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot.entity.Bank;
import com.example.SpringBoot.entity.Bird;
import com.example.SpringBoot.entity.Customer;
import com.example.SpringBoot.service.BankService;
import com.example.SpringBoot.service.CustomerService;

public class CustomerController {
		
		@Autowired
		CustomerService cService;
		
		@GetMapping("/customers")
		public List getList() {
			return cService.getCustomerList();
		}
		
}