package com.example.SpringBoot.service;

import java.util.LinkedHashMap;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.example.SpringBoot.entity.Bank;
import com.example.SpringBoot.entity.Menu;

@Repository
public interface OrderService {
	
	public void setMenu(String name , int menuPrice);
//	public void orderScan();
	public void menuInfo();
	public void order(LinkedHashMap orderMap);
	
}
