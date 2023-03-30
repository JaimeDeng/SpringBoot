package com.example.SpringBoot.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.example.SpringBoot.entity.Bank;
import com.example.SpringBoot.entity.Menu;
import com.example.SpringBoot.vo.OrderRequest;
import com.example.SpringBoot.vo.OrderResponse;

public interface OrderService {
	
	public OrderResponse setMenu(OrderRequest orderReq);
	public List menuInfo();
	public OrderResponse order(OrderRequest orderReq);
	public List menuInfoByPriceLowerThan();
	
}
