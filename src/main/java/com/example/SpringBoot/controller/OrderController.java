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
import com.example.SpringBoot.repository.MenuDao;
import com.example.SpringBoot.service.BankService;
import com.example.SpringBoot.service.OrderService;
import com.example.SpringBoot.vo.BankRequest;
import com.example.SpringBoot.vo.BankResponse;
import com.example.SpringBoot.vo.OrderRequest;
import com.example.SpringBoot.vo.OrderResponse;

//@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired MenuDao menuDao;
	
	OrderResponse orderRes  = new OrderResponse();
	
	@PostMapping("/setMenu")	//等同於method = POST
	public OrderResponse setMenu(@RequestBody OrderRequest orderReq) {
		orderRes = orderService.setMenu(orderReq);
		return orderRes;
	}
	
	@PostMapping("/order")	//等同於method = POST
	public OrderResponse order(@RequestBody OrderRequest orderReq) {
		orderRes = orderService.order(orderReq);
		return orderRes;
	}
	
	@PostMapping("/menuInfo")	//等同於method = POST
	public List menuInfo() {
		List list = new ArrayList<>();
		list = orderService.menuInfo();
		return list;
	}
	
	@PostMapping("/menuInfoByPriceLowerThan")	//等同於method = POST
	public List menuInfoByPriceLowerThan() {
		List list = new ArrayList<>();
		list = orderService.menuInfoByPriceLowerThan();
		return list;
	}

}
