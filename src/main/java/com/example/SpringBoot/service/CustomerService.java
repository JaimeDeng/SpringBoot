package com.example.SpringBoot.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.entity.Customer;

@Service
public class CustomerService{
	private static List list = new ArrayList<>();
	static {
		Customer c = new Customer();
		c.setId(1L);
		c.setName("張嘉航");
		c.setCreat_time("2023/3/23");
		list.add(c);
		
		c = new Customer();
		c.setId(2L);
		c.setName("陌生人");
		c.setCreat_time("2023/3/23");
		list.add(c);
		
		c = new Customer();
		c.setId(3L);
		c.setName("OO3");
		c.setCreat_time("2023/3/23");
		list.add(c);
	}
	
	public List getCustomerList() {
		return list;
	}
}
